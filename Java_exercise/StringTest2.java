/**
 * String 类的练习.
 *
 * Created by Zeng Geon 2016/3/24.
 */
public class StringTest2 {

    public static void main(String[] agrs) {
        String s1 = "Java is amazing. 233";
        String s2 = new String("hehe,really?");

        System.out.println("charAt: " + s1.charAt(2));// the result is "v"
        System.out.println(s1.substring(3));//输出从index为3开始，直到结束的字符串
        System.out.println(s1.substring(3,6));
        System.out.println(s1.concat(s2));
        System.out.println(s1 + s2);//同上，字符串拼接
        System.out.println(s1.replace("a","e"));
        System.out.println(s1.replace("\\d","j"));//将正则表达式匹配到的字符串替换
        System.out.println(s1.replaceAll("\\d","j"));//将正则表达式匹配到的字符串替换
    }
}
