/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflifeboard;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Belle
 */
public class GameOfLifeBoard {

    private char[][] board;
    private char[][] nextBoard;
    public static final char LIVE = 'X';
    public static final char DEAD = '^';
    public static int size = 5;

    /*Constructor: In the constructor, build a new board of your desired size, 
    and initialize your initial board state. Also initialize the nextBoard
    variable to be an empty board of the same size.*/
 
    public GameOfLifeBoard() {
        board = new char[size][size];//created a new 2d array of chars

        for (int row = 0; row < board.length; row++) {

            for (int col = 0; col < board[0].length; col++) {

                int x = (int) (Math.random() * 2);
                if (x == 1) {	       //visited each element and randomly set it to
                    // X or ^. This is the seed
                    board[row][col] = LIVE;
                } else {

                    board[row][col] = DEAD;
                }
            }
        }

        nextBoard = new char[size][size];
    }

    public void generateNextStep() {
//basically this just visits each element in the 2D array and determines what status the cell will
        // have in the next generation based on its neighbors.
        for (int row = 0; row < board.length; row++) {

            for (int col = 0; col < board[row].length; col++) {

                if (board[row][col] == LIVE && getNeighborCount(row, col) < 2) {

                    nextBoard[row][col] = DEAD;

                } else if (board[row][col] == LIVE && getNeighborCount(row, col) > 3) {

                    nextBoard[row][col] = DEAD;

                } else if (board[row][col] == DEAD && getNeighborCount(row, col) == 3) {

                    nextBoard[row][col] = LIVE;
                } else {

                    nextBoard[row][col] = board[row][col];
                }
            }

        }
        board = nextBoard;
        nextBoard = new char[size][size];
    }

    public int getNeighborCount(int r, int c) {
        int numNeighbors = 0;
        //this method visits the 8 surrounding cells and checks how many neighbors there are. 
        //It ignores itself
        for (int row = r - 1; row <= r + 1; row++) {

            for (int col = c - 1; col <= c + 1; col++) {

                try {
                    if (board[row][col] == LIVE && (row != r || col != c)) {
                        numNeighbors++;
                    }

                } catch (ArrayIndexOutOfBoundsException e) {
                    continue;
                }
            }
        }

        return numNeighbors;
    }

    public void printBoard() {
        //prints the board
        for (int row = 0; row < board.length; row++) {
            System.out.println(Arrays.toString(board[row]));
        }
        System.out.println();
    }

    public static void main(String[] args) {

        GameOfLifeBoard g = new GameOfLifeBoard();

        Scanner kb = new Scanner(System.in);
        //continues to print each generation until "quit" is entered by the user

        do {
            g.printBoard(); //prints out the board
            g.generateNextStep();
        } while (!kb.nextLine().equalsIgnoreCase("quit"));

    }
}
