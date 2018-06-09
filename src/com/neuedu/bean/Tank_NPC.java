package com.neuedu.bean;

import com.neuedu.tank.Canvas;
import com.neuedu.tank.Constant;

import java.awt.*;
import java.util.Random;

public class Tank_NPC extends Material{

    //代表着可以可以向指定方向移动
    private boolean take_up = true;
    private boolean take_down = true;
    private boolean take_left = true;
    private boolean take_right = true;

    //记录坦克速度
    private int speed = 1;

    //记录坦克方向
    private int direction = 1;

    //计数器
    private int index;

    //随机数生成工具
    private Random r = new Random();

    public Tank_NPC(int mx, int my, int ix, int iy) {
        super(mx, my, ix, iy);
    }

    @Override
    public void draw(Graphics g, Canvas canvas) {

        if(index == 60){
            //通过生成随机数控制方向
            direction = r.nextInt(4) + 1;
            index = 0;
        }
        index++;

        //调用移动
        move();

        //画图
        g.drawImage(Constant.TANK_IMAGE,getMx()+65,getMy()+35,getMx()+getSize_x()+65,getMy()+getSize_y()+35,
                getIx()+1 + 34 * (direction - 1) * 2,getIy()+1,getIx()+getSize_x() + 34 * (direction - 1) * 2,getIy()+getSize_y(),canvas);

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
                        if(material instanceof Sea || material instanceof Tank_NPC || material instanceof Eagle || material instanceof TankSelf){
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
                        if(material instanceof Sea || material instanceof Tank_NPC || material instanceof Eagle || material instanceof TankSelf){
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
                        if(material instanceof Sea || material instanceof Tank_NPC || material instanceof Eagle || material instanceof TankSelf){
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
                        if(material instanceof Sea || material instanceof Tank_NPC || material instanceof Eagle || material instanceof TankSelf){
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

    public boolean isTake_up() {
        return take_up;
    }

    public void setTake_up(boolean take_up) {
        this.take_up = take_up;
    }

    public boolean isTake_down() {
        return take_down;
    }

    public void setTake_down(boolean take_down) {
        this.take_down = take_down;
    }

    public boolean isTake_left() {
        return take_left;
    }

    public void setTake_left(boolean take_left) {
        this.take_left = take_left;
    }

    public boolean isTake_right() {
        return take_right;
    }

    public void setTake_right(boolean take_right) {
        this.take_right = take_right;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
