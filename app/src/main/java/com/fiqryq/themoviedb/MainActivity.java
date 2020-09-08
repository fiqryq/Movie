package com.fiqryq.themoviedb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.fiqryq.themoviedb.adapter.NowPlayingAdapter;
import com.fiqryq.themoviedb.adapter.TopRatedAdapter;
import com.fiqryq.themoviedb.adapter.PopularAdapter;
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

    // init RecyclerVIew
    private RecyclerView recyclerViewTopRated , recyclerViewPopular , recyclerViewNowPlaying;

    // Init Arraylist
    private ArrayList<Movie.ResultsBean> arrayListTopRated , arrayListPopular, arrayListNowPlaying;

    // Adapter Category
    private TopRatedAdapter topRatedAdapter;
    private PopularAdapter popularAdapter;
    private NowPlayingAdapter nowPlayingAdapter;

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

        // Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        // getSupportActionBar().setCustomView(R.layout.custom_actionbar_home);

        // Set Flag layout No limit (full frame layout)
        Objects.requireNonNull(getSupportActionBar()).hide();
        // getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        // Init Recyclerview
        recyclerViewTopRated = findViewById(R.id.rvTopRated);
        recyclerViewPopular = findViewById(R.id.rvPopular);
        recyclerViewNowPlaying = findViewById(R.id.rvNowPlaying);

        // Init Arraylist
        arrayListTopRated = new ArrayList<>();
        arrayListPopular = new ArrayList<>();
        arrayListNowPlaying = new ArrayList<>();

        // Init Adapter
        topRatedAdapter = new TopRatedAdapter(getApplicationContext(), arrayListTopRated);
        popularAdapter = new PopularAdapter(getApplicationContext(),arrayListPopular);
        nowPlayingAdapter = new NowPlayingAdapter(getApplicationContext(),arrayListNowPlaying);

        // Init interface
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        // Get Metode
        getPoster();
        getMovieTopRated();
        getMoviePopular();
        getMovieNowPlaying();
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

                        Slider.add(new SlideModel(Constant.IMAGE_REQUEST + movieList.getBackdrop_path()));

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

    // Get Category
    private void getMovieTopRated() {
        Call<Movie> call = apiInterface.getMovies(Constant.CATEGORY_TOP_RATED, Constant.API_KEY, Constant.LANGUAGE, Constant.PAGE);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                Movie movie = response.body();
                if (response.body().getTotal_results() != 0) {
                    for (int i = 0; i < movie.getResults().size(); i++) {
                        List<Movie.ResultsBean> list = movie.getResults();
                        Movie.ResultsBean movieList = list.get(i);
                        arrayListTopRated.add(movieList);
                        recyclerViewTopRated.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
                        recyclerViewTopRated.setAdapter(topRatedAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                t.getMessage();
            }
        });
    }
    private void getMoviePopular() {
        Call<Movie> call = apiInterface.getMovies(Constant.CATEGORY_POPULAR, Constant.API_KEY, Constant.LANGUAGE, Constant.PAGE);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                Movie movie = response.body();
                if (response.body().getTotal_results() != 0) {
                    for (int i = 0; i < movie.getResults().size(); i++) {
                        List<Movie.ResultsBean> list = movie.getResults();
                        Movie.ResultsBean movieList = list.get(i);
                        arrayListPopular.add(movieList);
                        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
                        recyclerViewPopular.setAdapter(popularAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                t.getMessage();
            }
        });
    }
    private void getMovieNowPlaying() {
        Call<Movie> call = apiInterface.getMovies(Constant.CATEGORY_NOW_PLAYING, Constant.API_KEY, Constant.LANGUAGE, Constant.PAGE);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                Movie movie = response.body();
                if (response.body().getTotal_results() != 0) {
                    for (int i = 0; i < movie.getResults().size(); i++) {
                        List<Movie.ResultsBean> list = movie.getResults();
                        Movie.ResultsBean movieList = list.get(i);
                        arrayListNowPlaying.add(movieList);
                        recyclerViewNowPlaying.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
                        recyclerViewNowPlaying.setAdapter(nowPlayingAdapter);
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
