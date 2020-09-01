package com.fiqryq.themoviedb.ui;

import android.annotation.SuppressLint;
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
    private TextView mOverview, mGenre ,mTitle ,mTitleOri,mVoteAvg,mVoteCount,mRelease,mPopular,mAdult;
    private ApiInterface apiInterface;

    @SuppressLint("SetTextI18n")
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
        mTitle = findViewById(R.id.detail_movie_title);
        mTitleOri = findViewById(R.id.detail_movie_title_ori);
        mVoteAvg = findViewById(R.id.detail_movie_vote_avg);
        mRelease = findViewById(R.id.detail_movie_release);
        mVoteAvg = findViewById(R.id.detail_movie_vote_avg);
        mPopular = findViewById(R.id.detail_movie_popular);
        mVoteCount = findViewById(R.id.detail_movie_vote_count);

        // Call Api interface
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        // Get data form intent
        Intent intent = getIntent();
        String movie_title = intent.getStringExtra("TITLE");
        String movie_title_ori = intent.getStringExtra("ORI_TITLE");
        String movie_poster = intent.getStringExtra("POSTER");
        String movie_release = intent.getStringExtra("RELEASE");
        String movie_overview = intent.getStringExtra("OVERVIEW");
        int movie_vote_count = intent.getIntExtra("VOTE_COUNT",0);
        int movie_vote_avg = intent.getIntExtra("VOTE_AVG",0);
        double popular = intent.getDoubleExtra("POPULAR",0);
        int[] genre_ids = intent.getIntArrayExtra("GENRE");


        // Set Image and tittle
        getSupportActionBar().setTitle(movie_title);
        Glide.with(this).load(Constant.IMAGE_REQUEST + movie_poster).diskCacheStrategy(DiskCacheStrategy.DATA).into(mPoster);
        getGenre(genre_ids);

        // Set Text
        mOverview.setText(movie_overview);
        mTitle.setText(" : " + movie_title);
        mTitleOri.setText(" : " + movie_title_ori);
        mRelease.setText(" : " + movie_release);
        mVoteCount.setText(" : " + movie_vote_count);
        mPopular.setText(" : " + popular);
        mVoteAvg.setText(" : " + movie_vote_avg);
    }

    private void getGenre(int[] genre_ids){
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
                    mGenre.setText(" : " + genreName);
                }

            }

            @Override
            public void onFailure(Call<Genre> call, Throwable t) {
                t.getMessage();
            }
        });
    }
}