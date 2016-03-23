/**
 * Character类的常用方法.
 *
 * Created by Zeng Ge on 2016/3/23.
 */
public class CharacterClass {

    public static void main (String [] agrs) {
        char[] charArrary = new char[]{'*','7','b',' ' ,'A'};
        for(int i = 0; i < charArrary.length; i ++) {
            if (Character.isDigit(charArrary[i])){
                System.out.println(charArrary[i] + "是一个数字");
            }
            if (Character.isLetter(charArrary[i])){
                System.out.println(charArrary[i] + "是一个字母");
            }
            if (Character.isLowerCase(charArrary[i])){
                System.out.println(charArrary[i] + "是一个小写形式");
            }
            if (Character.isWhitespace(charArrary[i])){
                System.out.println(charArrary[i] + "是一个空格");
            }
            if (Character.isUpperCase(charArrary[i])){
                System.out.println(charArrary[i] + "是一个大写形式");
            }
        }
    }
}
