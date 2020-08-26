package com.gentek.konglingyu_music.bean;

public class BillboardBean {
    /**
     * billboard_type : 2
     * billboard_no : 3118
     * update_date : 2020-04-22
     * billboard_songnum : 1365
     * havemore : 1
     * name : 热歌榜
     * comment : 该榜单是根据千千音乐平台歌曲每周播放量自动生成的数据榜单，统计范围为千千音乐平台上的全部歌曲，每日更新一次
     * pic_s192 : http://business.cdn.qianqian.com/qianqian/pic/bos_client_1452f36a8dc430ccdb8f6e57be6df2ee.jpg
     * pic_s640 : http://business.cdn.qianqian.com/qianqian/pic/bos_client_361aa8612dd9dd8474daf77040f7079d.jpg
     * pic_s444 : http://hiphotos.qianqian.com/ting/pic/item/c83d70cf3bc79f3d98ca8e36b8a1cd11728b2988.jpg
     * pic_s260 : http://hiphotos.qianqian.com/ting/pic/item/838ba61ea8d3fd1f1326c83c324e251f95ca5f8c.jpg
     * pic_s210 : http://business.cdn.qianqian.com/qianqian/pic/bos_client_734232335ef76f5a05179797875817f3.jpg
     * web_url : http://music.baidu.com/top/dayhot
     * color : 0xDC5900
     * bg_color : 0xFBEFE6
     * bg_pic : http://business0.qianqian.com/qianqian/file/5bfe5026de816_689.png
     */

    private String billboard_type;
    private String billboard_no;
    private String update_date;
    private String billboard_songnum;
    private int havemore;
    private String name;
    private String comment;
    private String pic_s192;
    private String pic_s640;
    private String pic_s444;
    private String pic_s260;
    private String pic_s210;
    private String web_url;
    private String color;
    private String bg_color;
    private String bg_pic;

    public BillboardBean() {
    }

    public BillboardBean(String billboard_type, String billboard_no, String update_date, String billboard_songnum, int havemore, String name, String comment, String pic_s192, String pic_s640, String pic_s444, String pic_s260, String pic_s210, String web_url, String color, String bg_color, String bg_pic) {
        this.billboard_type = billboard_type;
        this.billboard_no = billboard_no;
        this.update_date = update_date;
        this.billboard_songnum = billboard_songnum;
        this.havemore = havemore;
        this.name = name;
        this.comment = comment;
        this.pic_s192 = pic_s192;
        this.pic_s640 = pic_s640;
        this.pic_s444 = pic_s444;
        this.pic_s260 = pic_s260;
        this.pic_s210 = pic_s210;
        this.web_url = web_url;
        this.color = color;
        this.bg_color = bg_color;
        this.bg_pic = bg_pic;
    }

    public String getBillboard_type() {
        return billboard_type;
    }

    public void setBillboard_type(String billboard_type) {
        this.billboard_type = billboard_type;
    }

    public String getBillboard_no() {
        return billboard_no;
    }

    public void setBillboard_no(String billboard_no) {
        this.billboard_no = billboard_no;
    }

    public String getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(String update_date) {
        this.update_date = update_date;
    }

    public String getBillboard_songnum() {
        return billboard_songnum;
    }

    public void setBillboard_songnum(String billboard_songnum) {
        this.billboard_songnum = billboard_songnum;
    }

    public int getHavemore() {
        return havemore;
    }

    public void setHavemore(int havemore) {
        this.havemore = havemore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPic_s192() {
        return pic_s192;
    }

    public void setPic_s192(String pic_s192) {
        this.pic_s192 = pic_s192;
    }

    public String getPic_s640() {
        return pic_s640;
    }

    public void setPic_s640(String pic_s640) {
        this.pic_s640 = pic_s640;
    }

    public String getPic_s444() {
        return pic_s444;
    }

    public void setPic_s444(String pic_s444) {
        this.pic_s444 = pic_s444;
    }

    public String getPic_s260() {
        return pic_s260;
    }

    public void setPic_s260(String pic_s260) {
        this.pic_s260 = pic_s260;
    }

    public String getPic_s210() {
        return pic_s210;
    }

    public void setPic_s210(String pic_s210) {
        this.pic_s210 = pic_s210;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBg_color() {
        return bg_color;
    }

    public void setBg_color(String bg_color) {
        this.bg_color = bg_color;
    }

    public String getBg_pic() {
        return bg_pic;
    }

    public void setBg_pic(String bg_pic) {
        this.bg_pic = bg_pic;
    }
}
