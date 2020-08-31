package com.fiqryq.themoviedb.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fiqryq.themoviedb.R;
import com.fiqryq.themoviedb.model.Genre;
import com.fiqryq.themoviedb.network.ApiClient;
import com.fiqryq.themoviedb.network.ApiInterface;
import com.fiqryq.themoviedb.util.Constant;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailMovie extends AppCompatActivity {

    private ImageView mPoster;
    private Toolbar toolbar;
    private TextView mOverview, mGenre;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        mPoster = findViewById(R.id.detail_movie_poster);
        mOverview = findViewById(R.id.detail_movie_overview);
        mGenre = findViewById(R.id.detail_movie_genre);

        // Call Api interface
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        // Get data form intent
        Intent intent = getIntent();
        String movie_title = intent.getStringExtra("TITLE");
        String movie_poster = intent.getStringExtra("POSTER");
        String movie_overview = intent.getStringExtra("OVERVIEW");

        int[] genre_ids = intent.getIntArrayExtra("GENRE");

        Call<Genre> genreCall = apiInterface.getGenres(Constant.API_KEY, Constant.LANGUAGE);

        genreCall.enqueue(new Callback<Genre>() {
            @Override
            public void onResponse(Call<Genre> call, Response<Genre> response) {
                Genre data = response.body();

                Genre.Genres[] genres = data.getGenres();

                HashMap<Integer, String> map = new HashMap<>();

                for (int i = 0; i < genres.length; i++) {
                    map.put(genres[i].getId(), genres[i].getName());
                }

                for (int i = 0; i < genre_ids.length; i++) {
                    String genreName = map.get(genre_ids[i]);
                    mGenre.append(genreName + " ");
                }

            }

            @Override
            public void onFailure(Call<Genre> call, Throwable t) {

            }
        });

        // Set Image and tittle
        getSupportActionBar().setTitle(movie_title);
        Glide.with(this).load(Constant.IMAGE_REQUEST + movie_poster).diskCacheStrategy(DiskCacheStrategy.DATA).into(mPoster);

        // Set Text
        mOverview.setText(movie_overview);
    }
}