package com.common.util;

import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {


    public final static String MD5(String s){
        try {
            byte[] btInput =s.getBytes();
            //获得MD5摘要算法的MessageDigest 对象
            MessageDigest mdInst=MessageDigest.getInstance("MD5");
            //使用指定的字节更新摘要
            mdInst.update(btInput);
            //获得密文
            byte[] md=mdInst.digest();
            //字符数组转化成字符串返回
         return byteArrayToHex(md);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String byteArrayToHex(byte[] byteArray){
        // 首先初始化一个字符数组，用来存放每个16进制字符
        char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9', 'A','B','C','D','E','F' };
        // new一个字符数组，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））
        char[] resultCharArray =new char[byteArray.length * 2];
        //遍历字节数组，通过位运算(位运算效率高),转换成字符放到字符数组中去
        int index=0;
        for(byte b:byteArray){
            resultCharArray[index++]=hexDigits[b>>>4 & 0xf];
            resultCharArray[index++]=hexDigits[b&0xf];
        }
        return new String(resultCharArray);
    }



    public static void main(String[] asd) {
        String con = "123456";
        String str = MD5(con);
        System.out.println(str);
    }
}
