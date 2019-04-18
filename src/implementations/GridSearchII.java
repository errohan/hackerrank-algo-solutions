package implementations;

import java.util.ArrayList;
import java.util.List;

/*
 * @author : rohan1.gupta
 * @created: 16/4/19
 */
public class GridSearchII {

    public static String gridSearch(String []a , String []p){

        if(p.length>a.length || a[0].length()<p[0].length()){
            return "NO";
        }

        int [][]lps = new int[p.length][];
        for(int i = 0;i<p.length;i++){
            lps[i]=computeLpsArray(p[i]);
        }
        List<Integer> integers = null;
        for(int i = 0;i<a.length-p.length+1;i++){
            integers = kmpSearch(a[i], p[0], lps[0]);
            if(integers!=null && integers.size()>0){
                for(int j = 1;j<p.length;j++){
                    integers = searchAtIndex(a[i+j],p[j],lps[j],integers);
                    if(integers.size()==0)
                        break;
                }
            }
            if(integers.size()>0){
                return "YES";
            }
        }
        return "NO";
    }

    public static int[] computeLpsArray(String a){
        int l = a.length();
        int lps[] = new int[l];
        lps[0]=0;
        int j = 0;
        int i = 1;
        while(i<l){
            if(a.charAt(i)==a.charAt(j)){
                j++;
                lps[i]=j;
                i++;
            }else if(j>0){
                j=lps[j-1];
            }else {
                lps[i]=j;
                i++;
            }
        }
        return lps;
    }

    public static List<Integer> kmpSearch(String a, String p, int lps[]){
        List<Integer> indexes = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i<a.length()){
            if(a.charAt(i)==p.charAt(j)){
                i++;
                j++;
                if(j==p.length()){
                    indexes.add(i-p.length());
                    j=lps[j-1];
                }
            }else if(j>0){
                j=lps[j-1];
            }else {
                i++;
            }
        }
        return indexes;
    }

    public static List<Integer> searchAtIndex(String a,String p,int []lcs , List<Integer> index){
        List<Integer> indexes = new ArrayList<>();
        int lastMatch = 0;
        int lastIndex = -1;
        for (Integer now : index) {
            int init=now,pattern=0,i=-1,j=-1;
            if(lastIndex>now){
                if(lcs[lastMatch-1]==lastIndex-now){
                    init=lastIndex;
                    pattern=lcs[lastMatch-1];
                }else
                    continue;
            }
            for(i=init,j=pattern;i<Math.min(now+p.length(),a.length());i++,j++){
                if(a.charAt(i)!=p.charAt(j)){
                    lastIndex=i;
                    lastMatch=j-1;
                    break;
                }
            }
            if(j==p.length()){
                lastMatch=j;
                lastIndex=i;
                indexes.add(now);
            }
        }
        return indexes;
    }

    public static void main(String[] args) {
        String a[]={"7283455864",
                "6731158619",
                "8988242643",
                "3830589324",
                "2229505813",
                "5633845374",
                "6473530293",
                "7053106601",
                "0834282956",
                "4607924137"};
        String p[]={"9505",
                "3845",
                "3530"};
        System.out.println(gridSearch(a,p));
    }
}