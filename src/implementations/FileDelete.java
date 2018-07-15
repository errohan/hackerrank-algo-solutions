package implementations;

import java.io.File;

/*
* author  : rohan.gupta
* created : 2/1/18
*/
public class FileDelete {

    public static void main(String[] args) {
        Long currentMillis = System.currentTimeMillis();
        File baseDir = new File("/tmp");
        for(File file : baseDir.listFiles()){
            if(file.getName().startsWith("Redash_Report")){
                System.out.println(file.getName());
                Long millsecs = Long.parseLong(file.getName().split("\\.")[0].split("_")[3]);
                if((millsecs-currentMillis)/(1000*60*60*24) > 10){
                    file.delete();
                }
            }
        }
    }

}
