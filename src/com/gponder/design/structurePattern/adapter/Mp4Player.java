package com.gponder.design.structurePattern.adapter;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/5/12 12:17
 */
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playMp4(String filename) {
        System.out.println("mp4 playing"+filename);
    }

    @Override
    public void playVlc(String filename) {

    }
}
