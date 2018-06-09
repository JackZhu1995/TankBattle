package com.neuedu.tank;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Twenty_Live {

    private static List<Integer> list = new ArrayList<>();

    private static List<Integer> we_num20 = new ArrayList<>();

    static {
        we_num20.add(KeyEvent.VK_W);
        we_num20.add(KeyEvent.VK_S);
        we_num20.add(KeyEvent.VK_W);
        we_num20.add(KeyEvent.VK_S);
        we_num20.add(KeyEvent.VK_A);
        we_num20.add(KeyEvent.VK_D);
        we_num20.add(KeyEvent.VK_A);
        we_num20.add(KeyEvent.VK_D);
    }

    public static void addKey(int keyCode){
        list.add(keyCode);
    }

    public static void check(){
        boolean boo = true;
        if(list.size() >= we_num20.size()){
            for (int i = 0; i < we_num20.size(); i++) {
                if(!(we_num20.get(i).equals(list.get(i)))){
                    boo = false;
                    break;
                }
            }
        }else {
            boo = false;
        }
        if (boo) {
            TankRelevant.we_num = 20;
        }
    }

}
