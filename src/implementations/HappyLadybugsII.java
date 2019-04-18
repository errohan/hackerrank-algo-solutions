package implementations;

import java.util.HashMap;
import java.util.Map;

/*
 * @author : rohan1.gupta
 * @created: 18/4/19
 */
public class HappyLadybugsII {

    public static boolean happyLadyBugs(String s){
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            if(map.get(s.charAt(i))==null){
                map.put(s.charAt(i),1);
            }else {
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
        }
        if(map.containsKey('_')){
            map.remove("_");
            return map.values().contains(1);
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(happyLadyBugs("RBY_YBR"));
    }
}
