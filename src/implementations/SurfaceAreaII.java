package implementations;

/*
 * @author : rohan1.gupta
 * @created: 18/4/19
 */
public class SurfaceAreaII {

    public static int surfaceArea(int [][]a , int h , int w){
        int sa = 0;
        for(int i = 0;i<h;i++){
            for(int j = 0;j<w;j++){
                //Corner case
                if(i==0)
                    sa += a[i][j];
                if(i == h-1)
                    sa += a[i][j];
                if(j==0 )
                    sa += a[i][j];
                if(j==w-1)
                    sa += a[i][j];
                //top and bottom cases
                if(a[i][j] > 0)
                    sa += 2;
                //East side
                if(i>0 && a[i-1][j] > a[i][j])
                    sa += a[i-1][j] - a[i][j];
                //West side
                if(i<h-1 && a[i+1][j] > a[i][j])
                    sa += a[i+1][j] - a[i][j];
                //North side
                if(j>0 && a[i][j-1] > a[i][j])
                    sa += a[i][j-1] - a[i][j];
                //south side
                if(j<w-1 && a[i][j+1] > a[i][j])
                    sa += a[i][j+1] - a[i][j];
            }
        }
        return sa;
    }

    public static void main(String[] args) {
        int a[][]={{1}};
        int h = 1 , w = 1;
        System.out.println(surfaceArea(a,h,w));

    }
}
