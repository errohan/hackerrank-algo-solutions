import java.util.Scanner;

public class BeautifulDaysAtMovie {

    static int beautifulDays(int i, int j, int k) {
        int count = 0;
        for(int x = i;x<=j;x++){
            if(Math.abs(x-revNum(x))%k==0){
                count++;
            }
        }
        return count;
    }

    static int revNum(int i){
        int temp = i;
        int revNum = 0;
        while(temp>0){
            revNum = (revNum * 10) + (temp%10);
            temp = temp/10;
        }
        return revNum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        int j = in.nextInt();
        int k = in.nextInt();
        int result = beautifulDays(i, j, k);
        System.out.println(result);
        in.close();
    }
}
