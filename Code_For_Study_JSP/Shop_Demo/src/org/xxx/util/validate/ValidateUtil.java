package cn.mldn.util.validate;

import javax.servlet.http.HttpServletRequest;

public class ValidateUtil {
    /**
     * 验证输入的数据是否为空
     *
     * @param data 要判断的数据
     * @return
     */
    public static boolean validatEmpty(String data) {
        if (data == null && "".equals(data)) {
            return false;
        }
        return true;
    }

    /**
     * 进行数据的正则操作验证
     *
     * @param data  输入的数据
     * @param regex 验证数据格式
     * @return
     */
    public static boolean validateRegex(String data, String regex) {
        if (validatEmpty(data)) { // 数据不为空
            return data.matches(regex); // 进行正则验证
        }
        return false;
    }

    /**
     * 验证用户输入的两个数据是否相同
     * @param dataa 用户输入的数据
     * @param datab 用户输入的数据
     * @return
     */
    public static boolean validateRepeat(String dataa, String datab) {
        if (validatEmpty(dataa) && validatEmpty(datab)) {
            return dataa.equalsIgnoreCase(datab);
        }
        return false;
    }
}
