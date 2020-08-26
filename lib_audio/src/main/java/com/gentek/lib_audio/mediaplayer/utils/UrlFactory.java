package com.gentek.lib_audio.mediaplayer.utils;

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
}

