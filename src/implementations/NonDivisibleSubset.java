package implementations;

import java.util.Scanner;

/*
  author  : rohan.gupta
  created : 1/2/18
*/
public class NonDivisibleSubset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long numbersSet[] = new long[k];
        int inputNumber;
        for (int i = 0; i < n; i++) {
            inputNumber = sc.nextInt();
            numbersSet[inputNumber % k]++;
        }
        int upperIndex = (int) (Math.ceil(k / 2.0) - 1);
        int setCount = 0;
        for (int i = 1; i <= upperIndex; i++) {
            setCount += (numbersSet[i] > numbersSet[k - i]) ? numbersSet[i] : numbersSet[k - i];
        }
        if (numbersSet[0] > 0) {
            setCount++;
        }
        if (k % 2 == 0 && numbersSet[k / 2] != 0) {
            setCount++;
        }
        System.out.print(setCount);
    }
}
