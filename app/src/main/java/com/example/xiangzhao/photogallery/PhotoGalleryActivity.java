package com.example.xiangzhao.photogallery;

import android.app.SearchManager;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;


public class PhotoGalleryActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return new PhotoGalleryFragment();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        PhotoGalleryFragment fragment = (PhotoGalleryFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragmentContainer);

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            PreferenceManager.getDefaultSharedPreferences(this)
                    .edit()
                    .putString(FlickrFetchr.PREF_SEARCH_QUERY, query)
                    .commit();
        }


        fragment.updateItems();
    }
}
