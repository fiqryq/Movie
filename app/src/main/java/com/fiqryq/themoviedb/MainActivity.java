package com.fiqryq.themoviedb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.fiqryq.themoviedb.adapter.MovieAdapter;
import com.fiqryq.themoviedb.model.Movie;
import com.fiqryq.themoviedb.network.ApiClient;
import com.fiqryq.themoviedb.network.ApiInterface;
import com.fiqryq.themoviedb.util.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import androidx.appcompat.widget.Toolbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ApiInterface apiInterface;
    private RecyclerView recyclerView;
    private ArrayList<Movie.ResultsBean> arrayList;
    private MovieAdapter movieAdapter;
    private GridLayoutManager gridLayoutManager;

    private Toolbar toolbar;
    private ImageSlider imageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setting Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar_home);
        imageSlider = findViewById(R.id.poster_slider);
        setSupportActionBar(toolbar);

//        Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        getSupportActionBar().setCustomView(R.layout.custom_actionbar_home);

        // Set Flag layout No limit (full frame layout)
        Objects.requireNonNull(getSupportActionBar()).hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        // Setup recyclerview
        recyclerView = findViewById(R.id.rvListMovie);
        arrayList = new ArrayList<>();

        movieAdapter = new MovieAdapter(getApplicationContext(), arrayList);
        gridLayoutManager = new GridLayoutManager(this, 2);

        // Call Api interface
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        // Get Metode
        getPoster();
        getMovie();
    }

    private void getPoster() {
        Call<Movie> call = apiInterface.getMovies(Constant.CATEGORYIMAGE, Constant.API_KEY, Constant.LANGUAGE, Constant.PAGE);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                Movie movie = response.body();
                if (response.body().getTotal_results() != 0) {

                    List<Movie.ResultsBean> list = movie.getResults();
                    // Carousel Library
                    List<SlideModel> Slider = new ArrayList<>();

                    for (int i = 0; i < movie.getResults().size(); i++) {
                        Movie.ResultsBean movieList = list.get(i);

                        Slider.add(new SlideModel(Constant.IMAGE_REQUEST + movieList.getPoster_path()));

                    }

                    imageSlider.setImageList(Slider, true);
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                t.getMessage();
            }
        });
    }

    private void getMovie() {
        Call<Movie> call = apiInterface.getMovies(Constant.CATEGORYLIST, Constant.API_KEY, Constant.LANGUAGE, Constant.PAGE);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                Movie movie = response.body();
                if (response.body().getTotal_results() != 0) {
                    for (int i = 0; i < movie.getResults().size(); i++) {
                        List<Movie.ResultsBean> list = movie.getResults();
                        Movie.ResultsBean movieList = list.get(i);
                        arrayList.add(movieList);
                        recyclerView.setLayoutManager(gridLayoutManager);
                        recyclerView.setAdapter(movieAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                t.getMessage();
            }
        });
    }

}