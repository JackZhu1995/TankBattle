package com.neuedu.bean;

import com.neuedu.tank.Canvas;
import com.neuedu.tank.Constant;

import java.awt.*;
import java.awt.event.KeyEvent;

public class TankSelf extends Material{

    //代表着可以可以向指定方向移动
    private boolean take_up;
    private boolean take_down;
    private boolean take_left;
    private boolean take_right;

    //记录坦克速度
    private int speed = 2;

    //记录坦克方向
    private int direction = 1;

    public TankSelf(int mx, int my, int ix, int iy) {
        super(mx, my, ix, iy);
    }

    @Override
    public void draw(Graphics g, Canvas canvas) {
        move();
        g.drawImage(Constant.TANK_IMAGE,getMx()+65,getMy()+35,getMx()+getSize_x()+65,getMy()+getSize_y()+35,
                getIx()+1 + 34 * (direction - 1) * 2,getIy()+1,getIx()+getSize_x() + 34 * (direction - 1) * 2,getIy()+getSize_y(),canvas);
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    /**
     * 坦克移动方法
     * @param
     */
    public void move(){
        //判断方向
        if(take_up && direction == 1){
            //判断能否向上走
            if(this.getMy() > 0){
                boolean boo = true;
                for (Material material : Constant.materials) {
                    //判断比较的坦克是不是自己，如果不是自己还得比较坐标和能否被穿越
                    if(this != material){
                        //判断对象是海，NPC，鹰
                        if(material instanceof Sea || material instanceof Tank_NPC || material instanceof Eagle){
                            //判断上下关系
                            if(this.getMx() > material.getMx() -32 && this.getMx() < material.getMx() + 32){
                                if(this.getMy() == material.getMy() + 32){
                                    boo = false;
                                }
                            }
                        }
                        //对象是墙，需要特殊处理
                        if(material instanceof Wall){
                            //左竖着
                            if(((Wall) material).isLeftUp() && ((Wall) material).isLeftDown() ){
                                if(this.getMx() > material.getMx() - 32 && this.getMx() < material.getMx() + 16){
                                    if(this.getMy() == material.getMy() + 32){
                                        boo = false;
                                    }
                                }
                            }
                            //上横着
                            if(((Wall) material).isLeftUp() && ((Wall) material).isRightUp() ){
                                if(this.getMx() > material.getMx() - 32 && this.getMx() < material.getMx() + 32){
                                    if(this.getMy() == material.getMy() + 16){
                                        boo = false;
                                    }
                                }
                            }
                            //右竖着
                            if(((Wall) material).isRightUp() && ((Wall) material).isRightDown()){
                                if(this.getMx() > material.getMx() - 16 && this.getMx() < material.getMx() + 32){
                                    if(this.getMy() == material.getMy() + 32){
                                        boo = false;
                                    }
                                }
                            }
                            //下横着
                            if(((Wall) material).isRightDown() && ((Wall) material).isLeftDown() ){
                                if(this.getMx() > material.getMx() - 32 && this.getMx() < material.getMx() + 32){
                                    if(this.getMy() == material.getMy() + 32){
                                        boo = false;
                                    }
                                }
                            }
                        }
                    }
                }
                if(boo){
                    setMy(getMy()-speed);
                }
            }
        }
        if(take_down && direction == 3){
            //判断能否向下走
            if(this.getMy() < 416 - 32){
                boolean boo = true;
                for (Material material : Constant.materials) {
                    //判断比较的坦克是不是自己，如果不是自己还得比较坐标和能否被穿越
                    if(this != material){
                        //判断对象是海，NPC，鹰
                        if(material instanceof Sea || material instanceof Tank_NPC || material instanceof Eagle){
                            //判断上下关系
                            if(this.getMx() > material.getMx() -32 && this.getMx() < material.getMx() + 32){
                                if(this.getMy() == material.getMy() - 32){
                                    boo = false;
                                }
                            }
                        }
                        //对象是墙，需要特殊处理
                        if(material instanceof Wall){
                            //左竖着
                            if(((Wall) material).isLeftUp() && ((Wall) material).isLeftDown() ){
                                if(this.getMx() > material.getMx() - 32 && this.getMx() < material.getMx() + 16){
                                    if(this.getMy() == material.getMy() - 32){
                                        boo = false;
                                    }
                                }
                            }
                            //上横着
                            if(((Wall) material).isLeftUp() && ((Wall) material).isRightUp() ){
                                if(this.getMx() > material.getMx() - 32 && this.getMx() < material.getMx() + 32){
                                    if(this.getMy() == material.getMy() - 32){
                                        boo = false;
                                    }
                                }
                            }
                            //右竖着
                            if(((Wall) material).isRightUp() && ((Wall) material).isRightDown()){
                                if(this.getMx() > material.getMx() - 16 && this.getMx() < material.getMx() + 32){
                                    if(this.getMy() == material.getMy() - 32){
                                        boo = false;
                                    }
                                }
                            }
                            //下横着
                            if(((Wall) material).isRightDown() && ((Wall) material).isLeftDown() ){
                                if(this.getMx() > material.getMx() - 32 && this.getMx() < material.getMx() + 32){
                                    if(this.getMy() == material.getMy() - 16){
                                        boo = false;
                                    }
                                }
                            }
                        }
                    }
                }
                if(boo){
                    setMy(getMy()+speed);
                }
            }
        }
        if(take_left && direction == 4){
            //判断能否向左走
            if(this.getMx() > 0){
                boolean boo = true;
                for (Material material : Constant.materials) {
                    //判断比较的坦克是不是自己，如果不是自己还得比较坐标和能否被穿越
                    if(this != material){
                        //判断对象是海，NPC，鹰
                        if(material instanceof Sea || material instanceof Tank_NPC || material instanceof Eagle){
                            //判断上下关系
                            if(this.getMy() > material.getMy() -32 && this.getMy() < material.getMy() + 32){
                                if(this.getMx() == material.getMx() + 32){
                                    boo = false;
                                }
                            }
                        }
                        //对象是墙，需要特殊处理
                        if(material instanceof Wall){
                            //左竖着
                            if(((Wall) material).isLeftUp() && ((Wall) material).isLeftDown() ){
                                if(this.getMy() > material.getMy() - 32 && this.getMy() < material.getMy() + 32){
                                    if(this.getMx() == material.getMx() + 16){
                                        boo = false;
                                    }
                                }
                            }
                            //上横着
                            if(((Wall) material).isLeftUp() && ((Wall) material).isRightUp() ){
                                if(this.getMy() > material.getMy() - 32 && this.getMy() < material.getMy() + 16){
                                    if(this.getMx() == material.getMx() + 32){
                                        boo = false;
                                    }
                                }
                            }
                            //右竖着
                            if(((Wall) material).isRightUp() && ((Wall) material).isRightDown()){
                                if(this.getMy() > material.getMy() - 32 && this.getMy() < material.getMy() + 32){
                                    if(this.getMx() == material.getMx() + 32){
                                        boo = false;
                                    }
                                }
                            }
                            //下横着
                            if(((Wall) material).isRightDown() && ((Wall) material).isLeftDown() ){
                                if(this.getMy() > material.getMy() - 16 && this.getMy() < material.getMy() + 32){
                                    if(this.getMx() == material.getMx() + 32){
                                        boo = false;
                                    }
                                }
                            }
                        }
                    }
                }
                if(boo){
                    setMx(getMx()-speed);
                }
            }
        }
        if(take_right && direction == 2){
            //判断能否向右走
            if(this.getMx() < 416 - 32){
                boolean boo = true;
                for (Material material : Constant.materials) {
                    //判断比较的坦克是不是自己，如果不是自己还得比较坐标和能否被穿越
                    if(this != material){
                        //判断对象是海，NPC，鹰
                        if(material instanceof Sea || material instanceof Tank_NPC || material instanceof Eagle){
                            //判断上下关系
                            if(this.getMy() > material.getMy() -32 && this.getMy() < material.getMy() + 32){
                                if(this.getMx() == material.getMx() - 32){
                                    boo = false;
                                }
                            }
                        }
                        //对象是墙，需要特殊处理
                        if(material instanceof Wall){
                            //左竖着
                            if(((Wall) material).isLeftUp() && ((Wall) material).isLeftDown() ){
                                if(this.getMy() > material.getMy() - 32 && this.getMy() < material.getMy() + 32){
                                    if(this.getMx() == material.getMx() - 32){
                                        boo = false;
                                    }
                                }
                            }
                            //上横着
                            if(((Wall) material).isLeftUp() && ((Wall) material).isRightUp() ){
                                if(this.getMy() > material.getMy() - 32 && this.getMy() < material.getMy() + 16){
                                    if(this.getMx() == material.getMx() - 32){
                                        boo = false;
                                    }
                                }
                            }
                            //右竖着
                            if(((Wall) material).isRightUp() && ((Wall) material).isRightDown()){
                                if(this.getMy() > material.getMy() - 32 && this.getMy() < material.getMy() + 32){
                                    if(this.getMx() == material.getMx() - 16){
                                        boo = false;
                                    }
                                }
                            }
                            //下横着
                            if(((Wall) material).isRightDown() && ((Wall) material).isLeftDown() ){
                                if(this.getMy() > material.getMy() - 16 && this.getMy() < material.getMy() + 32){
                                    if(this.getMx() == material.getMx() - 32){
                                        boo = false;
                                    }
                                }
                            }
                        }
                    }
                }
                if(boo){
                    setMx(getMx()+speed);
                }
            }
        }

    }

    public void setTake_up(boolean take_up) {
        this.take_up = take_up;
    }

    public void setTake_down(boolean take_down) {
        this.take_down = take_down;
    }

    public void setTake_left(boolean take_left) {
        this.take_left = take_left;
    }

    public void setTake_right(boolean take_right) {
        this.take_right = take_right;
    }
}
