package com.stephen.pixabay;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

//an adapter to holder the custom adapter
public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {

    Context context;
    //assign Item class to a list
    List<Item> postList;

    //create a constructor
    public PostAdapter(Context context, List<Item> postList) {
        this.context = context;
        this.postList = postList;
    }

    @Override
    public PostHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the view(layout to use)
        View mView = LayoutInflater.from(context).inflate(R.layout.eachpost, parent, false);
        return new PostHolder(mView);
    }

    @Override
    public void onBindViewHolder(PostHolder holder, int position) {
                //instance of item class
        Item item = postList.get(position);
        //we need to set the holder to contain the items
        holder.setImageView(item.getImageUrl());
        holder.setmLikes(item.getLikes());
        holder.setmTags(item.getTags());

        //i think this is to move the details of a particular item to the next page where it can be used
        holder.imageView.setOnClickListener(view -> {
            String photoURL = item.getImageUrl();
            String theUser = item.getPhotoUser();
            String  theTag = item.getTags();
            int theLikes = item.getLikes();
            int theWidth = item.getTheWidth();
            int theHeight = item.getTheHeight();
            int theComment = item.getTheComment();
            int theViews = item.getTheViews();

            Intent intent = new Intent(context, PictureDetails.class);
            intent.putExtra("photo", photoURL);
            intent.putExtra("user", theUser);
            intent.putExtra("tag", theTag);
            intent.putExtra("likes", String.valueOf(theLikes));
            intent.putExtra("width", String.valueOf(theWidth));
            intent.putExtra("height", String.valueOf(theHeight));
            intent.putExtra("comment", String.valueOf(theComment));
            intent.putExtra("views", String.valueOf(theViews));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    //inner class called PostHolder class
    public class PostHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView mTags, mLikes;
        View view;
        public PostHolder(View itemView) {
            super(itemView);

            view = itemView;
        }

        //method for the imageview
        public void setImageView(String url){
            //link the imageview to the required id
            imageView = view.findViewById(R.id.theImage);
            //call the glide
            //glide along the context, then load the object from the url in the imageview
            //or, load the object of the url into the imageview and glide along the context
            Glide.with(context).load(url).into(imageView);
        }

        //method for the likes
        public void setmLikes(int likes) {
            mLikes = view.findViewById(R.id.theLikes);
            mLikes.setText(likes + " Likes");
        }

        //method for tags
        public void setmTags(String tag){
            mTags = view.findViewById(R.id.theTag);
            mTags.setText(tag);
        }

    }
}
