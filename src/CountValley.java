import java.util.Scanner;

public class CountValley {

    static int countingValleys(int n, String s) {
        int level = 0;
        int valley = 0;
        int i;
        for(i=0;i<n;i++){
            if(s.charAt(i) == 'U'){
                level++;
            }
            else {
                level--;
            }
            if(level<0){
                while(level!=0 && i<n-1){
                    i++;
                    if(s.charAt(i) == 'U'){
                        level++;
                    }
                    else {
                        level--;
                    }
                }
                valley++;
            }
        }
        return valley;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int result = countingValleys(n, s);
        System.out.println(result);
        in.close();
    }
}
