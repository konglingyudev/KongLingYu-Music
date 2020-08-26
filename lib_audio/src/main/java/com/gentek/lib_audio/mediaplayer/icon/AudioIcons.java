package com.gentek.lib_audio.mediaplayer.icon;

import com.joanzapata.iconify.Icon;

public enum AudioIcons implements Icon {

    icon_play_a('\ue606'),
    icon_pause_a('\ue60c'),
    icon_list_a('\ue61d'),

    icon_play('\ue61a'),
    icon_pause('\ue61b'),

    icon_single_loop('\ue649'),
    icon_list_loop('\ue64b'),
    icon_random_loop('\ue64c'),

    icon_collection('\ue618'),
    icon_delete('\ue617');




    private char character;

    AudioIcons(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }
}
