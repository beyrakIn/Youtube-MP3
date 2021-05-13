package com.example.ytmusic.models;

public class Snippet {
    private String publishedAt;
    private String channelId;
    private String title;
    private String description;
    private Thumbnail thumbnails;
    private String channelTitle;
    private String liveBroadcastContent;
    private String publishTime;


    // Getter Methods

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getChannelId() {
        return channelId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Thumbnail getThumbnails() {
        return thumbnails;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public String getLiveBroadcastContent() {
        return liveBroadcastContent;
    }

    public String getPublishTime() {
        return publishTime;
    }

    // Setter Methods

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setThumbnails(Thumbnail thumbnails) {
        this.thumbnails = thumbnails;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public void setLiveBroadcastContent(String liveBroadcastContent) {
        this.liveBroadcastContent = liveBroadcastContent;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }
}


