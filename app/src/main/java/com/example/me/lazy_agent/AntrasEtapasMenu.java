package com.example.me.lazy_agent;

import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.graphics.Point;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.SimpleCursorAdapter;

/**
 * Created by Paladin on 10/26/2014.
 */
public class AntrasEtapasMenu extends FragmentActivity {

    private static int width;
    private static FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.antras_etapas_menu);

        Point point =  new Point();
        getWindowManager().getDefaultDisplay().getSize(point);
        width = point.x;
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = getSupportManager().beginTransaction();

       getWindow().getDecorView().getRootView().setKeepScreenOn(true);

        fragmentTransaction.replace(R.id.place_holder,PasinaudokManim.instance);
        //fragmentTransaction.replace(R.id.fragment_holder,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    public static FragmentManager getSupportManager()
    {
        return fragmentManager;
    }
    public static class PasinaudokManim extends Fragment
    {
        static Fragment instance = new PasinaudokManim();
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.antras_etapas_meu_pasinaudok_manim,container,false);
            view.setKeepScreenOn(true);
            View layout = view.findViewById(R.id.ismok_apie_mane);

            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    FragmentTransaction fragmentTransaction = getSupportManager().beginTransaction();

                    fragmentTransaction.replace(R.id.place_holder,ParameterMenu.instance);
                    fragmentTransaction.addToBackStack(null);

                    fragmentTransaction.commit();

                }
            });

            return view;
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
        }
    }
    public static class ParameterMenu extends Fragment
    {
        static Fragment instance = new ParameterMenu();
        View rootView;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            rootView = inflater.inflate(R.layout.antras_etapas_menu_telefono_duomenys,container,false); // per root view galima pagaut tevo elementus
            rootView.setKeepScreenOn(true);
            return rootView;
        }

        @Override
        public void onStart() {
            super.onStart();

            LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.skrendancios_smegenys);
            //  ImageView imageView = (ImageView) rootView.findViewById(R.id.menu_brains);
            TranslateAnimation moveLefttoRight = new TranslateAnimation(width, 0, 0, 0);
            moveLefttoRight.setDuration(1500);
          //  moveLefttoRight.setFillAfter(true);
            linearLayout.startAnimation(moveLefttoRight);

            LinearLayout linearLayout1 = (LinearLayout) rootView.findViewById(R.id.skrendantis_procas);
            TranslateAnimation moveLefttoRight1 = new TranslateAnimation(width, 0, 0, 0);
            moveLefttoRight1.setDuration(2000);
            linearLayout1.startAnimation(moveLefttoRight1);

            LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(R.id.skrendantis_foikas);
            TranslateAnimation moveLefttoRight2 = new TranslateAnimation(width, 0, 0, 0);
            moveLefttoRight2.setDuration(2500);
            linearLayout2.startAnimation(moveLefttoRight2);

            linearLayout2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getSupportManager().beginTransaction().replace(R.id.place_holder,new TreciasEtapas()).commit();
                }
            });
        }
    }
}
