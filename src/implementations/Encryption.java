package implementations;

import java.util.Scanner;

/*
  author  : rohan.gupta
  created : 24/1/18
*/
public class Encryption {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.next();
        int row = (int) Math.floor(Math.sqrt(inputString.length()));
        int col = (int) Math.ceil(Math.sqrt(inputString.length()));
        if(row*col < inputString.length()){
            row = (int) Math.ceil(Math.sqrt(inputString.length()));
        }
        String textBlock[] = new String[row];
        for(int i=0;i<row;i++){
            if(i==row-1){
                textBlock[i]=inputString.substring(i*col,inputString.length());
            }
            else {
            textBlock[i]=inputString.substring(i*col,(i+1)*col);
            }
        }
        for(int i = 0;i<col;i++){
            for(int j = 0;j<row;j++){
                if(i<=textBlock[j].length()-1 )
                System.out.print(textBlock[j].charAt(i));
            }
            System.out.print(" ");
        }
    }
}
