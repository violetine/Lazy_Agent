package com.example.me.lazy_agent;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.viewpagerindicator.CirclePageIndicator;

/**
 * Created by Paladin on 10/25/2014.
 */
public class TreciasEtapas extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trecias_etapas_baze);

        StatePageAdapter statePageAdapter = new StatePageAdapter(getSupportFragmentManager());
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(statePageAdapter);

        CirclePageIndicator circlePageIndicator = (CirclePageIndicator) findViewById(R.id.circle_page_ndicator);
        circlePageIndicator.setViewPager(viewPager);

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
                case 2 :
                    return new Trecias();
            }
            Fragment pirmas = new Pirmas();

            return pirmas;
        }

        @Override
        public int getCount() {
            return 3;
        }

        Drawable myDrawable = getResources().getDrawable(R.drawable.galaxy_s5);
        @Override
        public CharSequence getPageTitle(int position) {

            SpannableStringBuilder sb = new SpannableStringBuilder(" "); // space added before text for convenience

            myDrawable.setBounds(0, 0, myDrawable.getIntrinsicWidth(), myDrawable.getIntrinsicHeight());
            ImageSpan span = new ImageSpan(myDrawable, ImageSpan.ALIGN_BASELINE);
            sb.setSpan(span, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            return "s";
        }
    }

    public static class Pirmas extends Fragment
    {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.trecias_etapas_pirmas,container,false); // per root view galima pagaut tevo elementus

            return rootView;
        }
    }
    public static class Antras extends Fragment
    {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.trecias_etapas_antras,container,false); // per root view galima pagaut tevo elementus

            return rootView;
        }
    }

    public static class Trecias extends Fragment
    {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.trecias_etapas_trecias,container,false); // per root view galima pagaut tevo elementus

            return rootView;
        }
    }

}
