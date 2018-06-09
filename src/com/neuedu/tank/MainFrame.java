package com.neuedu.tank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainFrame extends JFrame{

    private int width;
    private int height;
    //窗口图标
    private Image icon;
    //fps(刷新率)
    private int fps;

    public MainFrame() throws HeadlessException {
        this(Constant.WINDOW_TITLE,Constant.WINDOW_WIDTH,Constant.WINDOW_HEIGHT,Constant.ICON,Constant.FPS);
    }

    public MainFrame(String title, int width, int height,Image icon,int fps) throws HeadlessException {
        super(title);
        this.width = width;
        this.height = height;
        this.icon = icon;
        this.fps = fps;
        init();
    }

    private void init(){
        setSize(width + 5,height + 29);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setIconImage(icon);

        //创建面板
        Canvas canvas = new Canvas();
        //设置面板背景色
        canvas.setBackground(new Color(193,193,193));
        //设置面板位置及大小
        canvas.setBounds(0,0,width,height);
        add(canvas);

        //启用线程实时刷新,每隔1000/fps秒系统自动触发事件
        new Timer(1000 / fps, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*System.out.println(1);*/
                TankRelevant.newNpc();
                //面板重新绘制
                canvas.repaint();
            }
        }).start();

        //给整个窗口设置键盘监听器
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            /**
             * 给整个窗口添加按键监听器
             * @param e
             */

            @Override
            public void keyPressed(KeyEvent e) {
                if(Constant.game_state == 1){
                    GameStart.downKey(e.getKeyCode());
                    Twenty_Live.addKey(e.getKeyCode());
                }else if(Constant.game_state == 2){

                    TankRelevant.downKey(e.getKeyCode());

                    //控制敌方坦克数量
                    /*if(e.getKeyCode() == KeyEvent.VK_DOWN){
                        TankRelevant.enemy_num--;
                        if(TankRelevant.enemy_num <= 0){
                            TankRelevant.enemy_num = 0;
                        }
                    }else if(e.getKeyCode() == KeyEvent.VK_UP){
                        TankRelevant.enemy_num++;
                        if(TankRelevant.enemy_num >= 30){
                            TankRelevant.enemy_num = 30;
                        }
                    }*/

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(Constant.game_state == 2){
                    TankRelevant.upKey(e.getKeyCode());
                }
            }
        });


        setVisible(true);
    }

}
