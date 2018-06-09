package com.neuedu.tank;

import com.neuedu.bean.TankSelf;
import com.neuedu.bean.Tank_NPC;
import com.neuedu.util.AudioUtil;

import java.awt.*;
import java.awt.event.KeyEvent;

import static java.awt.Font.BOLD;

public class TankRelevant {

    //记录敌方坦克个数
    public static int enemy_num = 21;
    //记录我方坦克个数
    public static int we_num = 3;

    //游戏同时存在的NPC坦克个数
    private static int npc_num;

    public static void draw(Graphics g,Canvas canvas){
        for (int i = 0; i < enemy_num; i++) {
            //画左边
            if(i % 2 == 0){
                g.drawImage(Constant.TANK_IMAGE,523,45+17*(i/2),540,62+17*(i/2),
                        42,144,59,161,canvas);
            }else {
                g.drawImage(Constant.TANK_IMAGE,542,45+17*(i/2),559,62+17*(i/2),
                        42,144,59,161,canvas);
            }
        }

        //绘制IP图标
        g.drawImage(Constant.TANK_IMAGE,528,331,556,346,71,145,99,160,canvas);
        //绘制黄色坦克
        g.drawImage(Constant.TANK_IMAGE,528,347,542,363,350,213,364,229,canvas);
        //设置字体  字体，加粗，大小
        g.setFont(new Font("微软雅黑",BOLD,18));
        //设置字体颜色
        g.setColor(Color.black);
        //绘制我方坦克数量
        g.drawString(String.valueOf(we_num),545,362);

    }

    /**
     * 当游戏处于进行状态时按键触发的方法
     */
    public static void downKey(int keyCode){
        if(keyCode == KeyEvent.VK_W){
            ((TankSelf)(Constant.myTank)).setTake_up(true);
            ((TankSelf)(Constant.myTank)).setDirection(1);
        }
        if(keyCode == KeyEvent.VK_A){
            ((TankSelf)(Constant.myTank)).setTake_left(true);
            ((TankSelf)(Constant.myTank)).setDirection(4);
        }
        if(keyCode == KeyEvent.VK_S){
            ((TankSelf)(Constant.myTank)).setTake_down(true);
            ((TankSelf)(Constant.myTank)).setDirection(3);
        }
        if(keyCode == KeyEvent.VK_D){
            ((TankSelf)(Constant.myTank)).setTake_right(true);
            ((TankSelf)(Constant.myTank)).setDirection(2);
        }
    }

    /**
     * 处理按键抬起
     */
    public static void upKey(int keyCode){
        if(keyCode == KeyEvent.VK_W){
            ((TankSelf)(Constant.myTank)).setTake_up(false);
        }
        if(keyCode == KeyEvent.VK_A){
            ((TankSelf)(Constant.myTank)).setTake_left(false);
        }
        if(keyCode == KeyEvent.VK_S){
            ((TankSelf)(Constant.myTank)).setTake_down(false);
        }
        if(keyCode == KeyEvent.VK_D){
            ((TankSelf)(Constant.myTank)).setTake_right(false);
        }
    }

    /**
     * 生成NPC坦克
     */
    public static void newNpc(){
        if(npc_num < 4){
            if(enemy_num > 0){
                Tank_NPC tn = new Tank_NPC(0,0,0,34*2);
                Constant.materials.add(0,tn);
                enemy_num--;
                npc_num++;
            }
        }
    }

}
