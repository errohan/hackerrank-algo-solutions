package implementations;

/*
 * @author : rohan1.gupta
 * @created: 13/4/19
 */
public class QueensAttackII {

    public static int getAttackingPositions(int chessDimensions, int obs, int queenX, int queenY, int[][] obstacles) {
        int top = -1, bottom = -1, left = -1, right = -1, topRight = -1, bottomLeft = -1, topLeft = -1, bottomRight = -1;
        for (int i = 0; i < obs; i++) {
            int x = obstacles[i][0], y = obstacles[i][1];
            //Checking if obstacle is in verticall path to queen (|)
            if (y == queenY) {
                int newVerticall = Math.abs(x - queenX) - 1;
                //If obstacle lies on top
                if (x > queenX) {
                    top = updateIfRequired(top, newVerticall);
                }
                //if obstacle lies on bottom
                else if (x < queenX) {
                    bottom = updateIfRequired(bottom, newVerticall);
                }
            }
            //checking if obstacle is in horizonatal path with queen (-)
            else if (x == queenX) {
                int newHorizonatall = Math.abs(y - queenY) - 1;
                //if obstacle lies in right
                if (y > queenY) {
                    right = updateIfRequired(right, newHorizonatall);
                }
                //if obstacle lies on left
                else if (y < queenY) {
                    left = updateIfRequired(left, newHorizonatall);
                }
            }
            //checking if obstacle lies on the right diagonal of queen (\)
            else if (x + y == queenX + queenY) {
                int newRightDiagonal = Math.abs(x - queenX) - 1;
                //if obstacle lies on top left
                if (x > queenX) {
                    topLeft = updateIfRequired(topLeft, newRightDiagonal);
                }
                //if obstacle lies on bottom right
                if (x < queenX) {
                    bottomRight = updateIfRequired(bottomRight, newRightDiagonal);
                }
            }
            //checking of obstacle lies on left diagonall of queen (/)
            if (queenX - queenY == x - y) {
                int newLeftDiagonal = Math.abs(x - queenX) - 1;
                //if obstacle lies on top right
                if (y > queenY) {
                    topRight = updateIfRequired(topRight, newLeftDiagonal);
                }
                //if obstacle lies on bottom left
                if (y < queenY) {
                    bottomLeft = updateIfRequired(bottomLeft, newLeftDiagonal);
                }
            }
        }
        top = initializeIfNot(top, chessDimensions - queenX);
        bottom = initializeIfNot(bottom, queenX - 1);
        left = initializeIfNot(left, queenY - 1);
        right = initializeIfNot(right, chessDimensions - queenY);
        topRight = initializeIfNot(topRight, (queenX > queenY) ? chessDimensions - queenX : chessDimensions - queenY);
        bottomLeft = initializeIfNot(bottomLeft, (queenX > queenY) ? queenY - 1 : queenX - 1);
        topLeft = initializeIfNot(topLeft, (chessDimensions - queenX < queenY - 1) ? chessDimensions - queenX : queenY - 1);
        bottomRight = initializeIfNot(bottomRight, (queenX - 1 < chessDimensions - queenY) ? queenX - 1 : chessDimensions - queenY);
        return top + bottom + left + right + topRight + bottomLeft + topLeft + bottomRight;
    }

    public static int updateIfRequired(int origVal, int newVal) {
        return ((origVal == -1) || (newVal < origVal)) ? newVal : origVal;
    }

    public static int initializeIfNot(int currentVal, int initVal) {
        return (currentVal == -1) ? initVal : currentVal;
    }

    public static void main(String[] args) {
        int queenX = 4;
        int queenY = 4;
        int chessDimensions = 4;
        int obst = 1;
        int obstacles[][] = {{3, 3}};
        System.out.println(getAttackingPositions(chessDimensions, obst, queenX, queenY, obstacles));
    }
}
