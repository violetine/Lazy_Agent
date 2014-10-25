package com.example.me.lazy_agent;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/**
 * Created by Paladin on 10/25/2014.
 */
public class TestAntrasLangas extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_antras_langas);

        StatePageAdapter statePageAdapter = new StatePageAdapter(getSupportFragmentManager());

        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);

        viewPager.setAdapter(statePageAdapter);

    }

    class StatePageAdapter extends FragmentStatePagerAdapter
    {
        StatePageAdapter(FragmentManager fragmentManager)
        {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position)
            {
                case 0 :


                    return new Pirmas();
                case 1 :


                    return new Antras();
//                case 2 :
//                    Fragment trecias = new Trecias();
//
//                    return trecias;
            }

            Fragment pirmas = new Pirmas();

            return pirmas;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "PIRMAS";
        }
    }

    public static class Pirmas extends Fragment
    {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.antras_pirmas,container,false); // per root view galima pagaut tevo elementus

            return rootView;
        }
    }
    public static class Antras extends Fragment
    {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.antras_antras,container,false); // per root view galima pagaut tevo elementus

            return rootView;
        }
    }

//    public static class Trecias extends Fragment
//    {
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//
//            View rootView = inflater.inflate(R.layout.,container,false); // per root view galima pagaut tevo elementus
//
//            return rootView;
//        }
//    }

}
