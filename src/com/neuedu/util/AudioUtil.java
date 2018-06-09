package com.neuedu.util;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AudioUtil {

    //声音路径
    private String audio_path;
    private AudioClip clip;

    public AudioUtil(String audio_path) {
        this.audio_path = audio_path;
    }

    //播放
    public void play(){
        //启动线程去执行音频播放
        new Thread(){
            @Override
            public void run() {
                setClip();
                clip.play();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    //循环播放
    public void loop(){
        new Thread(){
            @Override
            public void run() {
                setClip();
                clip.loop();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    //停止播放
    public void stop(){
        clip.stop();
    }

    //设置clip对象
    private void setClip(){
        File file = new File(audio_path);
        URL url = null;
        try {
            url = file.toURI().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        clip = Applet.newAudioClip(url);
    }

}
