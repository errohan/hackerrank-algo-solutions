package implementations;

import java.util.Scanner;

/*
  author  : rohan.gupta
  created : 1/2/18
*/
public class ServiceLane {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int serviceLaneLength = sc.nextInt();
        int testCases = sc.nextInt();
        int[] serviceLane = new int[serviceLaneLength];
        for (int i = 0; i < serviceLaneLength; i++) {
            serviceLane[i] = sc.nextInt();
        }
        for (int i = 0; i < testCases; i++) {
            int entryPoint = sc.nextInt();
            int exitPoint = sc.nextInt();
            int minWidth = 3;
            for (int x = entryPoint; x <= exitPoint; x++) {
                if (minWidth > serviceLane[x]) {
                    minWidth = serviceLane[x];
                }
            }
            System.out.println(minWidth);
        }
    }
}
