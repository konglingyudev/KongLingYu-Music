package com.gentek.konglingyu_music.api;


import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.gentek.konglingyu_music.bean.SongListBean;
import com.gentek.konglingyu_music.utils.UrlFactory;
import com.gentek.lib_network.listener.DisposeDataHandle;
import com.gentek.lib_network.listener.DisposeDataListener;
import com.gentek.lib_network.okhttp.CommonOkHttpClient;
import com.gentek.lib_network.request.CommonRequest;
import com.gentek.lib_network.request.RequestParams;

import java.util.List;


/**
 * 请求中心
 */
public class RequestCenter {

    static class HttpConstants {
        private static final String ROOT_URL = "http://tingapi.ting.baidu.com/v1/restserver/ting?format=json&calback=&from=webapp_music&method=";

        /**
         * 首页请求接口
         */
        private static String HOME_RECOMMAND = ROOT_URL + "/module_voice/home_recommand";

        private static String HOME_RECOMMAND_MORE = ROOT_URL + "/module_voice/home_recommand_more";

        private static String HOME_FRIEND = ROOT_URL + "/module_voice/home_friend";

        /**
         * 登陆接口
         */
        public static String LOGIN = ROOT_URL + "/module_voice/login_phone";

    }

    //根据参数发送所有post请求
    public static void getRequest(String url, RequestParams params, DisposeDataListener listener,
                                  Class<?> clazz) {
        CommonOkHttpClient.get(CommonRequest.
                createGetRequest(url, params), new DisposeDataHandle(listener, clazz));
    }

    //根据参数发送所有post请求 form表单
    public static void formPostRequest(String url, RequestParams params, DisposeDataListener listener,
                                       Class<?> clazz) {
        CommonOkHttpClient.post(CommonRequest.
                createPostRequest(url, params), new DisposeDataHandle(listener, clazz));
    }

    //json post请求
    public static void jsonPostRequest(String url, String json, DisposeDataListener listener,
                                   Class<?> clazz) {
        CommonOkHttpClient.post(CommonRequest.
                createJsonStrPostRequest(url, json), new DisposeDataHandle(listener, clazz));
    }


    /**
     * 用户登陆请求
     */
    public static void loadMusicList(int type,int offset, int size, DisposeDataListener listener) {
        RequestCenter.getRequest(UrlFactory.getMusicListUrl(type,offset,size), null, listener, SongListBean.class);
    }

}
