package com.gentek.konglingyu_music.application;

import android.app.Application;
import android.content.Context;

import com.gentek.lib_audio.app.AudioHelper;
import com.gentek.lib_audio.mediaplayer.icon.FontAudioModule;
import com.gentek.lib_audio.mediaplayer.model.SongBean;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.joanzapata.iconify.fonts.IoniconsModule;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class MusicApplication extends Application {

    private static MusicApplication mApplication = null;
    private static Context mContext = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        mContext = this;
        //音频SDK初始化
        AudioHelper.init(this);
        //字体图标初始化
        Iconify
                .with(new FontAwesomeModule())
                .with(new IoniconsModule())
                .with(new FontAudioModule());
    }

    public static MusicApplication getInstance() {
        return mApplication;
    }
    public static Context getContext() {
        return mContext;
    }

}
