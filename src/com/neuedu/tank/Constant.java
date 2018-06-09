package com.neuedu.tank;

import com.neuedu.bean.*;
import com.neuedu.util.ImageUtil;

import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Constant {

    //窗口宽度
    public static final int WINDOW_WIDTH = 600;
    //窗口高度
    public static final int WINDOW_HEIGHT = 480;
    //窗口标题
    public static final String WINDOW_TITLE = "《坦克大战》 author：ミLEFT";
    //窗口图标地址
    public static final String ICON_PATH = "tankbattle/src/com/neuedu/resources/image/tank.jpg";
    //窗口图标
    public static final Image ICON = ImageUtil.getImage(ICON_PATH);
    //fps刷新率
    public static final int FPS = 60;
    //游戏状态  1:初始状态   2:进行状态   3:自定义地图状态
    public static int game_state = 1;

    //初始界面图片资源
    public static final String START_PATH = "tankbattle/src/com/neuedu/resources/image/tank_main.png";
    public static final Image START_IMAGE = ImageUtil.getImage(START_PATH);
    //坦克图片资源
    public static final String TANK_PATH = "tankbattle/src/com/neuedu/resources/image/tank_sprite.png";
    public static final Image TANK_IMAGE = ImageUtil.getImage(TANK_PATH);

    //游戏开始声音路径
    public static final String START_AUDIO_PATH = "tankbattle/src/com/neuedu/resources/audio/intro.wav";

    //游戏内的元素（敌我方坦克、墙等等）
    public static CopyOnWriteArrayList<Material> materials = new CopyOnWriteArrayList<>();

    //保留我方坦克的引用，方便操作
    public static Material myTank;


    static {
        //绘制草地
        for (int i = 0; i < 13; i++) {
            materials.add(new Grass(0+32*i,32*2,34*4,34*7));
        }
        //绘制铁墙
        for (int i = 1; i < 6; i++) {
            Wall w = new Wall(32*4+32*i,32*3,0,34*6);
            w.setAll(true);
            w.setSize_x(16);
            w.setSize_y(16);
            materials.add(w);
        }
        //左边砖
        Wall w = new Wall(0,32*5,34*18,34*5);
        w.setLeftUp(true);
        w.setLeftDown(true);
        w.setSize_x(16);
        w.setSize_y(16);
        materials.add(w);
        Wall w5 = new Wall(48,32*5,34*18,34*5);
        w5.setLeftUp(true);
        w5.setLeftDown(true);
        w5.setSize_x(16);
        w5.setSize_y(16);
        materials.add(w5);
        Wall w6 = new Wall(32*3,32*5,34*18,34*5);
        w6.setRightUp(true);
        w6.setRightDown(true);
        w6.setSize_x(16);
        w6.setSize_y(16);
        materials.add(w6);
        Wall w7 = new Wall(32,32*7,34*18,34*5);
        w7.setRightUp(true);
        w7.setLeftUp(true);
        w7.setSize_x(16);
        w7.setSize_y(16);
        materials.add(w7);
        Wall w8 = new Wall(32*2,32*7,34*18,34*5);
        w8.setLeftDown(true);
        w8.setRightDown(true);
        w8.setSize_x(16);
        w8.setSize_y(16);
        materials.add(w8);
        //中间两个海
        for (int i = 0; i < 2; i++) {
            materials.add(new Sea(32*6+32*i,32*5,0,34*7));
        }
        //右边五个砖
        for (int i = 0; i < 5; i++) {
            Wall ww = new Wall(32*8+32*i,32*5,34*18,34*5);
            ww.setAll(true);
            ww.setSize_x(16);
            ww.setSize_y(16);
            materials.add(ww);
        }
        //绘制BOSS
        materials.add(new Eagle(32*6,32*12,34*19,34*5));
        //绘制BOSS周围的墙
        Wall w1 = new Wall(32*5,32*12,34*18,34*5);
        w1.setRightUp(true);
        w1.setRightDown(true);
        w1.setSize_x(16);
        w1.setSize_y(16);
        materials.add(w1);
        Wall w2 = new Wall(32*5 + 16,32*11,34*18,34*5);
        w2.setLeftDown(true);
        w2.setRightDown(true);
        w2.setSize_x(16);
        w2.setSize_y(16);
        materials.add(w2);
        Wall w3 = new Wall(32*6 + 16,32*11,34*18,34*5);
        w3.setLeftDown(true);
        w3.setRightDown(true);
        w3.setSize_x(16);
        w3.setSize_y(16);
        materials.add(w3);
        Wall w4 = new Wall(32*7,32*12,34*18,34*5);
        w4.setLeftUp(true);
        w4.setLeftDown(true);
        w4.setSize_x(16);
        w4.setSize_y(16);
        materials.add(w4);
    }
}
