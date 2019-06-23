package hash;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * @author : rohan1.gupta
 * @created: 18/5/19
 */
public class RansomNote {

    static void checkMagazine(String[] magazine, String[] note) {
        boolean status = true;
        Map<String, Long> m = Arrays.stream(magazine).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> n = Arrays.stream(note).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (Map.Entry<String, Long> nm : n.entrySet()) {
            Long c = m.get(nm.getKey());
            if(c==null || c<nm.getValue()){
                status=false;
            }
        }
        String s = status?"Yes":"No";
        System.out.println(s);
    }

    public static void main(String[] args) {
        String s[] = "give me one grand today night".split(" ");
        String n[]= "give one grand today".split(" ");
        checkMagazine(s,n);
    }
}