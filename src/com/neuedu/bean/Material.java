package com.neuedu.bean;

import com.neuedu.tank.Canvas;

import java.awt.*;

public abstract class Material {

    //自己的起始坐标
    private int mx;
    private int my;

    //设置默认尺寸
    private int size_x = 32;
    private int size_y = 32;

    //切图位置
    private int ix;
    private int iy;

    public Material(int mx, int my, int ix, int iy) {
        this.mx = mx;
        this.my = my;
        this.ix = ix;
        this.iy = iy;
    }

    public abstract void draw(Graphics g, Canvas canvas);

    public void setMx(int mx) {
        this.mx = mx;
    }

    public void setMy(int my) {
        this.my = my;
    }

    public void setSize_x(int size_x) {
        this.size_x = size_x;
    }

    public void setSize_y(int size_y) {
        this.size_y = size_y;
    }

    public void setIx(int ix) {
        this.ix = ix;
    }

    public void setIy(int iy) {
        this.iy = iy;
    }

    public int getMx() {
        return mx;
    }

    public int getMy() {
        return my;
    }

    public int getSize_x() {
        return size_x;
    }

    public int getSize_y() {
        return size_y;
    }

    public int getIx() {
        return ix;
    }

    public int getIy() {
        return iy;
    }
}
