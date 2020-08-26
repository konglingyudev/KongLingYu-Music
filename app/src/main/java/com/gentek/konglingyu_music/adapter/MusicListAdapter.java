package com.gentek.konglingyu_music.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.gentek.konglingyu_music.R;
import com.gentek.lib_audio.mediaplayer.model.SongBean;
import com.gentek.lib_image_loader.app.ImageLoaderManager;


import java.util.List;


public class MusicListAdapter extends BaseAdapter {
    private List<SongBean> musics;
    private LayoutInflater inflater;

    public MusicListAdapter(Context context, List<SongBean> musics) {
        this.musics = musics;
        this.inflater = LayoutInflater.from(context);
        //创建ImageLoader图片加载器
        Log.d("info", "MusicListAdapter: " + musics);
    }

    @Override
    public int getCount() {
        return musics.size();
    }

    @Override
    public SongBean getItem(int position) {
        return musics.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_lv_music, null);
            holder = new ViewHolder();
            holder.ivAlbum = convertView.findViewById(R.id.ivAlbum);
            holder.tvTitle = convertView.findViewById(R.id.tvTitle);
            holder.tvSinger = convertView.findViewById(R.id.tvSinger);
            convertView.setTag(holder);
        }
        holder = (ViewHolder) convertView.getTag();
        //给holder的控件赋值
        SongBean m = getItem(position);
        holder.tvSinger.setText(m.getAuthor());
        holder.tvTitle.setText(m.getTitle());
        ImageLoaderManager.getInstance().displayImageForView(holder.ivAlbum, m.getPic_premium());
        return convertView;
    }

    static class ViewHolder {
        ImageView ivAlbum;
        TextView tvTitle;
        TextView tvSinger;
    }

}
