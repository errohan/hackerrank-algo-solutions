package implementations;

import java.util.Scanner;

public class ViralAdvertising {

    static int viralAdvertising(int n) {
        int numOfPeople = 5;
        int countsReached = 0;
        for(int i = 1; i<=n;i++){
            countsReached += numOfPeople/2;
            numOfPeople = (numOfPeople/2)*3;
        }
        return countsReached;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int result = viralAdvertising(n);
        System.out.println(result);
        in.close();
    }
}
