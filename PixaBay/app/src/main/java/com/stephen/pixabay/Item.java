package com.stephen.pixabay;

public class Item {
    private  String imageUrl, tags, photoUser;
    private int likes, theWidth, theHeight, theComment, theViews;

    //constructor

    public Item(String imageUrl, String tags, String photoUser, int likes, int theWidth, int theHeight, int theComment, int theViews) {
        this.imageUrl = imageUrl;
        this.tags = tags;
        this.photoUser = photoUser;
        this.likes = likes;
        this.theWidth = theWidth;
        this.theHeight = theHeight;
        this.theComment = theComment;
        this.theViews = theViews;
    }

    //empty constructor

    public Item() {

    }


    //getter and setter

    public String getImageUrl() { return imageUrl; }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getPhotoUser() {
        return photoUser;
    }

    public void setPhotoUser(String photoUser) {
        this.photoUser = photoUser;
    }

    public int getTheWidth() {
        return theWidth;
    }

    public void setTheWidth(int theWidth) {
        this.theWidth = theWidth;
    }

    public int getTheHeight() {
        return theHeight;
    }

    public void setTheHeight(int theHeight) {
        this.theHeight = theHeight;
    }

    public int getTheComment() {
        return theComment;
    }

    public void setTheComment(int theComment) {
        this.theComment = theComment;
    }

    public int getTheViews() {
        return theViews;
    }

    public void setTheViews(int theViews) {
        this.theViews = theViews;
    }
}
