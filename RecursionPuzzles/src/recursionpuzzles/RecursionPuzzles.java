/*
 * Hee Won Yang 
 * CIS 2168; Lab6 
 * Chess and Sudoku
 */
package recursionpuzzles;

/**
 *
 * @author Belle
 */ 
//eight queens problem
public class RecursionPuzzles {
    
      public static void main(String args[]) {
        RecursionPuzzles Queen = new RecursionPuzzles();
        Queen.solve();
    }

    //Method to check if the Queen placement is safe
    boolean checkQueenPlacement(int board[][], int row, int col)
    {
        int i;
        int j;

        //Left Row
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        //Diagonal Upper
        for (i=row, j=col; i>=0 && j>=0; i--, j--)
            if (board[i][j] == 1)
                return false;

        //Diagonal Lower
        for (i=row, j=col; j>=0 && i<8; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    //Backtracking Function
    boolean solve() {

        //Chess Board
        int board[][] = {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
        };

        if (solveBoard(board, 0) == false) {
            System.out.print("No solution to the Eight Queens Problem");
            return false;
        }
        printBoard(board);
        return true;
    }

    //Recursive Function to Solve the Eight Queens Problem
    boolean solveBoard(int board[][], int col)
    {
        //Base Case
        if (col >= 8)
            return true;

        //Recursive Case
        for (int i = 0; i < 8; i++) {

            if (checkQueenPlacement(board, i, col)) {

                board[i][col] = 1;

                if (solveBoard(board, col + 1) == true)
                    return true;

                //Backtracking
                board[i][col] = 0;
            }
        }
        //If no queens can be placed
        return false;
    }

    //Prints the Chess Board
    void printBoard(int board[][]) {

        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 8; j++)
                System.out.print(" " + board[i][j] + " ");
                System.out.println();
        }
    }
}

