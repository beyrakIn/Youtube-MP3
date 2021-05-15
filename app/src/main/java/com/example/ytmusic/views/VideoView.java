package com.example.ytmusic.views;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ytmusic.R;

import org.jetbrains.annotations.NotNull;

public class VideoView extends RecyclerView.ViewHolder {
    public TextView videoTitle, videoChannelName, videoPublishedDate;
    public ImageView picture;

    public VideoView(@NonNull @NotNull View itemView) {
        super(itemView);

        videoTitle = itemView.findViewById(R.id.item_title);
        videoChannelName = itemView.findViewById(R.id.item_channel_name);
        videoPublishedDate = itemView.findViewById(R.id.item_published_date);
        picture = itemView.findViewById(R.id.item_vertical_picture);
    }
}
