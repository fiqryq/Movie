package com.fiqryq.themoviedb;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.GridLayout;
import android.widget.Toast;

import com.fiqryq.themoviedb.adapter.MovieAdapter;
import com.fiqryq.themoviedb.model.Movie;
import com.fiqryq.themoviedb.network.ApiClient;
import com.fiqryq.themoviedb.network.ApiInterface;
import com.fiqryq.themoviedb.util.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Handler;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ApiInterface apiInterface;
    private RecyclerView recyclerView;
    private ArrayList<Movie.ResultsBean> arrayList;
    private MovieAdapter movieAdapter;
    private GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        getSupportActionBar().hide();
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar_home);

        recyclerView = findViewById(R.id.rvListMovie);
        arrayList = new ArrayList<>();

        movieAdapter = new MovieAdapter(getApplicationContext(),arrayList);
        gridLayoutManager = new GridLayoutManager(this,2);

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
                        movieAdapter.isShimmer = false;
                        recyclerView.setLayoutManager(gridLayoutManager);
                        recyclerView.setAdapter(movieAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setuprecyclerView(ArrayList<Movie.ResultsBean> arrayList){



    }
}