package com.neuedu.bean;

import com.neuedu.tank.Canvas;
import com.neuedu.tank.Constant;

import java.awt.*;

public class Wall extends Material{

    //记录墙该怎么画
    private boolean leftUp;
    private boolean leftDown;
    private boolean rightUp;
    private boolean rightDown;

    public Wall(int mx, int my, int ix, int iy) {
        super(mx, my, ix, iy);
    }

    @Override
    public void draw(Graphics g, Canvas canvas) {
        if(leftUp){
            g.drawImage(Constant.TANK_IMAGE,getMx()+65,getMy()+35,getMx()+getSize_x()+65,getMy()+getSize_y()+35,
                    getIx()+1,getIy()+1,getIx()+getSize_x(),getIy()+getSize_y(),canvas );
        }
        if(leftDown){
            g.drawImage(Constant.TANK_IMAGE,getMx()+65,getMy()+35+16,getMx()+getSize_x()+65,getMy()+getSize_y()+35+16,
                    getIx()+1,getIy()+1,getIx()+getSize_x(),getIy()+getSize_y(),canvas );
        }
        if(rightUp){
            g.drawImage(Constant.TANK_IMAGE,getMx()+65+16,getMy()+35,getMx()+getSize_x()+65+16,getMy()+getSize_y()+35,
                    getIx()+1,getIy()+1,getIx()+getSize_x(),getIy()+getSize_y(),canvas );
        }
        if(rightDown){
            g.drawImage(Constant.TANK_IMAGE,getMx()+65+16,getMy()+35+16,getMx()+getSize_x()+65+16,getMy()+getSize_y()+35+16,
                    getIx()+1,getIy()+1,getIx()+getSize_x(),getIy()+getSize_y(),canvas );
        }
    }

    public boolean isLeftUp() {
        return leftUp;
    }

    public void setLeftUp(boolean leftUp) {
        this.leftUp = leftUp;
    }

    public boolean isLeftDown() {
        return leftDown;
    }

    public void setLeftDown(boolean leftDown) {
        this.leftDown = leftDown;
    }

    public boolean isRightUp() {
        return rightUp;
    }

    public void setRightUp(boolean rightUp) {
        this.rightUp = rightUp;
    }

    public boolean isRightDown() {
        return rightDown;
    }

    public void setRightDown(boolean rightDown) {
        this.rightDown = rightDown;
    }
    public void setAll(boolean all){
        setRightUp(all);
        setLeftUp(all);
        setRightDown(all);
        setLeftDown(all);
    }
}
