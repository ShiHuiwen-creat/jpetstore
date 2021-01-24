package org.csu.mypetstore.other;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class makeCode {//用于获取四位随机数
    private char mapTable[] = {'1', '2', '3', '4', '5', '6', '7', '8', '9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','P','R','S','T','U','V','W','X','Y','Z'};

    //生成验证码,并返回随机生成的数字
    public String getEnsure(int width, int height, OutputStream os) {
        if (width <= 0)
            width = 90;
        if (height <= 0)
            height = 30;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // 获取图形上下文
        Graphics g = image.getGraphics();

        //产生随机数
        Random random = new Random();

        // 设定背景色
        g.setColor(new Color(200+random.nextInt(50), 200+random.nextInt(50), 200+random.nextInt(50)));
        g.fillRect(0, 0, width, height);

        // 取随机产生的认证码
        String strEnsure = "";

        // 4代表4位验证码
        for (int i = 0; i < 4; ++i) {
            strEnsure += mapTable[(int) (mapTable.length * Math.random())];
        }

        // 将认证码显示到图象中
        // 第一个
        g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
        g.setFont(new Font("Atlantic Inline", Font.PLAIN, 18));
        String str = strEnsure.substring(0, 1);
        g.drawString(str, 6 + random.nextInt(3), 20 + random.nextInt(3));

        // 第二个
        g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
        g.setFont(new Font("Atlantic Inline", Font.PLAIN, 18));
        str = strEnsure.substring(1, 2);
        g.drawString(str, 20 + random.nextInt(15), 16 + random.nextInt(8));

        // 第三个
        g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
        g.setFont(new Font("Atlantic Inline", Font.PLAIN, 18));
        str = strEnsure.substring(2, 3);
        g.drawString(str, 40 + random.nextInt(16), 12 + random.nextInt(14));

        //第四个
        g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
        g.setFont(new Font("Atlantic Inline", Font.PLAIN, 18));
        str = strEnsure.substring(3, 4);
        g.drawString(str, 55 + random.nextInt(18), 19 + random.nextInt(6));

        // 画边框
        g.setColor(Color.black);
        g.drawRect(0, 0, width - 1, height - 1);

        // 释放图形上下文
        g.dispose();

        try {
            // 输出图象到页面
            ImageIO.write(image, "JPEG", os);
        } catch (IOException e) {
            return "";
        }

        return strEnsure;          //返回生成的随机数
    }
}