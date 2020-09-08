package com.fiqryq.themoviedb.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fiqryq.themoviedb.R;
import com.fiqryq.themoviedb.model.Movie;
import com.fiqryq.themoviedb.ui.DetailMovie;
import com.fiqryq.themoviedb.util.Constant;

import java.util.List;

public class NowPlayingAdapter extends RecyclerView.Adapter<NowPlayingAdapter.ViewHolder> {

    private Context context;
    private List<Movie.ResultsBean> mData;

    public NowPlayingAdapter(Context context, List<Movie.ResultsBean> mData) {
        this.context = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.list_movie,parent,false);
        return new NowPlayingAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String image = mData.get(position).getPoster_path();
        Glide.with(context).load(Constant.IMAGE_REQUEST + image).diskCacheStrategy(DiskCacheStrategy.DATA).into(holder.poster);

        // Send data to detail
        String title = mData.get(position).getTitle();
        String poster = mData.get(position).getBackdrop_path();
        String overview = mData.get(position).getOverview();
        int[] genreId = mData.get(position).getGenre_ids();
        String release = mData.get(position).getRelease_date();
        String ori_title = mData.get(position).getOriginal_title();
        String ori_lang = mData.get(position).getOriginal_language();
        int vote_count = mData.get(position).getVote_count();
        int vote_avg = (int) mData.get(position).getVote_average();
        Double popular = mData.get(position).getPopularity();

        holder.cardMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailMovie.class);
                intent.putExtra("TITLE",title);
                intent.putExtra("POSTER",poster);
                intent.putExtra("OVERVIEW",overview);
                intent.putExtra("GENRE", genreId);
                intent.putExtra("RELEASE", release);
                intent.putExtra("ORI_TITLE",ori_title);
                intent.putExtra("TITLE",title);
                intent.putExtra("ORI_LANG",ori_lang);
                intent.putExtra("VOTE_COUNT",vote_count);
                intent.putExtra("VOTE_AVG",vote_avg);
                intent.putExtra("POPULAR",popular);

                context.startActivity(intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView poster;
        private LinearLayout cardMovie;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardMovie = itemView.findViewById(R.id.card_view_movie);
            poster = itemView.findViewById(R.id.movie_poster);
        }
    }
}
