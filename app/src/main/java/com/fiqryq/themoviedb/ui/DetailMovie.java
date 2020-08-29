package com.fiqryq.themoviedb.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fiqryq.themoviedb.R;
import com.fiqryq.themoviedb.util.Constant;

import java.util.Objects;

public class DetailMovie extends AppCompatActivity {

    private ImageView mPoster;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        mPoster = findViewById(R.id.detail_movie_poster);

        // Get data form intent
        Intent intent = getIntent();
        String movie_title = intent.getStringExtra("TITLE");
        String movie_poster = intent.getStringExtra("POSTER");

        getSupportActionBar().setTitle(movie_title);
        Glide.with(this).load(Constant.IMAGE_REQUEST + movie_poster).diskCacheStrategy(DiskCacheStrategy.DATA).into(mPoster);
    }
}