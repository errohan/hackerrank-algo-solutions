import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
* author  : rohan.gupta
* created : 9/1/18
*/
public class LmsLsqDataCompare {
    public static void main(String[] args) throws IOException {
        int count = 0;
        File lmsFile = new File("lms.csv");
        File lsqFile = new File("lsq.csv");
        Map<String, String> lmsMap = new HashMap<>();
        Map<String, String> lsqMap = new HashMap<>();
        String line;
        BufferedReader lmsBr = new BufferedReader(new FileReader(lmsFile));
        while ((line = lmsBr.readLine()) != null) {
            if (line.length() > 5) {
                String pid = line.split(",")[0];
                String state = (line.split(",").length == 1) ? null : line.split(",")[1];
                lmsMap.put(pid, state);
            }
        }
        Set<String> pids = new HashSet<>();
        BufferedReader lsqBr = new BufferedReader(new FileReader(lsqFile));
        while ((line = lsqBr.readLine()) != null) {
            if (line.split(",").length == 2) {
                String pid = line.split(",")[0];
                String state = line.split(",")[1];
                if (state.length() > 3 && pid.length() == 36) {
                    if (lmsMap.get(pid) == null || (!lmsMap.get(pid).toString().equals(state) && !state.equals("Closed") &&!state.equals("Dormant"))) {
                        pids.add(pid);
                    }
                }
            }
        }
        lsqBr.close();
        System.out.println("\n" + pids.size());
        pids.forEach(p->{
            System.out.print("\"" + p + "\"," );
        });
    }
}
