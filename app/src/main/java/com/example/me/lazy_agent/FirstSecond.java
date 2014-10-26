package com.example.me.lazy_agent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.VideoView;


public class FirstSecond extends Activity {

//    SensorManager sm;
//    long lastUpdate;

    int count;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_my);

            final VideoView videoView = (VideoView) findViewById(R.id.video_view);
            String url = "android.resource://" + getPackageName() + "/" + R.raw.mymov;
            Uri uri = Uri.parse(url);

//            sm = (SensorManager) getSystemService(SENSOR_SERVICE);
//            lastUpdate = System.currentTimeMillis();

            videoView.setVideoURI(uri);
            videoView.requestFocus();
            videoView.start();
            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    count++;
                    switch(count) {
                        case 1:
                            String url = "android.resource://" + getPackageName() + "/" + R.raw.movie;
                            Uri uri = Uri.parse(url);
                            videoView.setVideoURI(uri);
                            videoView.requestFocus();
                            videoView.start();
                            break;
                        case 2:
                            String url1 = "android.resource://" + getPackageName() + "/" + R.raw.newm;
                            Uri uri1 = Uri.parse(url1);
                            videoView.setVideoURI(uri1);
                            videoView.requestFocus();
                            videoView.start();
                            break;
                        case 3:
                            String url2 = "android.resource://" + getPackageName() + "/" + R.raw.antrasetapas;
                            Uri uri2 = Uri.parse(url2);
                            videoView.setVideoURI(uri2);
                            videoView.requestFocus();
                            videoView.start();
                            break;
                        case 4:
                            String url3 = "android.resource://" + getPackageName() + "/" + R.raw.newm;
                            Uri uri3 = Uri.parse(url3);
                            videoView.setVideoURI(uri3);
                            videoView.requestFocus();
                            videoView.start();
                            break;
                        case 5:
                            String url4 = "android.resource://" + getPackageName() + "/" + R.raw.a10001;
                            Uri uri4 = Uri.parse(url4);
                            videoView.setVideoURI(uri4);
                            videoView.requestFocus();
                            videoView.start();
                        case 6:
                            String url5 = "android.resource://" + getPackageName() + "/" + R.raw.newm;
                            Uri uri5 = Uri.parse(url5);
                            videoView.setVideoURI(uri5);
                            videoView.requestFocus();
                            videoView.start();
                            break;
                    }
                }
            });

//            sm = (SensorManager) getSystemService(SENSOR_SERVICE);
//            lastUpdate = System.currentTimeMillis();
        }
            @Override
            public boolean onTouchEvent(MotionEvent event)
            {
                final int action = event.getAction();

                if(action == MotionEvent.ACTION_DOWN) {
                    Intent intent=new Intent(this, Second.class);
                    startActivity(intent);
                }
                return super.onTouchEvent(event);
            }


//
//    @Override
//    public void onSensorChanged(SensorEvent event) {
//
//        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
//
//            //getAccelerometer(event);
//        }
//    }

//    private void getAccelerometer(SensorEvent event) {
//
//        float[] values = event.values;
//
//        float x = values[0];
//        float y = values[1];
//        float z = values[2];
//
//        float accelationSquareRoot = (x*x + y*y + z*z)
//                / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
//
//        long actualTime = System.currentTimeMillis();
//
//        if (accelationSquareRoot >= 1) {
//
//            if (actualTime-lastUpdate < 200) {
//
//                return;
//            }
//
//            lastUpdate = actualTime;
//
//            Toast.makeText(this, "Device was shuffled",
//                    Toast.LENGTH_SHORT).show();
//            Intent intent=new Intent(this, Second.class);
//            startActivity(intent);
//        }
//    }
//
//    @Override
//    public void onAccuracyChanged(Sensor sensor, int accuracy) {
//
//    }
//
//    @Override
//    protected void onPause() {
//        // unregister listener
//        super.onPause();
//        sm.unregisterListener(this);
//    }
//
//    @Override
//    protected void onResume() {
//
//        super.onResume();
//        sm.registerListener(this, sm.getDefaultSensor
//                (Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
//    }

}
