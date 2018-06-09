package com.neuedu.util;

import java.awt.*;

public class ImageUtil {

    public static Image getImage(String path){

        return Toolkit.getDefaultToolkit().createImage(path);
    }

}
