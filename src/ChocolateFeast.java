import java.util.Scanner;

/*
  author  : rohan.gupta
  created : 1/2/18
*/
public class ChocolateFeast {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int trips = sc.nextInt();
        for(int i = 0;i<trips;i++){
            int money = sc.nextInt();
            int costPerChocolate = sc.nextInt();
            int packetOffer = sc.nextInt();
            System.out.println(getTotalNumberOfChocolates(money,packetOffer,costPerChocolate));
        }
    }

    private static int getTotalNumberOfChocolates(int money, int packetOffer, int costPerChocolate) {
        int emptyPackets = 0;
        int totalChocolates = 0;
        totalChocolates += money/costPerChocolate;
        int packetsExchanged;
        int chocolatesReceived;
        emptyPackets+=totalChocolates;
        while (emptyPackets>=packetOffer){
            chocolatesReceived = emptyPackets/packetOffer;
            packetsExchanged = packetOffer*chocolatesReceived;
            emptyPackets = emptyPackets - packetsExchanged + chocolatesReceived;
            totalChocolates += chocolatesReceived;
        }
        return totalChocolates;
    }
}
