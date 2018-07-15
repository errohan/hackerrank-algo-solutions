package strings;
import java.util.Scanner;
import java.util.Stack;

/*
  author  : rohan.gupta
  created : 16/3/18
*/
public class SuperReducedStrings {

    public static String superReduceString(String s){
        Stack<Character> stringStack = new Stack<>();
        for(int i = 0;i<s.length();i++){
            if(stringStack.isEmpty() || stringStack.peek()!=s.charAt(i)){
                stringStack.push(s.charAt(i));
            }
            else {
                stringStack.pop();
            }
        }
        StringBuilder reducedString = new StringBuilder();
        if(stringStack.isEmpty()){
            return "Empty String";
        }
        else {
            while (!stringStack.isEmpty()){
                reducedString.insert(0,stringStack.pop());
            }
        }
        return reducedString.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = superReduceString(s);
        System.out.println(result);
    }
}
