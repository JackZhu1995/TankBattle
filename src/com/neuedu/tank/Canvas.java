package com.neuedu.tank;

import com.neuedu.bean.Material;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel{
    @Override
    public void paint(Graphics g) {
        //调用父类的paint方法进行面板清空
        super.paint(g);
        /*System.out.println(1);*/
        if(Constant.game_state == 1){
            GameStart.draw(g,this);
        }else if(Constant.game_state == 2){
            //绘制矩形
            g.fillRect(65,35,416,416);
            //绘制矩形周边相关图片
            TankRelevant.draw(g,this);
            //绘制矩形内坦克、墙等等
            Constant.myTank.draw(g,this);
            for (Material material : Constant.materials) {
                material.draw(g,this);
            }
        }
    }
}
