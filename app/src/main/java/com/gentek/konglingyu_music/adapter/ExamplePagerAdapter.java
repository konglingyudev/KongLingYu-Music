package com.gentek.konglingyu_music.adapter;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gentek.konglingyu_music.enum_entity.CHANNEL;
import com.gentek.konglingyu_music.ui.fragment.HotSongFragment;
import com.gentek.konglingyu_music.ui.fragment.NewSongFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ExamplePagerAdapter extends FragmentPagerAdapter {
    private CHANNEL[] mList;
    public ExamplePagerAdapter(@NonNull FragmentManager fm, CHANNEL[] list) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.mList=list;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        int type = mList[position].getValue();
        Log.d("info", "getItem: "+mList[position].getKey());
        switch (type) {
            case CHANNEL.HOT_SONG_ID:
                return HotSongFragment.newInstance();
            case CHANNEL.NEW_SONG_ID:
                return NewSongFragment.newInstance();
        }
        return null;
    }


    @Override
    public int getCount() {
        return  mList == null ? 0 : mList.length;
    }
}
