package com.gponder.design.structurePattern.adapter;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/5/12 12:19
 */
public class MediaPlayerAdapter implements MediaPlayer {

    private AdvancedMediaPlayer advancedMediaPlayer;

    public MediaPlayerAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) {
            this.advancedMediaPlayer = new VlcPlayer();
        }else if (audioType.equalsIgnoreCase("mp4")) {
            this.advancedMediaPlayer = new Mp4Player();
        }
    }


    @Override
    public void play(String audioType, String filename) {
        if (audioType.equalsIgnoreCase("vlc")){
            advancedMediaPlayer.playVlc(filename);
        }else if (audioType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer.playMp4(filename);
        }
    }
}
