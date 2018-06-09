package com.neuedu.tank;

import com.neuedu.bean.Material;
import com.neuedu.bean.TankSelf;
import com.neuedu.util.AudioUtil;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GameStart {

    //动图切换
    private static int tank_switch = 0;
    //切换菜单
    private static int index = 1;

    /**
     * 用于画游戏初始界面
     */

    public static void draw (Graphics g,Canvas canvas) {

        tank_switch++;
        //防止超出int范围
        if(tank_switch > 100){
            tank_switch = 0;
        }

        //绘制主界面
        g.drawImage(Constant.START_IMAGE,0,0,Constant.WINDOW_WIDTH,Constant.WINDOW_HEIGHT,
                0,0,Constant.WINDOW_WIDTH,Constant.WINDOW_HEIGHT,canvas);
        //绘制一个小坦克
        if(tank_switch % 10 >= 0 && tank_switch % 10 <=4){
            g.drawImage(Constant.TANK_IMAGE,177,238+32*index,177+32,270+32*index,
                    34*2,34*8,34*3,34*9,canvas);
        }else {
            g.drawImage(Constant.TANK_IMAGE,177,238+32*index,177+32,270+32*index,
                    34*3,34*8,34*4,34*9,canvas);
        }
    }

    /**
     * 按键按下时触发
     * @param keyCode 按键编号
     */
    public static void downKey(int keyCode){
        if(keyCode == KeyEvent.VK_U){
            index++;
            if(index > 3){
                index = 1;
            }
        }else if(keyCode == KeyEvent.VK_I){
            if(index == 1){
                Twenty_Live.check();
                Constant.game_state = 2;
                //游戏开始时播放游戏声音
                AudioUtil audioUtil = new AudioUtil(Constant.START_AUDIO_PATH);
                audioUtil.play();
                //生成一个我方坦克
                Material m = new TankSelf(32*4,32*12,0,34*8);
                /*Constant.materials.add(m);*/
                Constant.myTank = m;
            }else if(index == 2){
                System.out.println("双人功能暂不开放");
            }else if(index == 3){
                System.out.println("自定义地图");
            }
        }
    }

}
