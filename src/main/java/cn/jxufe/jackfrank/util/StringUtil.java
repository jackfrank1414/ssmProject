package cn.jxufe.jackfrank.util;

/**
 * TODO
 *
 * @author asus
 * @version 1.0
 * @date 2021/7/19 22:29
 */
public class StringUtil {
    public static boolean isEmpty(String str){
        if(str == null || "".equals(str.trim())){
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean isValidGender(String str){
        if(str == null || "".equals(str.trim()) || "M".equals(str) || "F".equals(str) || "男".equals(str) || "女".equals(str) || "male".equals(str) || "Male".equals(str) || "female".equals(str) || "Female".equals(str)){
            return true;
        }
        else {
            return false;
        }
    }

}
