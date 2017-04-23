package com.si.mynews.model.bean;

/**
 * Created by si on 16/11/27.
 */

public class NewsListBean {

    private String objectId;

    private String createdAt;

    private String title;

    private int collectionCount;

    private int commentsCount;

    private String url;

    private NewsListUserBean user;

    private NewsListScreenshotBean screenshot;

    public static class NewsListUserBean {
        private String username;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }

    public static class NewsListScreenshotBean {
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public NewsListScreenshotBean getScreenshot() {
        return screenshot;
    }

    public void setCollectionCount(int collectionCount) {
        this.collectionCount = collectionCount;
    }

    public NewsListUserBean getUser() {
        return user;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public int getCollectionCount() {
        return collectionCount;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setScreenshot(NewsListScreenshotBean screenshot) {
        this.screenshot = screenshot;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUser(NewsListUserBean user) {
        this.user = user;
    }
}
