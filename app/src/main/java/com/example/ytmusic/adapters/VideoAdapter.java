package com.example.ytmusic.adapters;

import android.app.Dialog;
import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ytmusic.Constants;
import com.example.ytmusic.R;
import com.example.ytmusic.models.Video;
import com.example.ytmusic.views.VideoView;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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
        holder.videoChannelName.setText(video.getSnippet().getChannelTitle());
        holder.videoPublishedDate.setText(video.getSnippet().getPublishTime().substring(0, 10));

        Glide.with(holder.itemView.getContext())
                .load(video.getSnippet().getThumbnails().getHigh().getUrl())
                .into(holder.picture);

        holder.itemView.setOnClickListener(v -> {
            String url = Constants.DOWN_URL + video.getId().getVideoId();

            AppCompatActivity activity = (AppCompatActivity) v.getContext();

            Dialog dialog = new Dialog(activity);
            View view = activity.getLayoutInflater().inflate(R.layout.dialog, null);

            TextView description, yes, no;
            description = view.findViewById(R.id.description);
            yes = view.findViewById(R.id.yes);
            no = view.findViewById(R.id.no);
            description.setText(video.getSnippet().getTitle());


            yes.setOnClickListener(v1 -> {
                new Thread(() -> {

                    try {
                        String link = getUrl(url);
                        download(link, video);
                    } catch (Exception e) {
                        System.out.println(e.getLocalizedMessage());
                    }
                }).start();
                dialog.dismiss();
            });


            no.setOnClickListener(v1 -> {
                dialog.dismiss();
            });
            dialog.setContentView(view);
            dialog.show();
        });
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    public void setData(List<Video> videos) {
        this.videos = videos;
        notifyDataSetChanged();
    }


    public void download(String url, @NotNull Video video) {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
        request.setTitle("Download");
        request.setDescription(video.getSnippet().getTitle());
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_MUSIC, video.getSnippet().getTitle() + ".mp3");

        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        downloadManager.enqueue(request);
    }

    public String getUrl(String url) {
        List<String> links = new ArrayList<>();
        try {
            URL oracle = new URL(url);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(oracle.openStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.contains("<a href=\"https://www.yt-download.org/download/")) {
                    links.add(getBetweenStrings(inputLine, "href=\"", "\" class="));
                }
            }
            in.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return links.get(links.size() - 1);
    }

    public String getBetweenStrings(@NotNull String text, String textFrom, String textTo) {
        String result = text.substring(text.indexOf(textFrom) + textFrom.length());
        result = result.substring(0, result.indexOf(textTo));
        return result;
    }
}
