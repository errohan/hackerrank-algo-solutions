import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
* author  : rohan.gupta
* created : 3/1/18
*/
public class InsertLeadEvents {
    private static Date getDate(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date0 = simpleDateFormat.parse(date);
        return date0;
    }

    private static String getDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    private static String getQuery(String lead , Date date){
        String d = getDate(date);
        String query = "INSERT INTO lms.lead_event(current_value , event_state , lead_event_type ,event_time_stamp  , lead_id) values ('6. Converted' , 'RECEIVED' , 'LEAD_STAGE_CHANGED' , '"+ d +"' , '"+ lead +"');";
        return query;
    }

    public static void main(String[] args) throws Exception {
        File file = new File("leadsToBeInserted.csv");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while((line = br.readLine())!=null){
            System.out.println(getQuery(line.split(",")[0],getDate(line.split(",")[1])));
        }
    }

}
