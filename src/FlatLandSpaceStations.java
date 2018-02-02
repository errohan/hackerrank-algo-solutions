
import java.util.Arrays;
import java.util.Scanner;

/*
  author  : rohan.gupta
  created : 1/2/18
*/
public class FlatLandSpaceStations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfCities = sc.nextInt();
        int numberOfSubstations = sc.nextInt();
        int subStations[] = new int[numberOfSubstations];
        //Input the substations
        for(int i = 0;i<numberOfSubstations;i++){
            subStations[i]=sc.nextInt();
        }
        Arrays.sort(subStations);
        int nearestSubSttnIndex = 0;
        int maxDistance = 0;
        //Iterate over substations to find max distance
        int dist,dist1;
        for(int i = 0;i<numberOfCities;i++){
            dist = Math.abs(i-subStations[nearestSubSttnIndex]);
            if(nearestSubSttnIndex < numberOfSubstations-1){
                dist1 = Math.abs(i-subStations[nearestSubSttnIndex+1]);
                if(dist>=dist1){
                    nearestSubSttnIndex++;
                    dist=dist1;
                }
            }
            if(dist>maxDistance){
                maxDistance=dist;
            }
        }
        System.out.println(maxDistance);
    }
}