package com.liu.signature;

import com.liu.rsa.RSAdemo;
import org.apache.commons.codec.binary.Base64;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

/**
 *  使用私钥对摘要进行 签名
 *  使用公钥对签名进行校验
 * @Author: 刘浩然
 * @Date: 2020/5/30 22:39
 */
public class SignatureDemo {
    public static void main(String[] args) throws  Exception{
        String  a="123";
        //得到公钥和私钥
        PublicKey publicKey = RSAdemo.getPublicKey("a.pub", "RSA");
        PrivateKey privateKey = RSAdemo.getPrivateKey("a.pri", "RSA");
        //获取数字签名
        String signatureDate = getSignature(a, "sha256withrsa", privateKey);
        System.out.println(signatureDate);

        //校验签名

        boolean b=verifySignature(a,"sha256withrsa",publicKey,signatureDate);
        System.out.println(b);
    }
    /**获取数字签名
     * @param input   原文
     * @param algorithm 算法
     * @param privateKey  私钥key
     * @return
     */
    private static String getSignature(String input ,String algorithm, PrivateKey privateKey)throws Exception{
        //获取签名对象
        Signature signature = Signature.getInstance(algorithm);
        //初始化签名
        signature.initSign(privateKey);
        //传入原文
        signature.update(input.getBytes());
        //开始签名
        byte[] sign = signature.sign();
        //使用base64进行编码
        return new String(Base64.encodeBase64(sign));
    }

    /**
     *校验签名
     * @param input 原文
     * @param algorithm 算法
     * @param publicKey 公钥key
     * @param signatureDate 签名密文
     * @return
     * @throws Exception
     */
    private static boolean verifySignature(String input, String algorithm, PublicKey publicKey, String signatureDate)throws Exception{
        //获取签名对象
        Signature signature = Signature.getInstance(algorithm);
        //初始化校验
        signature.initVerify(publicKey);
        //传入原文
        signature.update(input.getBytes());
        //校验数据
        return signature.verify(Base64.decodeBase64(signatureDate));
    }

}
