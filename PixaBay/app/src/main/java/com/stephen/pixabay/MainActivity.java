package com.stephen.pixabay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    //for API URL
    private RequestQueue requestQueue;
    //this list is the local list in the app file
    private List<Item> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycle);
        //so that images will not be at different sizes
        recyclerView.setHasFixedSize(true);
        //to choose the layout at which the list should display
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        requestQueue = VolleySingleton.getmInstance(this).getRequestQueue();

        //initiatize the list
        mList = new ArrayList<>();

        //calling the fetch method
        fetchData();
    }

    public void fetchData() {
        //to get the name of the image
        Intent intent = getIntent();
        String search = intent.getStringExtra("imageText");
        //to fetch from the url
        String url = "https://pixabay.com/api/?key=39960341-e5dbae16f5d7122d7ee53541f&q=" + search + "&image_type=photo&pretty=true";
        //create the json request to get the image
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //response has a lot of data from the API, so we need to just get the required data
                try {
                    JSONArray jsonArray = response.getJSONArray("hits");

                    //loop through the arrays in the hits array
                    for (int i = 0; i < jsonArray.length(); i++) {
                        //get in the first array at the position
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        //to get the objects needed to be displayed
                        //to get the image, tags and likes from the URL and put in the getter and setter in the local file, before it can be gotten to be displayed in the recycleView
                        String imageURL = jsonObject.getString("webformatURL");
                        int likes = jsonObject.getInt("likes");
                        String tagss = jsonObject.getString("tags");
                        String PhotoUser = jsonObject.getString("user");
                        int width = jsonObject.getInt("imageWidth");
                        int height = jsonObject.getInt("imageHeight");
                        int comments = jsonObject.getInt("comments");
                        int views = jsonObject.getInt("views");

                        //instance of an item and put the items gotten from the URL in the list
                        Item item = new Item(imageURL, tagss, PhotoUser, likes, width, height, comments, views);
                        mList.add(item);
                    }
                    //pass the list in local file to the adapter
                    //here we link the  adapter to the remaining body
                    PostAdapter adapter = new PostAdapter(MainActivity.this, mList);
                    //ask recycler view to get its readings from the adapter
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast to display the error
                Toast.makeText(MainActivity.this, error.getMessage() + " is an error", Toast.LENGTH_SHORT).show();
            }
        });

        //make the request queue query for the whole request
        requestQueue.add(jsonObjectRequest);
    }
}