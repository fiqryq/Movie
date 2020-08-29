package com.fiqryq.themoviedb.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.fiqryq.themoviedb.R;
import com.fiqryq.themoviedb.model.Movie;
import com.fiqryq.themoviedb.ui.DetailMovie;
import com.fiqryq.themoviedb.util.Constant;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private Context context;
    private List<Movie.ResultsBean> mData;
//    boolean isShimmer = true;
//    int shimmerNumber = 5;

    public MovieAdapter(Context context, List<Movie.ResultsBean> mData) {
        this.context = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.list_movie,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

//        if (isShimmer){
//            holder.shimmerFrameLayout.startShimmer();
//        } else {
//
//        }

//        holder.shimmerFrameLayout.stopShimmer();
//        holder.shimmerFrameLayout.setShimmer(null);
        holder.title.setText(mData.get(position).getTitle());
        holder.movie_release.setText(mData.get(position).getRelease_date());
        String image = mData.get(position).getPoster_path();
        Glide.with(context).load(Constant.IMAGE_REQUEST + image).diskCacheStrategy(DiskCacheStrategy.DATA).into(holder.poster);

        String title = mData.get(position).getTitle();
        String poster = mData.get(position).getPoster_path();

        holder.cardMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailMovie.class);
                intent.putExtra("TITLE",title);
                intent.putExtra("POSTER",poster);
                context.startActivity(intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });

    }

    @Override
    public int getItemCount() {
//        return isShimmer?shimmerNumber:mData.size();
        return mData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title,movie_release;
        private ImageView poster;
        private LinearLayout cardMovie;
//        private ShimmerFrameLayout shimmerFrameLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.movie_poster);
            title = itemView.findViewById(R.id.movie_tittle);
            movie_release = itemView.findViewById(R.id.movie_release);
            cardMovie = itemView.findViewById(R.id.card_view_movie);
//            shimmerFrameLayout = itemView.findViewById(R.id.shimmer);
        }
    }
}
