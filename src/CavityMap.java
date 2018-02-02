import java.util.Scanner;

/*
  author  : rohan.gupta
  created : 2/2/18
*/
public class CavityMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        //Resolving
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == n - 1) {
                    System.out.print(map[i][j]);
                } else if (map[i][j] > map[i - 1][j] && map[i][j] > map[i + 1][j] && map[i][j] > map[i][j - 1] && map[i][j] > map[i][j + 1]) {
                    System.out.print("X");
                }else System.out.print(map[i][j]);
            }
            System.out.print("\n");
        }

    }
}
