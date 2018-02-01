package hackerrank.hiring;

import java.util.*;

/*
  author  : rohan.gupta
  created : 26/1/18
*/
public class WinningLotteryTickets {

    public static int[] binaryRepresentation = {1,2,4,8,16,32,64,128,256,512};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        String tickets[] = new String[n];
        for(int i = 0;i<n;i++){
            tickets[i] = sc.next();
        }
        long pairs = getWinningPairs(tickets);
        System.out.println(pairs);
    }

    private static long getWinningPairs(String[] tickets) {
        long count = 0;
        Map<Integer,Integer> binaryTickets = getTicketsInBinary(tickets);
        ArrayList<Integer> ticketsSet = new ArrayList<>(binaryTickets.keySet());
        int l = ticketsSet.size();
        for(int i = 0;i<l-1;i++){
            long firstCount = binaryTickets.get(ticketsSet.get(i));
            for(int j=i+1;j<l;j++){
                if((ticketsSet.get(i)|ticketsSet.get(j)) == 1023){
                    long  secondCount = binaryTickets.get(ticketsSet.get(j));
                    count = count + (firstCount*secondCount);
                }
            }
        }
        return count;
    }

    public static Map<Integer,Integer> getTicketsInBinary(String []tickets){
        Map<Integer,Integer> binaryTickets = new LinkedHashMap<>();
        int n = tickets.length;
        for(int i = 0;i<n;i++){
            int ticketValue = getTicketInBinary(tickets[i]);
            if(binaryTickets.get(ticketValue) == null){
                binaryTickets.put(ticketValue,1);
            }
            else {
                binaryTickets.put(ticketValue,binaryTickets.get(ticketValue)+1);
            }
        }
        return binaryTickets;
    }

    public static int getTicketInBinary(String ticket){
        int n = ticket.length();
        int x = 0;
        for(int i=0;i<n;i++){
            x = x | binaryRepresentation[Integer.parseInt(String.valueOf(ticket.charAt(i)))];
        }
        return x;
    }

}