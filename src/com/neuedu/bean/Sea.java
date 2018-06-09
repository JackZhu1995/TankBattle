package com.neuedu.bean;

import com.neuedu.tank.Canvas;
import com.neuedu.tank.Constant;

import java.awt.*;

public class Sea extends Material{

    //动态海切换
    int sea_switch = 0;

    public Sea(int mx, int my, int ix, int iy) {
        super(mx, my, ix, iy);
    }

    @Override
    public void draw(Graphics g, Canvas canvas) {
        sea_switch++;
        if(sea_switch > 1000){
            sea_switch = 0;
        }
        if(sea_switch % 30 >= 0 && sea_switch % 30 <= 14){g.drawImage(Constant.TANK_IMAGE,getMx()+65,getMy()+35,getMx()+getSize_x()+65,getMy()+getSize_y()+35,
                getIx()+1,getIy()+1,getIx()+getSize_x(),getIy()+getSize_y(),canvas);
        }else {
            g.drawImage(Constant.TANK_IMAGE,getMx()+65,getMy()+35,getMx()+getSize_x()+65,getMy()+getSize_y()+35,
                    getIx()+1 + 34,getIy()+1,getIx()+getSize_x() + 34,getIy()+getSize_y(),canvas);
        }

    }
}
