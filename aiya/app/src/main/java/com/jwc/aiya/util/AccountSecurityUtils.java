package com.jwc.aiya.util;

import android.util.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by jwc on 2016/10/13.
 */
public class AccountSecurityUtils {

    /**
     * 生成 SHA-512 密码
     *
     * @param password 明文密码
     * @return SHA-512 密码
     */
    public static String encrypt(String password) {
        MessageDigest sha = null;
        try {
            sha = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String aftersalt = "aiya" + password + "aiya";
        byte[] srcBytes = aftersalt.getBytes();
        //使用srcBytes更新摘要
        sha.update(srcBytes);
        //完成哈希计算，得到result
        byte[] resultBytes = sha.digest();
        String encrypedValue = Base64.encodeToString(resultBytes, Base64.DEFAULT);
        //去掉\n
        encrypedValue = encrypedValue.replace("\n", "");
        return encrypedValue;
    }

}
