import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ElectronicsShop {

    static int getMoneySpent(int[] keyboards, int[] drives, int limit) {
        int max = -1;
        int count = -1;
        int driveLen = drives.length;
        int keyboardLen = keyboards.length;
        List<Integer> kbd = Arrays.stream(keyboards).boxed().collect(Collectors.toList());
        List<Integer> drive = Arrays.stream(drives).boxed().collect(Collectors.toList());
        Collections.sort(kbd);
        Collections.sort(drive);
        if (kbd.get(0) + drive.get(0) <= limit) {
            Collections.reverse(kbd);
            for (int i = 0; i < keyboardLen; i++) {
                if (kbd.get(i) + drive.get(count+1) <= limit) {
                    count++;
                    for (int j = count; j < driveLen; j++) {
                        if (kbd.get(i) + drive.get(j) <= limit && kbd.get(i) + drive.get(j) > max) {
                            max = kbd.get(i) + drive.get(j);
                        }
                    }
                }
            }
        } else {
            return -1;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();
        int[] keyboards = new int[n];
        for (int keyboards_i = 0; keyboards_i < n; keyboards_i++) {
            keyboards[keyboards_i] = in.nextInt();
        }
        int[] drives = new int[m];
        for (int drives_i = 0; drives_i < m; drives_i++) {
            drives[drives_i] = in.nextInt();
        }
        //  The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
        int moneySpent = getMoneySpent(keyboards, drives, s);
        System.out.println(moneySpent);
    }
}
