import java.util.Arrays;

/*
  author  : rohan.gupta
  created : 1/2/18
*/
public class Test {
    public static void main(String[] args) {
        String s = "rohangupta";
        char []charArray = s.toCharArray();
        Arrays.sort(charArray);
        s = new String(charArray);
        System.out.println(s);
    }
}
