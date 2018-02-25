import java.util.*;

/*
  author  : rohan.gupta
  created : 25/2/18
*/
public class SurfaceArea {
    public static void main(String[] args) {
        int r , c;
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        Map<Integer,List<Integer>> rows = new LinkedHashMap<>();
        Map<Integer,List<Integer>> cols = new LinkedHashMap<>();
        int i , j;
        for(i = 0;i<r;i++){
            for(j=0;j<c;j++){
                int num = sc.nextInt();
                if(rows.get(i) == null){
                    rows.put(i,new ArrayList<>());
                }
                if(cols.get(j) == null){
                    cols.put(j,new ArrayList<>());
                }
                rows.get(i).add(num);
                cols.get(j).add(num);
            }
        }
        int area = 2 * r * c;
        for(i = 0;i<r;i++){
            area += 2*Collections.max(rows.get(i));
        }
        for(j=0;j<c;j++){
            area += 2*Collections.max(cols.get(j));
        }
        System.out.println(area);
    }
}
