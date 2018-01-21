import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/*
* author  : rohan.gupta
* created : 3/1/18
*/
public class InsertLeadEventsSelection {

    public static void main(String[] args) throws Exception {
        File file = new File("LeadsToBeHandled.csv");
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<String> lids = new ArrayList<>();
        String line;
        while ((line = br.readLine())!= null){
            lids.add(line.split(",")[0]);
        }
        System.out.println(lids.size());
        //second
        br.close();
        File newFile = new File("LSA.csv");
        br = new BufferedReader(new FileReader(newFile));
        while ((line = br.readLine())!= null){
         if(line.split(",")[1].equals("6. Converted") && lids.contains(line.split(",")[0])){
             System.out.println(line);
         }
        }
    }
}
