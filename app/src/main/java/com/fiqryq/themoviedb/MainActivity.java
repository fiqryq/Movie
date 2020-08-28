package com.fiqryq.themoviedb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.fiqryq.themoviedb.adapter.MovieAdapter;
import com.fiqryq.themoviedb.model.Movie;
import com.fiqryq.themoviedb.network.ApiClient;
import com.fiqryq.themoviedb.network.ApiInterface;
import com.fiqryq.themoviedb.util.Constant;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ApiInterface apiInterface;
    private RecyclerView recyclerView;
    private ArrayList<Movie.ResultsBean> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvListMovie);
        arrayList = new ArrayList<Movie.ResultsBean>();

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        getMovie();
    }

    private void getMovie(){
        Call<Movie> call = apiInterface.getMovies(Constant.CATEGORY,Constant.API_KEY,Constant.LANGUAGE,Constant.PAGE);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                Movie movie = response.body();

                if (response.body().getTotal_results() != 0){
                    for (int i = 0; i <movie.getResults().size() ; i++) {
                        List<Movie.ResultsBean> list = movie.getResults();
                        Movie.ResultsBean movieList = list.get(i);
                        arrayList.add(movieList);
                    }
                } setuprecyclerView(arrayList);

            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {

            }
        });
    }

    private void setuprecyclerView(ArrayList<Movie.ResultsBean> arrayList){
        MovieAdapter movieAdapter = new MovieAdapter(getApplicationContext(),arrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(movieAdapter);
    }
}