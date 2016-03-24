/**
 * StringBuffer类的练习.
 * Created by Zeng Ge on 2016/3/24.
 */
public class StringBufferTest {

    public static void main(String[] agrs) {
        StringBuffer s1 = new StringBuffer(" ");
        s1.append("HeHe .");
        System.out.println(s1);

        StringBuffer s2 = new StringBuffer(" en Heng? ");
        System.out.println(s1.append(s2));
        System.out.println(s1.insert(2, 'A'));

//      System.out.println(s1.setCharAt(2,'F'));//此处会报错，因为setCharAt方法无返回值,而println方法需要返回值
        s1.setCharAt(2,'F');
        System.out.println(s1);

        System.out.println(s1.reverse());
        s2 = s1.replace(1,4,"G");
        System.out.println(s2);
    }

}
