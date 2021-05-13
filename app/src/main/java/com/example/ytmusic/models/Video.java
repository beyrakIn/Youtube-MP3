package com.example.ytmusic.models;

public class Video {
    private String kind;
    private String etag;
    private Id id;
    private Snippet snippet;


    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Snippet getSnippet() {
        return snippet;
    }

    public void setSnippet(Snippet snippet) {
        this.snippet = snippet;
    }
}

class Snippet {
    private String publishedAt;
    private String channelId;
    private String title;
    private String description;
    Thumbnails thumbnails;
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

    public Thumbnails getThumbnails() {
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

    public void setThumbnails(Thumbnails thumbnails) {
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

class Thumbnails {
    High HighObject;

    public High getHigh() {
        return HighObject;
    }


    public void setHigh(High highObject) {
        this.HighObject = highObject;
    }
}

class High {
    private String url;
    private float width;
    private float height;


    // Getter Methods

    public String getUrl() {
        return url;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    // Setter Methods

    public void setUrl(String url) {
        this.url = url;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}

class Id {
    private String kind;
    private String videoId;


    // Getter Methods

    public String getKind() {
        return kind;
    }

    public String getVideoId() {
        return videoId;
    }

    // Setter Methods

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

}
