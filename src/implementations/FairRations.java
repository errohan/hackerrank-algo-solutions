package implementations;

import java.util.Scanner;

/*
  author  : rohan.gupta
  created : 2/2/18
*/
public class FairRations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum=0;
        int loaves = 0;
        int n = sc.nextInt();
        int people[]=new int[n];
        for(int i = 0;i<n;i++){
            people[i]=sc.nextInt();
            sum+=people[i];
        }
        if(sum%2!=0){
            System.out.println("NO");
        }
        else {
            for(int i = 0;i<n-1;i++){
                if(people[i]%2!=0){
                    people[i]++;
                    people[i+1]++;
                    loaves+=2;
                }
            }
            System.out.println(loaves);
        }
    }
}
