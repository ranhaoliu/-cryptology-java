package com.liu.digest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: 刘浩然
 * @Date: 2020/5/29 22:10
 * 消息摘要算法,为了防止消息被篡改
 *ctrl +alt +M 抽取方法
 * MessageDigest.getInstance("MD5"）
 */
public class DigestDemo1 {
    public static void main(String[] args) throws  Exception {
        //原文
        String input="aa";
        //算法
        String algorithm ="MD5";
       //创建消息摘要对象
       System.out.println("md5== "+ toDigest(input, algorithm));
        String sha1 = toDigest(input,"SHA-1");
        System.out.println("sha1===  "+sha1);
        String sha256 = toDigest(input,"SHA-256");
        System.out.println("sha256===  "+sha256);
        String sha512= toDigest(input,"SHA-512");
        System.out.println("sha512===  "+sha512);
    }
    /*
    *
    * */
    private static String toDigest(String input, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest digest= MessageDigest.getInstance(algorithm);
        //执行消息摘要算法
        byte[] digest1=digest.digest(input.getBytes());
        //使用base64进行转码
//         byte[] encode=Base64.encodeBase64(digest1);
//        System.out.println(new String(encode));
        //对密文进行迭代
        StringBuilder sb=new StringBuilder();
        for( byte b: digest1){
          //把密文转成16进制
          String s=Integer.toHexString(b&0xff);//传入的int为32位，而b是byte类型，后面应该补24个0
          //判断如果密文长度是1，需要再高位进行补0
          if(s.length()==1){
              s="0"+s;
          }
         sb.append(s);
        }
       return sb.toString();
    }
}
