package implementations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @author : rohan1.gupta
 * @created: 16/4/19
 */
public class GridSearchII {

/*
    public static String gridSearch(int [][]p , int [][]g){

    }
*/

    public static int[] computeLpsArray(int []a){
        int l = a.length;
        int lps[] = new int[l];
        lps[0]=0;
        int j = 0;
        int i = 1;
        while(i<l){
            if(a[i]==a[j]){
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

    public static List<Integer> kmpSearch(int a[], int p[], int lps[]){
        List<Integer> indexes = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i<a.length){
            if(a[i]==p[j]){
                i++;
                j++;
                if(j==p.length){
                    indexes.add(i-p.length);
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

    public static List<Integer> searchAtIndex(int a[],int p[],int []lcs , List<Integer> index){
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
            for(i=init,j=pattern;i<Math.min(now+p.length,a.length);i++,j++){
                if(a[i]!=p[j]){
                    lastIndex=i;
                    lastMatch=j-1;
                    break;
                }
            }
            if(j==p.length){
                lastMatch=j;
                lastIndex=i;
                indexes.add(now);
            }
        }
        return indexes;
    }

    public static void main(String[] args) {
        int a[]={9,9,1,2,3,1,2,3,1,2,3,1,2,3};
        int p[]={1,2,3,1,2,3,1,2,3};
        int xI[]={2,3,5,8};
        List<Integer> ints = new ArrayList<>();
        for (int i : xI) {
            ints.add(i);
        }

        List<Integer> integers = searchAtIndex(a, p, computeLpsArray(p),ints);
        System.out.println(integers);
    }
}
