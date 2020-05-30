package com.liu;

/**
 * @Author: 刘浩然
 * @Date: 2020/5/28 23:02
 */
public class AsciiDemo {
    public static void main(String[] args) {
//        char a='A';
//        int b=a;
        //打印'A'，在ascii码中的十进制数字对应的数字是多少
        //定义字符串
        String a="AaZ";
        char[] chars=a.toCharArray();
        for(char aChar:chars){
            int asciicode=aChar;
            System.out.println(asciicode);
        }
//        System.out.println(b);
    }
}
