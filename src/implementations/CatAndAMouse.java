package implementations;

import java.util.Scanner;

public class CatAndAMouse {

    static String catAndMouse(int x, int y, int z) {
        int catA = Math.abs(z - x);
        int catB = Math.abs(z - y);
        if (catA < catB) {
            return "Cat A";
        }
        if (catA > catB) {
            return "Cat B";
        } else
            return "Mouse C";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        String[] result = new String[q];
        for (int a0 = 0; a0 < q; a0++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();
            result[a0] = catAndMouse(x, y, z);
        }
        in.close();
        for (int a0 = 0; a0 < q; a0++) {
            System.out.println(result[a0]);
        }
    }
}
