package com.xfragwork.xfragwork.utils;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS;
import static java.lang.Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS;
import static java.lang.Character.UnicodeBlock.CJK_RADICALS_SUPPLEMENT;
import static java.lang.Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS;
import static java.lang.Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A;
import static java.lang.Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B;

/**
 * @version V2.7.0
 * @Project: BCS-Android
 * @Filename:VerificationUtils.java
 * @Desciption: 验证相关
 * @Author: sunbo
 * @Date: 2017/9/6  14:36
 * @Copyright: 2017 AgileSC, Inc. China All rights reserved.
 * Modification History
 * Date				Author	Version 	Desciption
 */
public class VerificationUtils {
    /**
     * 验证手机号码是否非法
     *
     * @param mobiles 手机号码
     * @return
     */
    public static boolean isMobile(String mobiles) {
        if (TextUtils.isEmpty(mobiles)) {
            return false;
        }
        String isMatch1 = "^((13[4-9])|(147)|(149)|(15[0-2,7-9])|(178)|(18[2-4,7-8]))\\d{8}|(1705)\\d{7}$";
        String isMatch2 = "^((13[0-2])|(145)|(15[5-6])|(176)|(18[5,6]))\\d{8}|(1709)|(1708)\\d{7}$";
        String isMatch3 = "^((133)|(153)|(177)|(170)|(173)|(18[0,1,9]))\\d{8}|(1700)\\d{7}$";
        return mobiles.matches(isMatch1) || mobiles.matches(isMatch2) || mobiles.matches(isMatch3);
    }

    public static boolean isEmail(String email) {
        if (TextUtils.isEmpty(email)) {
            return false;
        }
        String emailRegex = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}";
        return email.matches(emailRegex);
    }

    /**
     * 验证qq号码是否正确
     *
     * @param qq
     * @return
     */
    public static boolean isQQnumber(String qq) {
        if (qq == null) {
            return false;
        }
        String qqVer = "^[1-9]\\d{4,9}$";
        return qq.matches(qqVer);
    }

    /**
     * 验证固定电话是否非法
     *
     * @param mobiles 手机号码
     * @return
     */
    public static boolean isTelNumber(String mobiles) {
        if (TextUtils.isEmpty(mobiles)) {
            return false;
        }
        String isMatch = "^((\\(\\d{2,3}\\))|(\\d{3}\\-))?(\\(0\\d{2,3}\\)|0\\d{2,3}-)?[1-9]\\d{6,7}(\\-\\d{1,15})?$";
        return mobiles.matches(isMatch);
    }

    /**
     * 判断密码中是否包含中文字符
     *
     * @param password
     * @return
     */
    public static boolean isChar(String password) {
        if (password != null) {
            char[] array = password.toCharArray();
            for (char c : array) {
                if (c > Byte.MAX_VALUE) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断密码中是否包含中文字符
     *
     * @param str
     * @return
     */
    public static boolean isContainChinese(String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }

    /**
     * 判断密码中是否包含中文字符
     *
     * @param checkStr
     * @return
     */
    private static boolean checkStringContainChinese(String checkStr) {
        if (null != checkStr) {
            char[] checkChars = checkStr.toCharArray();
            for (int i = 0; i < checkChars.length; i++) {
                char checkChar = checkChars[i];
                if (checkCharContainChinese(checkChar)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkCharContainChinese(char checkChar) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(checkChar);
        if (CJK_UNIFIED_IDEOGRAPHS == ub || CJK_COMPATIBILITY_IDEOGRAPHS == ub || CJK_COMPATIBILITY_FORMS == ub ||
                CJK_RADICALS_SUPPLEMENT == ub || CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A == ub || CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B == ub) {
            return true;
        }
        return false;
    }
}
 