package com.example.ytmusic.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ytmusic.R;
import com.example.ytmusic.models.Video;
import com.example.ytmusic.views.VideoView;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.zip.Inflater;

public class VideoAdapter extends RecyclerView.Adapter<VideoView> {
    private Context context;
    private List<Video> videos;


    public VideoAdapter(Context context, List<Video> videos) {
        this.context = context;
        this.videos = videos;
    }

    @NonNull
    @NotNull
    @Override
    public VideoView onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vertical_item, parent, false);
        return new VideoView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull VideoView holder, int position) {
        Video video = videos.get(position);

        holder.videoTitle.setText(video.getSnippet().getTitle());

        Glide.with(holder.itemView.getContext())
                .load(video.getSnippet().getThumbnails().getHigh().getUrl())
                .into(holder.picture);
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    public void setData(List<Video> videos){
        this.videos = videos;
        notifyDataSetChanged();
    }
}
