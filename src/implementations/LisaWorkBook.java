package implementations;

import java.util.Scanner;

/*
  author  : rohan.gupta
  created : 1/2/18
*/
public class LisaWorkBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfChapters = sc.nextInt();
        int capacityOfAPage = sc.nextInt();
        int[] questionsCountOfEachChapter = new int[numberOfChapters];
        for (int i = 0; i < numberOfChapters; i++) {
            questionsCountOfEachChapter[i] = sc.nextInt();
        }
        System.out.println(getSpecialProblemsCount(numberOfChapters, capacityOfAPage, questionsCountOfEachChapter));
    }

    private static int getSpecialProblemsCount(int numberOfChapters, int capacityOfAPage, int[] questionsCountOfEachChapter) {
        int specialProblemCount = 0;
        int currentPageNumber = 1;
        for (int i = 0; i < numberOfChapters; i++) {
            int startQuestion = 1;
            while (startQuestion <= questionsCountOfEachChapter[i]) {
                int endQuestion = (startQuestion + capacityOfAPage - 1) <= questionsCountOfEachChapter[i] ? (startQuestion + capacityOfAPage - 1) : questionsCountOfEachChapter[i];
                if (startQuestion <= currentPageNumber && currentPageNumber <= endQuestion) {
                    specialProblemCount++;
                }
                currentPageNumber++;
                startQuestion = endQuestion + 1;
            }
        }
        return specialProblemCount;
    }
}
