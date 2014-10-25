package com.example.me.lazy_agent;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by Me on 10/25/14.
 */
public class Second extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Hide the Title Bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.second_layout);
    }
}
