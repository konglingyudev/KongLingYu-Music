package com.gentek.konglingyu_music.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Url工厂  用于生产url
 */
public class UrlFactory {

    /**
     * 获取  通过id拿到songinfo的url 地址
     *
     * @param songId
     * @return
     */
    public static String getSongInfoUrl(String songId) {
        String url = "http://tingapi.ting.baidu.com/v1/restserver/ting?format=json&calback=&from=webapp_music&method=baidu.ting.song.play&songid=" + songId;
        return url;
    }

    /**
     * 返回用于访问热歌榜列表的url路径
     *
     * @param offset
     * @param size
     * @return
     */
    public static String getMusicListUrl(int type,int offset, int size) {
        String url = "http://tingapi.ting.baidu.com/v1/restserver/ting?from=qianqian&version=2.1.0&method=baidu.ting.billboard.billList&format=json&type="+type+"&offset="+offset+"&size="+size;
        return url;
    }


    /**
     * 搜索音乐的url地址
     *
     * @param keyword
     * @return
     */
    public static String getSearchMusicUrl(String keyword) {
        try {
            keyword = URLEncoder.encode(keyword, "utf-8");
            String url = "http://tingapi.ting.baidu.com/v1/restserver/ting?from=qianqian&version=2.1.0&method=baidu.ting.search.common&format=json&query=" + keyword + "&page_no=1&page_size=100";
            return url;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

}

