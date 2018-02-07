import java.util.Scanner;

/*
  author  : rohan.gupta
  created : 7/2/18
*/
public class StrangeCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long sec = sc.nextLong();
        System.out.println(getCounterValue(sec));

    }

    private static long getCounterValue(long sec) {
        long startSequenceNumber = (long) Math.floor(Math.log(Math.floor((sec - 1) / 3) + 1) / Math.log(2));
        long startTime = getStartingTimeNumberOfTheSeries(startSequenceNumber);
        long startCounterValue = getStartingCounterValue(startSequenceNumber);
        return startCounterValue - (sec-startTime);
    }

    private static long getStartingTimeNumberOfTheSeries(long seqNo){
        long startTime = (long) (3*((Math.pow(2,seqNo))-1));
        return startTime + 1;
    }

    private static long getStartingCounterValue(long startSequenceNumber){
        return (long) (3*(Math.pow(2,startSequenceNumber)));
    }
}