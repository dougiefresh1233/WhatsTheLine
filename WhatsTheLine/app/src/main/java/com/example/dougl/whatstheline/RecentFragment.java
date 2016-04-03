package com.example.dougl.whatstheline;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.content.res.ResourcesCompat;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecentFragment extends ListFragment {
    private List<CardBox> mItems;        // ListView items list

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // initialize the items list
        mItems = new ArrayList<CardBox>();
        Resources resources = getResources();

        mItems.add(new CardBox(ResourcesCompat.getDrawable(resources, R.mipmap.ic_launcher, null), getString(R.string.aim), getString(R.string.aim_description), 1));
        mItems.add(new CardBox(ResourcesCompat.getDrawable(resources, R.mipmap.ic_launcher, null), getString(R.string.bebo), getString(R.string.bebo_description),1));
        mItems.add(new CardBox(ResourcesCompat.getDrawable(resources, R.mipmap.ic_launcher, null), getString(R.string.youtube), getString(R.string.youtube_description),1));
        mItems.add(new CardBox(ResourcesCompat.getDrawable(resources, R.mipmap.ic_launcher, null), getString(R.string.aim), getString(R.string.aim_description),1));
        mItems.add(new CardBox(ResourcesCompat.getDrawable(resources, R.mipmap.ic_launcher, null), getString(R.string.bebo), getString(R.string.bebo_description),1));

        // initialize and set the list adapter
        setListAdapter(new TabFragmentAdapter(getActivity(), mItems));
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // remove the dividers from the ListView of the ListFragment
        getListView().setDivider(null);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // retrieve theListView item
        CardBox item = mItems.get(position);

        // do something
        Toast.makeText(getActivity(), item.title, Toast.LENGTH_SHORT).show();
    }
}