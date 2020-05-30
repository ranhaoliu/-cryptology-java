package com.liu.desaes;


import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;

import javax.crypto.spec.SecretKeySpec;


/**
 * @Author: 刘浩然
 * @Date: 2020/5/29 12:39
 */
public class DesAerDemo3 {
    public static void main(String[] args) throws Exception {
        String input ="s13";
        System.out.println("对明文-->: "+input+" 进行加密");
        String encode =encode(input,"12345678","DES");
       System.out.println(input + " 的密文为-->: "+encode);
       System.out.println("密文: "+encode + " 解密后的明文为--->"+ decode(encode,"12345678","DES"));

    }

    public static  String encode(String input,String key,String transformation) throws Exception {
        Cipher cipher = Cipher.getInstance(transformation);
        SecretKeySpec secretKeySpec =new SecretKeySpec(key.getBytes(),transformation);//秘钥的规则
        cipher.init(Cipher.ENCRYPT_MODE,secretKeySpec);//第一个参数为模式:表示是加密还是解密,第二个参数为秘钥的规则
        byte[] encode = cipher.doFinal(input.getBytes());//加密后出现乱码
        byte [] aByte= Base64.encodeBase64(encode);//由于可能出现乱码,所以进行base64转码
        return new String(aByte);
    }
    public static  String decode(String input,String key,String transformation) throws Exception{
           byte[] base64 = Base64.decodeBase64(input.getBytes());//对base64为转码后的密文进行解码
            Cipher cipher=Cipher.getInstance(transformation);
            SecretKeySpec secretKeySpec =new SecretKeySpec(key.getBytes(),transformation);
            cipher.init(Cipher.DECRYPT_MODE,secretKeySpec);
             byte []decode =cipher.doFinal(base64);
           return new String (decode);
    }
}
