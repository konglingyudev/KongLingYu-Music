package com.gentek.konglingyu_music.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.gentek.konglingyu_music.R;
import com.gentek.konglingyu_music.adapter.MusicListAdapter;
import com.gentek.konglingyu_music.api.RequestCenter;
import com.gentek.konglingyu_music.application.MusicApplication;
import com.gentek.konglingyu_music.bean.SongListBean;
import com.gentek.lib_audio.app.AudioHelper;
import com.gentek.lib_audio.mediaplayer.model.SongBean;
import com.gentek.lib_audio.mediaplayer.view.BottomMusicView;
import com.gentek.lib_network.listener.DisposeDataListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HotSongFragment extends Fragment {

    private ListView listView;
    private MusicListAdapter adapter;
    private List<SongBean> musics;
    private SongBean currentSong;
    public static Fragment newInstance() {
        HotSongFragment fragment = new HotSongFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_music_list, null);

        listView = rootView.findViewById(R.id.listView);

        //添加监听
        setListeners();

        RequestCenter.loadMusicList(2, 0, 20, new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                SongListBean songListBean = (SongListBean) responseObj;
                Log.d("info", "onSuccess: " + songListBean.getSong_list().size());
                if (songListBean.getSong_list() != null) {
                    musics = songListBean.getSong_list();
                    final ArrayList<SongBean> arrayList=new ArrayList<>();
                    arrayList.addAll(musics);
                    AudioHelper.startMusicService(arrayList);
                }
                //更新ListView
                adapter = new MusicListAdapter(getActivity(), musics);
                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Object reasonObj) {

            }
        });

        return rootView;
    }

    private void setListeners() {
        //滚动listView
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            private boolean isBottom = false;
            private boolean dataLoading = false;

            //滚动状态改变时执行
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState) {
                    case AbsListView.OnScrollListener.SCROLL_STATE_FLING:
                        //Log.i("info", "SCROLL_STATE_FLING");
                        break;
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:
                        //Log.i("info", "SCROLL_STATE_IDLE");
                        if (isBottom) {
                            if (!dataLoading) {
                                dataLoading = true;
                                //发送请求  访问后续20条数据
                                RequestCenter.loadMusicList(2, musics.size(), 20, new DisposeDataListener() {
                                    @Override
                                    public void onSuccess(Object responseObj) {
                                        SongListBean songListBean = (SongListBean) responseObj;
                                        musics.addAll(songListBean.getSong_list());
                                        adapter.notifyDataSetChanged();
                                        dataLoading = false;
                                    }

                                    @Override
                                    public void onFailure(Object reasonObj) {

                                    }
                                });
                            }
                        }
                        break;
                    case AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:
                        //Log.i("info", "SCROLL_STATE_TOUCH_SCROLL");
                        break;
                }
            }

            //滚动时执行
            public void onScroll(AbsListView view,
                                 int firstVisibleItem,  //第一个可见项的位置
                                 int visibleItemCount,  //可见项的数量
                                 int totalItemCount     //item的总数量
            ) {
                //Log.i("info", "正在滚.....");
                if (firstVisibleItem + visibleItemCount == totalItemCount) {
                    //Log.i("info", "到底了!!!");
                    isBottom = true;
                } else {
                    isBottom = false;
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                currentSong=musics.get(position);

                AudioHelper.addAudio(getActivity(),currentSong);
            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //发请求更新UI
    }
}
