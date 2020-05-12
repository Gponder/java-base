package com.gponder.design.structurePattern.adapter;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/5/12 12:40
 */
public class AudioPlayer implements MediaPlayer {
    private MediaPlayerAdapter mediaPlayerAdapter;


    @Override
    public void play(String audioType, String filename) {
        if (audioType.equalsIgnoreCase("mp3")){
            System.out.println("mp3 playing" +filename);
        } else if (audioType.equalsIgnoreCase("vlc")||
        audioType.equalsIgnoreCase("mp4")){
            new MediaPlayerAdapter(audioType).play(audioType,filename);
        }else {
            System.out.println("格式不支持"+audioType);
        }
    }

    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3","海阔天空.mp3");
        audioPlayer.play("vlc","test.vlc");
        audioPlayer.play("mp4","cjk.mp4");
        audioPlayer.play("aaa","cjk");
    }
}
