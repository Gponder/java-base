package com.gponder.design.structurePattern.adapter;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/5/12 12:18
 */
public class VlcPlayer implements AdvancedMediaPlayer {

    @Override
    public void playMp4(String filename) {

    }

    @Override
    public void playVlc(String filename) {
        System.out.println("vlc playing"+filename);
    }
}
