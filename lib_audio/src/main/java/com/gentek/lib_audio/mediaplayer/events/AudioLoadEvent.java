package com.gentek.lib_audio.mediaplayer.events;

import com.gentek.lib_audio.mediaplayer.model.SongBean;

public class AudioLoadEvent {
  public SongBean mAudioBean;

  public AudioLoadEvent(SongBean songBean) {
    this.mAudioBean = songBean;
  }
}
