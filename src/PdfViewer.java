import java.util.Scanner;

public class PdfViewer {

    static int designerPdfViewer(int[] h, String word) {
        int baseAscii = (int) 'a';
        int maxHeight = 0;
        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++) {
            int instatAscii = (int) word.charAt(i);
            if (h[instatAscii - baseAscii] > maxHeight) {
                maxHeight = h[instatAscii - baseAscii];
            }
        }
        return maxHeight * wordLength;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] h = new int[26];
        for (int h_i = 0; h_i < 26; h_i++) {
            h[h_i] = in.nextInt();
        }
        String word = in.next();
        int result = designerPdfViewer(h, word);
        System.out.println(result);
        in.close();
    }
}
