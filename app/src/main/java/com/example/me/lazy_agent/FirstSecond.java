package com.example.me.lazy_agent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.VideoView;


public class FirstSecond extends Activity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_my);

            // Hide the Title Bar
//            requestWindowFeature(Window.FEATURE_NO_TITLE);

            final VideoView videoView = (VideoView) findViewById(R.id.video_view);
            String url = "android.resource://" + getPackageName() + "/" + R.raw.demo1;
            Uri uri = Uri.parse(url);

            videoView.setVideoURI(uri);
            videoView.requestFocus();
            videoView.start();
        }
            @Override
            public boolean onTouchEvent(MotionEvent event)
            {
                final int action = event.getAction();

                if(action == MotionEvent.ACTION_DOWN) {
                    Log.d("FirstSecond", "in onTouchEvent!");
                    Intent intent=new Intent(this, Second.class);
                    startActivity(intent);
                }
                return super.onTouchEvent(event);
            }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.my, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();
            if (id == R.id.action_settings) {
                return true;
            }
            return super.onOptionsItemSelected(item);
        }
}
