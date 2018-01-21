import java.util.Scanner;

public class UtopianTree {

    static int utopianTree(int n) {
        int height = 1;
        for(int x = 1; x<=n;x++){
            if(x%2==0){
                height += 1;
            }
            else{
                height *= 2;
            }
        }
        return height;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int result = utopianTree(n);
            System.out.println(result);
        }
        in.close();
    }
}
