package com.example.me.lazy_agent;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;


public class MyActivity extends Activity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_my);

            Button button = (Button) findViewById(R.id.button);

            final TextView textView = (TextView) findViewById(R.id.text1);

            final VideoView videoView = (VideoView) findViewById(R.id.video_view);
            String url = "android.resource://" + getPackageName() + "/" + R.raw.demo1;
            Uri uri = Uri.parse(url);

            // nereik sito!!!
            // videoView.setMediaController(new MediaController(this));
            videoView.setVideoURI(uri);
            videoView.requestFocus();

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    videoView.start();
                    textView.setText("sucsess !");


                }
            });
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
