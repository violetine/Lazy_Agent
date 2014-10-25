package com.example.me.lazy_agent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.VideoView;


public class FirstSecond extends Activity implements SensorEventListener {

    SensorManager sm;
    long lastUpdate;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_my);

            final VideoView videoView = (VideoView) findViewById(R.id.video_view);
            String url = "android.resource://" + getPackageName() + "/" + R.raw.demo1;
            Uri uri = Uri.parse(url);

            sm = (SensorManager) getSystemService(SENSOR_SERVICE);
            lastUpdate = System.currentTimeMillis();

            videoView.setVideoURI(uri);
            videoView.requestFocus();
            videoView.start();
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


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.my, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {

            int id = item.getItemId();
            if (id == R.id.action_settings) {
                return true;
            }
            return super.onOptionsItemSelected(item);
        }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {

            getAccelerometer(event);
        }
    }

    private void getAccelerometer(SensorEvent event) {

        float[] values = event.values;

        float x = values[0];
        float y = values[1];
        float z = values[2];

        float accelationSquareRoot = (x*x + y*y + z*z)
                / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);

        long actualTime = System.currentTimeMillis();

        if (accelationSquareRoot >= 1) {

            if (actualTime-lastUpdate < 20) {

                return;
            }

            lastUpdate = actualTime;

            Toast.makeText(this, "Device was shuffled",
                    Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this, Second.class);
            startActivity(intent);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onPause() {
        // unregister listener
        super.onPause();
        sm.unregisterListener(this);
    }

    @Override
    protected void onResume() {

        super.onResume();
        sm.registerListener(this, sm.getDefaultSensor
                (Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
    }

}
