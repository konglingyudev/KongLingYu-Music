package com.gentek.lib_audio.mediaplayer.view;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gentek.lib_audio.R;
import com.gentek.lib_audio.mediaplayer.core.AudioController;
import com.gentek.lib_audio.mediaplayer.events.AudioLoadEvent;
import com.gentek.lib_audio.mediaplayer.events.AudioPauseEvent;
import com.gentek.lib_audio.mediaplayer.events.AudioProgressEvent;
import com.gentek.lib_audio.mediaplayer.events.AudioStartEvent;
import com.gentek.lib_audio.mediaplayer.model.SongBean;
import com.gentek.lib_image_loader.app.ImageLoaderManager;
import com.joanzapata.iconify.widget.IconTextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * 播放器底部View
 */
public class BottomMusicView extends RelativeLayout {

    private Context mContext;

    /*
     * View
     */
    private ImageView mLeftView;
    private TextView mTitleView;
    private TextView mAlbumView;
    private IconTextView mPlayView;
    private IconTextView mRightView;
    /*
     * data
     */
    private SongBean mSongBean;
    private ObjectAnimator mAnim;
    public BottomMusicView(Context context) {
        this(context, null);
    }

    public BottomMusicView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BottomMusicView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        EventBus.getDefault().register(this);
        initView();
    }

    private void initView() {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.bottom_view, this);
        rootView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳到音乐播放Activity
                MusicPlayerActivity.start((Activity) mContext);
            }
        });
        mLeftView = rootView.findViewById(R.id.album_view);


        // 让左侧mLeftView不停旋转
        if (mAnim ==null){
            mAnim =createAnim();
        }

        mTitleView = rootView.findViewById(R.id.audio_name_view);
        mAlbumView = rootView.findViewById(R.id.audio_album_view);
        mPlayView = rootView.findViewById(R.id.play_view);


        mPlayView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //处理播放暂停事件
                AudioController.getInstance().playOrPause();
            }
        });
        mRightView = rootView.findViewById(R.id.show_list_view);
        mRightView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //显示音乐列表对话框
                MusicListDialog dialog = new MusicListDialog(mContext);
                dialog.show();
            }
        });
    }


    private ObjectAnimator createAnim(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(mLeftView, View.ROTATION.getName(), 0f, 360);
        animator.setDuration(10000);//设定转一圈的时间
        animator.setRepeatCount(Animation.INFINITE);//设定无限循环
        animator.setRepeatMode(ObjectAnimator.RESTART);// 循环模式
        animator.setInterpolator(new LinearInterpolator());// 匀速
        return  animator;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAudioLoadEvent(AudioLoadEvent event) {
        //更新当前view为load状态
        mSongBean = event.mAudioBean;
        showLoadView();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAudioPauseEvent(AudioPauseEvent event) {
        //更新当前view为暂停状态
        showPauseView();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAudioStartEvent(AudioStartEvent event) {
        //更新当前view为播放状态
        showPlayView();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAudioProgrssEvent(AudioProgressEvent event) {
        //更新当前view的播放进度
    }

    private void showLoadView() {
        //目前loading状态的UI处理与pause逻辑一样，分开为了以后好扩展
        if (mSongBean != null) {
            ImageLoaderManager.getInstance().displayImageForCircle(mLeftView, mSongBean.getPic_premium());
            mTitleView.setText(mSongBean.getTitle());
            mAlbumView.setText(mSongBean.getAuthor());
            mPlayView.setText(R.string.pause_icon_a);
//            mPlayView.setImageResource(R.mipmap.note_btn_pause_white);
        }
    }

    private void showPauseView() {
        if (mSongBean != null) {
            mPlayView.setText(R.string.pause_icon_a);
//            mPlayView.setImageResource(R.mipmap.note_btn_play_white);
        }

        if (mAnim!=null){
            mAnim.pause();
        }
    }

    private void showPlayView() {
        if (mSongBean != null) {
            mPlayView.setText(R.string.play_icon_a);
//            mPlayView.setImageResource(R.mipmap.note_btn_pause_white);
        }
        if (mAnim != null) {
            if (mAnim.isPaused()) {
                mAnim.resume();
            } else {
                mAnim.start();
            }
        }
    }
}