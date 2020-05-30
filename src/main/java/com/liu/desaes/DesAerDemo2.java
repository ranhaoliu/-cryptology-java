package com.liu.desaes;



import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: 刘浩然
 * @Date: 2020/5/29 11:57
 * des解密
 */
public class DesAerDemo2 {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
//        String input ="qANksk5lvqM=";
        String input ="LnhkjLlD89w6OHWslyVrjA==";

//        String input ="ITnv9k28CQboQSgxA4XKTg==";
        byte[] base64 =Base64.decodeBase64(input.getBytes());
        String key ="12345678";
        Cipher cipher= Cipher.getInstance("DES");
////创建解密规则
//        //第一个参数: 表示key的字节,第二个参数表示加密的类型
        SecretKeySpec secretKeySpec = new SecretKeySpec( key.getBytes(),"DES");
        cipher.init(Cipher.DECRYPT_MODE,secretKeySpec);
        byte[] decode= cipher.doFinal(base64);
//        byte[] decode =cipher.doFinal(input.getBytes());
        System.out.println(new String(decode));

    }
}
