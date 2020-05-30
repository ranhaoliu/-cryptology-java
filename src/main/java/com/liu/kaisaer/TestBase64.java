package com.liu.kaisaer;


import org.apache.commons.codec.binary.Base64;

/**
 * @Author: 刘浩然
 * @Date: 2020/5/29 17:23
 * base64 原理: 3个字节分为一组,一个字节8位，把这3个字节分为4组,每组6位
 *              把这六位分高位补两个0
 *
 *              3个字节为一组不够三个字节在输出的时候用等号进行补齐
 */
public class TestBase64 {
    public static void main(String[] args) {
        // 1 为1个字节，则需要补2个等号
        System.out.println(new String(Base64.encodeBase64("s13".getBytes())));
        // 12 为2个字节,需要补1个等号
        System.out.println(new String(Base64.encodeBase64("11".getBytes())));

        //硅谷是六个字节 刚好分为2组
        System.out.println(new String(Base64.encodeBase64("硅谷".getBytes())));

    }
}
