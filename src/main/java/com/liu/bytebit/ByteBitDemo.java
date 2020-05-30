package com.liu.bytebit;

import java.io.UnsupportedEncodingException;

/**
 * @Author: 刘浩然
 * @Date: 2020/5/29 0:44
 */
public class ByteBitDemo {
/*
根据编码的格式不一样，对应的字节也不一样
如果是UTF-8:一个中文对应三个字节
如果是GBK: 一个中文对应两个字节
如果是英文，就无所谓编码格式(没有编码的概念),都是一个字节
* */
    public static void main(String[] args) throws UnsupportedEncodingException {
        String a="尚";
//        byte[] bytes=a.getBytes();//默认是utf-8编码
        byte[] bytes=a.getBytes("GBK");
        for(byte aByte:bytes){
            System.out.println(aByte);
            String s=Integer.toBinaryString(aByte);
            System.out.println(s);
        }
    }
}
