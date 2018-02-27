package implementations;

import java.util.Scanner;

/*
  author  : rohan.gupta
  created : 23/1/18
*/
public class QueensAttack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int rowQueen = in.nextInt();
        int columnQueen = in.nextInt();

        //Obstacles on horizontal line
        int columnObstacleTop = -1;
        int rowObstacleTop = -1;

        int columnObstacleBottom = -1;
        int rowObstacleBottom = -1;

        //obstacles on vertica line
        int columnObstacleRight = -1;
        int rowObstacleRight = -1;

        int columnObstacleLeft = -1;
        int rowObstacleLeft = -1;

        //obstacle on right diagonal

        int columnObstacleTopLeft = -1;
        int rowObstacleTopLeft = -1;

        int columnObstacleBottomRight = -1;
        int rowObstacleBottomRight = -1;

        //obstacles on left diagonal

        int columnObstacleTopRight = -1;
        int rowObstacleTopRight = -1;

        int columnObstacleBottomLeft = -1;
        int rowObstacleBottomLeft = -1;

        //Obstacles input
        for (int i = 0; i < k; i++) {

            int rowObstacle = in.nextInt();
            int columnObstacle = in.nextInt();

            //IF OBSTACLE IS ON HORIZONTAL LINE WITH QUEEN
            if (columnQueen == columnObstacle) {
                //obstacle on top
                if (rowObstacle > rowQueen) {
                    if (rowObstacleTop == -1 || rowObstacle < rowObstacleTop) {
                        rowObstacleTop = rowObstacle;
                        columnObstacleTop = columnObstacle;
                    }
                }
                //obstacle on bottom
                else if (rowObstacle < rowQueen) {
                    if (rowObstacleBottom == -1 || rowObstacle > rowObstacleBottom) {
                        rowObstacleBottom = rowObstacle;
                        columnObstacleBottom = columnObstacle;
                    }
                }
            }

            //IF OBSTACLE IS ON VERTICALL LINE WITH QUEEN
            else if (rowQueen == rowObstacle) {
                //Obstacle is on left
                if (columnObstacle < columnQueen) {
                    if (columnObstacleLeft == -1 || columnObstacle > columnObstacleLeft) {
                        rowObstacleLeft = rowObstacle;
                        columnObstacleLeft = columnObstacle;
                    }
                }
                //obstacle is on right
                else if (columnObstacle > columnQueen) {
                    if (columnObstacleRight == -1 || columnObstacle < columnObstacleRight) {
                        rowObstacleRight = rowObstacle;
                        columnObstacleRight = columnObstacle;
                    }
                }

            }

            //IF OBSTACLE IS ON PRINCIPAL DIAGONAL
            else if (rowQueen + columnQueen == rowObstacle + columnObstacle) {
                //Obstacle is on top left
                if (rowObstacle > rowQueen && columnObstacle < columnQueen) {
                    if(columnObstacleTopLeft == -1 || columnObstacle > columnObstacleTopLeft){
                        columnObstacleTopLeft = columnObstacle;
                        rowObstacleTopLeft = rowObstacle;
                    }
                }

                //Obstacle is on bottom right
                else if (rowObstacle < rowQueen && columnObstacle > columnQueen) {
                    if(columnObstacleBottomRight == -1 || columnObstacle < columnObstacleBottomRight){
                        columnObstacleBottomRight = columnObstacle;
                        rowObstacleBottomRight = rowObstacle;
                    }
                }
            }

            //IF OBSTACLE IS ON OTHER DIAGONAL
            else if(rowQueen - columnQueen == rowObstacle - columnObstacle){
                //on top right
                if(rowQueen < rowObstacle && columnQueen < columnObstacle){
                    if(columnObstacleTopRight == -1 || columnObstacle < columnObstacleTopRight){
                        columnObstacleTopRight = columnObstacle;
                        rowObstacleTopRight = rowObstacle;
                    }
                }
                //on bottom left
                else if(rowQueen > rowObstacle && columnQueen > columnObstacle){
                    if(columnObstacleBottomLeft == -1 || columnObstacle > columnObstacleBottomLeft){
                        columnObstacleBottomLeft = columnObstacle;
                        rowObstacleBottomLeft = rowObstacle;
                    }
                }
            }

        }

        //Computing attack positions

        int count = 0;

        //VERTICAL AXIS

        //In top direction
        if(rowObstacleTop == -1){
            count += n-rowQueen;
        }
        else {
            count += rowObstacleTop - rowQueen -1;
        }

        //In bottom direction
        if(rowObstacleBottom == -1){
            count += rowQueen-1;
        }
        else {
            count += rowQueen - rowObstacleBottom -1;
        }

        //HORIZONTAL AXIS

        //In left direction
        if(rowObstacleLeft == -1){
            count += n - columnQueen;
        }
        else {
            count += columnQueen - columnObstacleLeft -1;
        }

        //In right direction
        if(rowObstacleRight == -1){
            count += columnQueen-1;
        }
        else {
            count += columnObstacleRight - columnQueen - 1;
        }

        //PRINCIPAL DIAGONAL

        //in top left direction
        if(columnObstacleTopLeft == -1){
            count += Math.min(n-rowQueen,columnQueen-1);
        }
        else {
            count += rowObstacleTopLeft - rowQueen -1;
        }

        //in bottom right direction
        if(columnObstacleBottomRight == -1){
            count += Math.min(rowQueen-1,columnQueen-1);
        }
        else {
            count += columnObstacleBottomRight  - columnQueen - 1;
        }

        //OTHER DIAGONAL

        //top right direction
        if(columnObstacleTopRight == -1){
            count += Math.min(n-rowQueen,n-columnQueen);
        }
        else {
            count += columnObstacleTopRight - columnQueen - 1;
        }

        //bottom left direction
        if(columnObstacleBottomLeft == -1){
            count += Math.min(rowQueen - 1 , n - columnQueen);
        }
        else {
            count += columnQueen - columnObstacleBottomLeft - 1;
        }
        System.out.println(count);
    }
}
