package com.gentek.konglingyu_music.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.gentek.konglingyu_music.R;
import com.gentek.konglingyu_music.adapter.ExamplePagerAdapter;
import com.gentek.konglingyu_music.enum_entity.CHANNEL;
import com.gentek.lib_common_ui.base.BaseActivity;
import com.gentek.lib_common_ui.pager_indictor.ScaleTransitionPagerTitleView;
import com.gentek.lib_image_loader.app.ImageLoaderManager;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

public class HomeActivity extends BaseActivity {
    // 指定首页要出现的卡片
    private static final CHANNEL[] CHANNELS = new CHANNEL[]{CHANNEL.HOT_SONG, CHANNEL.NEW_SONG};

    @BindView(R.id.magic_indicator)
    MagicIndicator magicIndicator;
    @BindView(R.id.view_page)
    ViewPager mViewPage;
    private ExamplePagerAdapter mAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
        
        initData();
        
    }

    private void initData() {
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels;  // 屏幕宽度（像素）
        int height = metric.heightPixels;  // 屏幕高度（像素）
        float density = metric.density;  // 屏幕密度（0.75 / 1.0 / 1.5，小米4的是3.0）
        int densityDpi = metric.densityDpi;  // 屏幕密度DPI（120 / 160 / 240,小米4的是480）
        Log.d("dpi","densityDpi="+densityDpi);
    }

    private void initView() {
        mAdapter = new ExamplePagerAdapter(getSupportFragmentManager(), CHANNELS);
        mViewPage.setAdapter(mAdapter);
        initMagicIndicator();
    }

    private void initMagicIndicator() {
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return CHANNELS == null ? 0 : CHANNELS.length;
            }

            @Override
            public IPagerTitleView getTitleView(Context context, int index) {
                SimplePagerTitleView simplePagerTitleView = new ScaleTransitionPagerTitleView(context);
                simplePagerTitleView.setText(CHANNELS[index].getKey());
                simplePagerTitleView.setTextSize(16);//设置导航的文字大小
//                simplePagerTitleView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                simplePagerTitleView.setNormalColor(Color.parseColor("#999999"));//正常状态下的标题颜色
                simplePagerTitleView.setSelectedColor(Color.parseColor("#333333"));//选中的标题字体颜色
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mViewPage.setCurrentItem(index);
                    }
                });
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                return null; // 没有指示器，因为title的指示作用已经很明显了
            }

        });
        magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicator, mViewPage);
    }
}