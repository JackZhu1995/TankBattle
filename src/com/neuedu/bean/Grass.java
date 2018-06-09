package com.neuedu.bean;

import com.neuedu.tank.Canvas;
import com.neuedu.tank.Constant;

import java.awt.*;

public class Grass extends Material{

    public Grass(int mx, int my, int ix, int iy) {
        super(mx, my, ix, iy);
    }

    @Override
    public void draw(Graphics g, Canvas canvas) {
        g.drawImage(Constant.TANK_IMAGE,getMx()+65,getMy()+35,getMx()+getSize_x()+65,getMy()+getSize_y()+35,
                getIx()+1,getIy()+1,getIx()+getSize_x(),getIy()+getSize_y(),canvas);
    }
}
