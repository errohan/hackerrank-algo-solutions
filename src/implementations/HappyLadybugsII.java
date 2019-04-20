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
        boolean happy = true;
        char lastChar = s.charAt(0);
        int count = 1;
        map.put(s.charAt(0),1);
        for(int i = 1;i<s.length();i++){
            char cuurentChar = s.charAt(i);
            if(happy && lastChar!=cuurentChar){
                if(count==1) happy=false;
                else if(map.containsKey(cuurentChar)) happy=false;
                else{
                    lastChar=cuurentChar;
                    count=1;
                }
            }else count++;

            if(map.get(s.charAt(i))==null){
                map.put(s.charAt(i),1);
            }else {
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
        }
        if((count!=1 && happy && lastChar!='_') || map.containsKey('_')){
            map.remove('_');
            return happy || !map.values().contains(1);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(happyLadyBugs("AABBC"));
    }
}
