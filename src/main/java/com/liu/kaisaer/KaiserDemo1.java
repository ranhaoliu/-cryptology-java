package com.liu.kaisaer;

/**
 * @Author: 刘浩然
 * @Date: 2020/5/28 23:14
 * 凯撒加密
 */
public class KaiserDemo1 {
    public static void main(String[] args) {
        //定义原文
        String input="Hello World";
        //把原文右移三位
        int key =3;
        //把字符串变成字节数组
        char[] chars =input.toCharArray();
        StringBuilder sb =new StringBuilder();
        for(char aChar: chars){
            int b=aChar;
            //往右边移动单位
            b=b+3;
            char newb=(char)b;
            sb.append(newb);

        }
        System.out.println("密文===="+sb.toString());
//       效果：  密文====Khoor#Zruog
    }
}
