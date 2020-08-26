package com.gentek.konglingyu_music.enum_entity;

public enum CHANNEL {

  HOT_SONG ("热歌榜",0x01),

  NEW_SONG ("新歌榜",0x02),

  RECOMMENDED_DAILY ("每日推荐",0x03);


  //所有类型标识
  public static final int HOT_SONG_ID = 0x01;
  public static final int NEW_SONG_ID = 0x02;
  public static final int RECOMMENDED_DAILY_ID = 0x03;

  private final String key;
  private final int value;

  CHANNEL(String key, int value) {
    this.key = key;
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public String getKey() {
    return key;
  }
}
