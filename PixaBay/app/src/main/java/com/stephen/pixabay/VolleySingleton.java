package com.stephen.pixabay;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {

    //Require the requestQueue
    private RequestQueue requestQueue;
    public static VolleySingleton mInstance;

    //constructor that has to take in a context (which is where the URL will be read from)
    private VolleySingleton(Context context) {
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    //method
    static synchronized VolleySingleton getmInstance(Context context) {
        //check if the instance is null
        if (mInstance == null) {
            mInstance = new VolleySingleton(context);
        }
        return mInstance;
    }

    //another method
    public RequestQueue getRequestQueue () {
        return requestQueue;
    }
}
