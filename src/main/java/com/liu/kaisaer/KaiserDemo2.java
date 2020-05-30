package com.liu.kaisaer;

/**
 * @Author: 刘浩然
 * @Date: 2020/5/28 23:24
 * 对凯撒密码算法的简单封装,简单封装了两个方法,
 * 1.kaiserEncryption(String a,int key) 加密， a为明文，key为移动的位数
 * 2.kaiserDecryption(String a,int key) 解密, a 为密文，key 为秘钥即向前移动的位数
 */
public class KaiserDemo2 {
    public static void main(String[] args) {
        String a = "Hello World";
        String encryption = kaiserEncryption(a,3);
        System.out.println("密文==== "+encryption);
        String decryption = kaiserDecryption(encryption,3);
        System.out.println("解密后的明文====  "+decryption);

    }

    //凯撒加密函数
    //a为要加密的字符串(明文),key 为移位的位数,
    public static String  kaiserEncryption(String a,int key){
        char[] b= a.toCharArray();
        StringBuilder sb=new StringBuilder();//StringBuilder 为线程不安全的
        for(char bChar:b){
            int c=bChar+key;
            sb.append((char) c);
        }
        return sb.toString();
    }
    //凯撒解密
    //a为要解密的字符串(密文),key为之前移位的次数
    public static String kaiserDecryption(String a,int key){
        char [] b=a.toCharArray();
        StringBuilder sb =new StringBuilder();
        for(char bChar:b){
            int c=bChar-key;
            sb.append((char)c);
        }
        return sb.toString();
    }
}
