package com.liu.desaes;





import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;

import javax.crypto.spec.SecretKeySpec;


/**
 * @Author: 刘浩然
 * @Date: 2020/5/29 11:11
 * 对称加密 des加密算法
 */
public class DesAerDemo1 {
    public static void main(String[] args) throws Exception {
        //原文
        String input="硅谷";
//        String input="123456232";
        //定义key,即秘钥
        String key="12345678";//des进行加密, 秘钥key必须是8个字节,换句话说字符串key 的长度必须是8,不然会报错
        //算法
        String transformation="DES";
        //加密的类型
        String algorithm= "DES";
        //创建加密对象,进行加密和解密的对象
       Cipher cipher= Cipher.getInstance(transformation);
       //创建加密规则
        //第一个参数: 表示key的字节,第二个参数表示加密的类型
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(),algorithm);
        //进行加密初始化
        //第一个参数表示模式，加密模式，解密模式
        //第二个参数表示: 加密的规则
        cipher.init(Cipher.ENCRYPT_MODE,secretKeySpec);
        //调用加密方法
        //参数表示原文的字节数组
        byte [] bytes =cipher.doFinal(input.getBytes());//doFinal是真正完成加密的方法
//        for( byte aByte: bytes){
//            System.out.println(aByte);
//        }
//        //打印密文
//        //如果直接打印密文会出现乱码(在ascii编码表上找不到,没有负数)
//        System.out.println(new String(bytes));

         //创建base64对象,导入apache 的包
        //对乱码进行转码
       byte[] encode= Base64.encodeBase64(bytes);
        System.out.println(new String(encode));
//        System.out.println(new String(bytes));

    }
}
