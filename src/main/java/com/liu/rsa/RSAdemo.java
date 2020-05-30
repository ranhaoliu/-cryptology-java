package com.liu.rsa;



import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

import javax.crypto.Cipher;
import java.io.File;
import java.nio.charset.Charset;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @Author: 刘浩然
 * @Date: 2020/5/29 23:10
 * 非对称加密
 *rsa 生成公钥和私钥
 */
public class RSAdemo {
    public static void main(String[] args) throws Exception{
        //创建密钥对
        //KeyPairGenerator:密钥对生成器对象
        String algorithm = "RSA";
//        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
//        //生成密钥对
//        KeyPair keyPair=keyPairGenerator.generateKeyPair();
//        //生成私钥
//        PrivateKey privateKey = keyPair.getPrivate();
//        //生成公钥
//        PublicKey publicKey = keyPair.getPublic();
//        //获取私钥的字节数组
//        byte[] privateKeyEncoded = privateKey.getEncoded();
//        //获取公钥的字节数组
//        byte[] publicKeyEncoded = publicKey.getEncoded();
//        byte[] privateEncodeString = Base64.encodeBase64(privateKeyEncoded);
//        byte[] publicEncodeString = Base64.encodeBase64(publicKeyEncoded);
//        System.out.println(new String(privateEncodeString));
//        System.out.println(new String(publicEncodeString));
////        System.out.println(s);
//
//       String s= encryptRSA(algorithm, privateKey,"雷雷");
//       System.out.println(s);
//       String ss=decryptRSA(algorithm,publicKey,s);
//        System.out.println(ss);
       //生成密钥对并保存在本地文件中
//        generateKeyToFile(algorithm,"a.pub","a.pri");
//        PrivateKey privateKey = getPrivateKey("a.pri", algorithm);
//        String privateKey = getPrivateKey("a.pri", algorithm);
//        System.out.println(privateKey);
        PublicKey publicKey = getPublicKey("a.pub", algorithm);
        System.out.println(publicKey);
    }



    /**
     * 加密
    * @param input 原文
     * @param  privateKey 密钥
     * @param  algorithm 算法
     * @return  密文
     *
    * */
    public static String encryptRSA(String algorithm, Key privateKey, String input) throws  Exception{
       //创建加密对象
        Cipher cipher =Cipher.getInstance(algorithm);
        //对加密进行初始化
        //第一个参数: 加密的模式
        //第二个参数: 你想要使用公钥加密还是私钥加密
        //我想要使用私钥加密
        cipher.init(Cipher.ENCRYPT_MODE,privateKey);
        //使用私钥进行加密
        byte[] bytes=cipher.doFinal(input.getBytes());
        byte[] bytes1 = Base64.encodeBase64(bytes);
        return  new String(bytes1);
    }
    /**
     *使用公钥解密
     * @param algorithm 算法
     * @param publicKey 密钥
     * @param encrypted 密文
     * @return  原文
     **/
    private static String decryptRSA(String algorithm, Key publicKey,String encrypted) throws  Exception{
        //base64转码
        byte[] decode = Base64.decodeBase64(encrypted.getBytes());
        //创建加密对象
        Cipher cipher = Cipher.getInstance(algorithm);
        //初始化
        cipher.init(Cipher.DECRYPT_MODE,publicKey);
        byte[] decodeByte = cipher.doFinal(decode);
        return new String(decodeByte);
    }

    /**
     *  保存公钥和私钥,把公钥和私钥保存到根目录
     * @param algorithm 算法
     * @param  pubPath 公钥路径
     * @param  priPath 私钥路径
     */
    private static void generateKeyToFile(String algorithm, String pubPath, String priPath)throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
        //生成密钥对
        KeyPair keyPair=keyPairGenerator.generateKeyPair();
        //生成私钥
        PrivateKey privateKey = keyPair.getPrivate();
        //生成公钥
        PublicKey publicKey = keyPair.getPublic();
        //获取私钥的字节数组
        byte[] privateKeyEncoded = privateKey.getEncoded();
        //获取公钥的字节数组
        byte[] publicKeyEncoded = publicKey.getEncoded();
        //使用base64进行转码
        byte[] privateBytes = Base64.encodeBase64(privateKeyEncoded);
        byte[] publicBytes= Base64.encodeBase64(publicKeyEncoded);
        //打印公钥和私钥
//        System.out.println(new String(privateBytes));
//        System.out.println(new String(publicBytes));
        //apache 文件工具类
        FileUtils.writeStringToFile(new File(pubPath), new String(publicBytes), Charset.forName("UTF-8"));
        FileUtils.writeStringToFile(new File(priPath), new String(privateBytes), Charset.forName("UTF-8"));

    }

    /**    报错了InvalidKeySpecException
     * 读取私钥
     * @param priPath 私钥的路径
     * @param algorithm 算法
     * @return  返回私钥的对象
     */
    public static PrivateKey getPrivateKey(String priPath, String algorithm) throws Exception{
        String privateKeyString = FileUtils.readFileToString(new File(priPath), Charset.defaultCharset());
                //创建key的工厂
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        //创建私钥key的规则
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKeyString));
        //返回私钥对象
        return keyFactory.generatePrivate(keySpec);
    }

    /**
     *
     * @param pubPath  公钥路径
     * @param algorithm  算法
     * @return
     * @throws Exception
     */
     public static PublicKey getPublicKey(String pubPath, String algorithm) throws Exception{
        String pubKeyString = FileUtils.readFileToString(new File(pubPath), Charset.defaultCharset());
        //创建key的工厂
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        //创建公钥钥key的规则
        X509EncodedKeySpec spec = new X509EncodedKeySpec(Base64.decodeBase64(pubKeyString));
        //返回公钥对象
        return keyFactory.generatePublic(spec);
    }

}
