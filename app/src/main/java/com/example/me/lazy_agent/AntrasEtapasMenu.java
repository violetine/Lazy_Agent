package com.example.me.lazy_agent;

import android.app.Fragment;
import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.graphics.Point;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.FragmentActivity;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.antras_etapas_menu);

        Point point =  new Point();
        getWindowManager().getDefaultDisplay().getSize(point);

        width = point.x;

    }
     class ListViewLoader extends ListActivity
            implements LoaderManager.LoaderCallbacks<Cursor> {

        // This is the Adapter being used to display the list's data
        SimpleCursorAdapter mAdapter;

        // These are the Contacts rows that we will retrieve
         final String[] PROJECTION = new String[] {ContactsContract.Data._ID,
                ContactsContract.Data.DISPLAY_NAME};

        // This is the select criteria
        static final String SELECTION = "((" +
                ContactsContract.Data.DISPLAY_NAME + " NOTNULL) AND (" +
                ContactsContract.Data.DISPLAY_NAME + " != '' ))";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // Create a progress bar to display while the list loads
            ProgressBar progressBar = new ProgressBar(this);
            progressBar.setLayoutParams(new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT,
                    RadioGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER));
            progressBar.setIndeterminate(true);
            getListView().setEmptyView(progressBar);

            // Must add the progress bar to the root of the layout
            ViewGroup root = (ViewGroup) findViewById(android.R.id.content);
            root.addView(progressBar);

            // For the cursor adapter, specify which columns go into which views
            String[] fromColumns = {ContactsContract.Data.DISPLAY_NAME};
            int[] toViews = {android.R.id.text1}; // The TextView in simple_list_item_1

            // Create an empty adapter we will use to display the loaded data.
            // We pass null for the cursor, then update it in onLoadFinished()
            mAdapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_1, null,
                    fromColumns, toViews, 0);
            setListAdapter(mAdapter);

            // Prepare the loader.  Either re-connect with an existing one,
            // or start a new one.
            getLoaderManager().initLoader(0, null, this);
        }

        // Called when a new Loader needs to be created
        public Loader<Cursor> onCreateLoader(int id, Bundle args) {
            // Now create and return a CursorLoader that will take care of
            // creating a Cursor for the data being displayed.
            return new CursorLoader(this, ContactsContract.Data.CONTENT_URI,
                    PROJECTION, SELECTION, null, null);
        }

        // Called when a previously created loader has finished loading
        public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
            // Swap the new cursor in.  (The framework will take care of closing the
            // old cursor once we return.)
            mAdapter.swapCursor(data);
        }

        // Called when a previously created loader is reset, making the data unavailable
        public void onLoaderReset(Loader<Cursor> loader) {
            // This is called when the last Cursor provided to onLoadFinished()
            // above is about to be closed.  We need to make sure we are no
            // longer using it.
            mAdapter.swapCursor(null);
        }

        @Override
        public void onListItemClick(ListView l, View v, int position, long id) {
            // Do something when a list item is clicked
        }
    }

    public static class ParameterMenu extends Fragment
    {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.antras_etapas_menu_telefono_duomenys,container,false); // per root view galima pagaut tevo elementus

            LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.skrendancios_smegenys);
          //  ImageView imageView = (ImageView) rootView.findViewById(R.id.menu_brains);

            TranslateAnimation moveLefttoRight = new TranslateAnimation(width, 0, 0, 0);
            moveLefttoRight.setDuration(1000);
            moveLefttoRight.setFillAfter(true);
            linearLayout.startAnimation(moveLefttoRight);

            return rootView;
        }
    }
}
