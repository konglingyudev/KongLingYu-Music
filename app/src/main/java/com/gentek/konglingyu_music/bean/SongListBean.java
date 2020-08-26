package com.gentek.konglingyu_music.bean;

import com.gentek.lib_audio.mediaplayer.model.SongBean;

import java.util.List;

public class SongListBean {

    /**
     * song_list : [{"artist_id":"672865435","language":"国语","pic_big":"http://qukufile2.qianqian.com/data2/pic/b733a1a9fc0f63c7015be29b7b840b66/672866107/672866107.jpg@s_2,w_150,h_150","pic_small":"http://qukufile2.qianqian.com/data2/pic/b733a1a9fc0f63c7015be29b7b840b66/672866107/672866107.jpg@s_2,w_90,h_90","country":"内地","area":"0","publishtime":"2019-12-16","album_no":"1","lrclink":"http://qukufile2.qianqian.com/data2/lrc/4589294157b56806f6ff597660c84329/672866365/672866365.txt","copy_type":"1","hot":"185951","all_artist_ting_uid":"340615848","resource_type":"0","is_new":"1","rank_change":"0","rank":"1","all_artist_id":"672865435","style":"","del_status":"0","relate_status":"0","toneid":"0","all_rate":"96,128,224,320,flac","file_duration":175,"has_mv_mobile":0,"versions":"","bitrate_fee":"{\"0\":\"0|0\",\"1\":\"0|0\"}","biaoshi":"lossless,perm-1","info":"","has_filmtv":"0","si_proxycompany":"北京万上文化传媒有限公司","res_encryption_flag":"0","song_id":"672865438","title":"桥边姑娘","ting_uid":"340615848","author":"舞蹈女神诺涵","album_id":"672865436","album_title":"桥边姑娘","is_first_publish":0,"havehigh":2,"charge":0,"has_mv":0,"learn":0,"song_source":"web","piao_id":"0","korean_bb_song":"0","resource_type_ext":"0","mv_provider":"0000000000","artist_name":"舞蹈女神诺涵","pic_radio":"http://qukufile2.qianqian.com/data2/pic/b733a1a9fc0f63c7015be29b7b840b66/672866107/672866107.jpg@s_2,w_300,h_300","pic_s500":"http://qukufile2.qianqian.com/data2/pic/b733a1a9fc0f63c7015be29b7b840b66/672866107/672866107.jpg@s_2,w_500,h_500","pic_premium":"http://qukufile2.qianqian.com/data2/pic/b733a1a9fc0f63c7015be29b7b840b66/672866107/672866107.jpg@s_2,w_500,h_500","pic_huge":"http://qukufile2.qianqian.com/data2/pic/b733a1a9fc0f63c7015be29b7b840b66/672866107/672866107.jpg","album_500_500":"http://qukufile2.qianqian.com/data2/pic/b733a1a9fc0f63c7015be29b7b840b66/672866107/672866107.jpg@s_2,w_500,h_500","album_800_800":"","album_1000_1000":"http://qukufile2.qianqian.com/data2/pic/b733a1a9fc0f63c7015be29b7b840b66/672866107/672866107.jpg"}]
     * billboard : {"billboard_type":"2","billboard_no":"3118","update_date":"2020-04-22","billboard_songnum":"1365","havemore":1,"name":"热歌榜","comment":"该榜单是根据千千音乐平台歌曲每周播放量自动生成的数据榜单，统计范围为千千音乐平台上的全部歌曲，每日更新一次","pic_s192":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_1452f36a8dc430ccdb8f6e57be6df2ee.jpg","pic_s640":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_361aa8612dd9dd8474daf77040f7079d.jpg","pic_s444":"http://hiphotos.qianqian.com/ting/pic/item/c83d70cf3bc79f3d98ca8e36b8a1cd11728b2988.jpg","pic_s260":"http://hiphotos.qianqian.com/ting/pic/item/838ba61ea8d3fd1f1326c83c324e251f95ca5f8c.jpg","pic_s210":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_734232335ef76f5a05179797875817f3.jpg","web_url":"http://music.baidu.com/top/dayhot","color":"0xDC5900","bg_color":"0xFBEFE6","bg_pic":"http://business0.qianqian.com/qianqian/file/5bfe5026de816_689.png"}
     * error_code : 22000
     */

    private BillboardBean billboard;
    private int error_code;
    private List<SongBean> song_list;

    public SongListBean() {
    }

    public SongListBean(BillboardBean billboard, int error_code, List<SongBean> song_list) {
        this.billboard = billboard;
        this.error_code = error_code;
        this.song_list = song_list;
    }

    public BillboardBean getBillboard() {
        return billboard;
    }

    public void setBillboard(BillboardBean billboard) {
        this.billboard = billboard;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<SongBean> getSong_list() {
        return song_list;
    }

    public void setSong_list(List<SongBean> song_list) {
        this.song_list = song_list;
    }



}
