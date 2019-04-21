package implementations;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/*
 * @author : rohan1.gupta
 * @created: 20/4/19
 */
public class BombermanGame {
    public static Map<XY,Integer> masterMap = new ConcurrentHashMap<>();
    public static Map<Integer,Set<XY>> bombsMap = new ConcurrentHashMap<>();
    public static char[][] globalGrid;
    public static int xMax,yMax,yMin=0,xMin=0;

    public static String[] bomberman(int n , String []grid){
        globalGrid = new char[grid.length][grid[0].length()];
        for(int i = 0;i<grid.length;i++){
            globalGrid[i]=grid[i].toCharArray();
        }
        //empty places or detonated bombs
        bombsMap.put(0,new HashSet<>());
        //1 second bombs
        bombsMap.put(1,new HashSet<>());
        //2 second bombs
        bombsMap.put(2,new HashSet<>());
        //3 second bombs
        bombsMap.put(3,new HashSet<>());
        int l = globalGrid.length;
        xMax=l;
        yMax=globalGrid[0].length;
        for(int i = 0;i<l;i++){
            for(int j = 0;j<globalGrid[i].length;j++){
                if(globalGrid[i][j]=='O')
                    // as initially after this setup bomberman will do nothing for one hour, so better to keep these bombs in 2 second bombs
                    putBomb(2,new XY(i,j));
                else
                    putBomb(0,new XY(i,j));
            }
        }
        System.out.println("at time 1");
        printGrid();
        if(n%2==0){ n = 2;}
        else {
            if(((n-1)/2)==1)
                n=3;
            else n=5;
        }
        int time = 2;
        while (time<=n){
            rearrangeBombs();
            int modTime = time%2;
            if(modTime==0){
                plantBombs();
            }
            System.out.println("at time "+time);
            printGrid();
            time++;
        }
        for(int i = 0;i<grid.length;i++){
            grid[i]=new String(globalGrid[i]);
        }
        return grid;
    }

    private static void rearrangeBombs(){
        //detonate bombs
        //getting a new set to avoid concurrent modification exception
        Set<XY> xies = new HashSet<>(bombsMap.get(1));
        xies.forEach(b->{
            masterMap.put(b,0);
            globalGrid[b.x][b.y]='.';
            cleanUpNeighbouringArea(b);
        });
        bombsMap.get(0).addAll(bombsMap.get(1));
        bombsMap.get(1).clear();

        bombsMap.get(2).forEach(b->{ masterMap.put(b,1); });
        bombsMap.get(1).addAll(bombsMap.get(2));
        bombsMap.get(2).clear();

        bombsMap.get(3).forEach(b->{ masterMap.put(b,2); });
        bombsMap.get(2).addAll(bombsMap.get(3));
        bombsMap.get(3).clear();
    }

    private static void cleanUpNeighbouringArea(XY bomb){
        XY top = new XY(bomb.x-1,bomb.y);
        XY bottom= new XY(bomb.x+1,bomb.y);
        XY left= new XY(bomb.x,bomb.y-1);
        XY right= new XY(bomb.x,bomb.y+1);
        putBomb(0,top);
        putBomb(0,bottom);
        putBomb(0,left);
        putBomb(0,right);
    }

    private static void plantBombs(){
        bombsMap.get(0).forEach(b->{
            masterMap.put(b,3);
            globalGrid[b.x][b.y]='O';
        });
        bombsMap.get(3).addAll(bombsMap.get(0));
        bombsMap.get(0).clear();
    }

    private static void putBomb(int time,XY bomb){
        if(bomb.x>=xMin && bomb.x<xMax && bomb.y>=yMin && bomb.y<yMax){
            Integer integer = masterMap.get(bomb);
            if(integer!=null){
                bombsMap.get(integer).remove(bomb);
            }
            bombsMap.get(time).add(bomb);
            masterMap.put(bomb,time);
            if(time==0)
                globalGrid[bomb.x][bomb.y]='.';
            else
                globalGrid[bomb.x][bomb.y]='O';
        }
    }

    public static class XY{
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

    public static void main(String[] args) {
        String []s={".......","...O...","....O..", ".......", "OO....." ,"OO....."};
        String[] bomberman = bomberman(13, s);
        for(int i = 0 ; i<bomberman.length;i++){
            System.out.println(bomberman[i]);
        }
    }

    private static void printGrid(){
        for(int i = 0;i<globalGrid.length;i++){
            System.out.println(new String(globalGrid[i]));
        }
        System.out.println("\n\n");
    }

}
