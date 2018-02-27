package implementations;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LibraryFine {

    static int daily = 15;
    static int monthly = 500;
    static int yearly = 10000;
    static DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) throws ParseException {
        int diff=0,rate=0;
        Date returnDate = df.parse(d1 + "-" + m1 + "-" + y1);
        Date dueDate = df.parse(d2 + "-" + m2 + "-" + y2);
        if(returnDate.compareTo(dueDate) > 0){
            if(y2 != y1){
                diff = Math.abs(y2-y1);
                rate = yearly;
            }
            else if(m2!=m1){
                diff = Math.abs(m2-m1);
                rate = monthly;
            }
            else {
                diff = Math.abs(d2-d1);
                rate = daily;
            }
        }
        return diff*rate;
    }

    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        int d1 = in.nextInt();
        int m1 = in.nextInt();
        int y1 = in.nextInt();
        int d2 = in.nextInt();
        int m2 = in.nextInt();
        int y2 = in.nextInt();
        int result = libraryFine(d1, m1, y1, d2, m2, y2);
        System.out.println(result);
        in.close();
    }
}
