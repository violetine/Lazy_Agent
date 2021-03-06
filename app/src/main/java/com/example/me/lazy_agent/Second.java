package com.example.me.lazy_agent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Me on 10/25/14.
 */
public class Second extends Activity {

    ImageView imgBus;

    Runnable swapImage = new Runnable() {
        @Override
        public void run() {

            imgBus.setImageResource(R.drawable.deb2);
            imgBus.postDelayed(swapImage, 3000);
            imgBus.setImageResource(R.drawable.deb3);
            imgBus.postDelayed(swapImage, 3000);
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        imgBus = (ImageView) findViewById(R.id.img);

        imgBus.setImageResource(R.drawable.deb3);
        imgBus.postDelayed(swapImage, 3000);  // Add me!
        imgBus.setImageResource(R.drawable.deb1);
        imgBus.postDelayed(swapImage, 3000);  // Add me!

        Button button = (Button) findViewById(R.id.button_to_main_menu);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AntrasEtapasMenu.class));
            }
        });
    }


}
