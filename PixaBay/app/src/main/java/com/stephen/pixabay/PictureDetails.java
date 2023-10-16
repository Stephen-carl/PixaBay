package com.stephen.pixabay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class PictureDetails extends AppCompatActivity {

    private ImageView imageView;
    private TextView tagText, likeText, userText, widthText, heightText, commentText, viewText;
    String thePhotoUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_details);

        //find the ids
        imageView = findViewById(R.id.detailsImage);
        tagText = findViewById(R.id.detailsTag);
        likeText = findViewById(R.id.detailsLike);
        userText = findViewById(R.id.detailsUser);
        widthText = findViewById(R.id.detailsWidth);
        heightText = findViewById(R.id.detailsHeight);
        commentText = findViewById(R.id.detailsComment);
        viewText = findViewById(R.id.detailsView);

        //extracted text from the adapter will be linked here bcus i've set the view to be clickable
        Bundle extras = getIntent().getExtras();
        //get the photo string (because photo is in a url string)
        thePhotoUrl = extras.getString("photo");
        Glide.with(getApplicationContext()).load(thePhotoUrl).into(imageView);
        tagText.setText(extras.getString("tag") );
        likeText.setText(extras.getString("likes") + " likes");
        userText.setText(extras.getString("user"));
        widthText.setText(extras.getString("width") + " wpx");
        heightText.setText(extras.getString("height") + " hpx");
        commentText.setText(extras.getString("comment")  + " comments");
        viewText.setText(extras.getString("views") + " views");
    }
}