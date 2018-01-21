import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
* author  : rohan.gupta
* created : 3/1/18
*/
public class ProsIdToLeadId
{
    public static void main(String[] args) throws IOException {
        Map<String,String> idmapping = new HashMap<>();
        File idmap = new File("idmap.csv");
        BufferedReader br = new BufferedReader(new FileReader(idmap));
        String line;
        while((line = br.readLine())!= null){
            String id[] = line.split(",");
            idmapping.put(id[0].trim(),id[1].trim());
        }
        System.out.println(idmapping.size());
        br.close();
        File datafile = new File(args[0]);
        br = new BufferedReader(new FileReader(datafile));
        while((line = br.readLine())!= null){
            String leadid = idmapping.get(line.split(",")[0]);
            System.out.println(leadid + "," + line);
        }
    }
}
