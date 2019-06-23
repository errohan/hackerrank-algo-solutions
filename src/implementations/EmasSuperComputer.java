package implementations;

import java.util.*;

/*
 * @author : rohan1.gupta
 * @created: 22/4/19
 */
public class EmasSuperComputer {

    public static int twoPluses(String[] grid) {
        //Holds coordinate and the center of plus to which it belongs
        Map<XY, XY> masterMap = new HashMap<>();
        //Holds center coordinates and the plus size
        Map<XY, List<XY>> plusMap = new HashMap<>();
        //max1 holds the greater plus and max2 holds the smaller plus
        int max1 = 1, max2 = 1;
        //direction flag info
        int[][] dfi = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        int row = grid.length;
        int col = grid[0].length();
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                XY current = new XY(i,j);
                plusMap.put(current,new ArrayList<>());
                List<XY> points = new ArrayList<>();
                //current color
                char cc = grid[i].charAt(j);
                int cx = i, cy = j;
                int size = 0;
                //0->left, 1->top , 2->right , 3->bottom
                //direction flag
                int df = 0;
                //found flag
                boolean f=true;
                cx = i + (size+1)*dfi[df][0];
                cy = j + (size+1)*dfi[df][1];
                while (cx >= 0 && cx < row && cy >= 0 && cy < col && f){
                    f = false;
                    if (grid[cx].charAt(cy) == cc)
                        points.add(new XY(cx,cy));
                        f = true;
                    df = (df + 1) % 4;
                    if (f && df == 0) {
                        size++;
                    }
                    cx = i + (size+1)*dfi[df][0];
                    cy = j + (size+1)*dfi[df][1];
                }
                //as a single block is a plus of size 1
                size = size * 4 + 1;
                int acceptablePoints = 0;
                for(int x = 0;i<size*4;i++){
                    XY center = masterMap.get(points.get(x));
                    if(center!=null){
                        List<XY> xies = plusMap.get(center);
                        if(xies!=null && !xies.isEmpty() && xies.size()/4>size){
                            acceptablePoints=x;
                            break;
                        }
                    }
                }

                if(size>max1){
                    max2=max1;
                    max1=size;
                }else if(size>max2){
                    max2=size;
                }
            }
        }
        return max1 * max2;
    }

    public static void main(String[] args) {
        String s[]={"GGGGGG",
                "GBBBGB",
                "GGGGGG",
                "GGBBGB",
                "GGGGGG"};
        System.out.println(twoPluses(s));
    }

    static class XY {
        int x;
        int y;

        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            XY xy = (XY) o;
            return x == xy.x &&
                    y == xy.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
