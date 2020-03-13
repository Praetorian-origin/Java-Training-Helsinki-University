/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import gameoflife.GameOfLifeBoard;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author praetorian
 */
public class PersonalBoard extends GameOfLifeBoard {

    public PersonalBoard(int width, int height) {
        super(width, height);
    }

    @Override
    public void initiateRandomCells(double probabilityForEachCell) {
        boolean[][] board = super.getBoard();
        Random r = new Random();

        for (int i = 0; i < board.length; i++) {
            boolean[] bs = board[i];
            for (int j = 0; j < bs.length; j++) {
                double probability = r.nextDouble() + probabilityForEachCell;
                if (probability > 1) {
                    bs[j] = true;
                }
            }

        }

    }

    @Override
    public boolean isAlive(int x, int y) {
        boolean[][] board = super.getBoard();
        if (!checkInBoundMultiDimArray(board, x, y)) {
            return false;
        }
        return board[x][y];

    }

    @Override
    public void turnToLiving(int x, int y) {

        boolean[][] board = super.getBoard();

        if (!checkInBoundMultiDimArray(board, x, y)) {
            return;
        }

        board[x][y] = true;

    }

    @Override
    public void turnToDead(int x, int y) {
        boolean[][] board = super.getBoard();
        if (!checkInBoundMultiDimArray(board, x, y)) {
            return;
        }

        board[x][y] = false;

    }

    @Override
    public int getNumberOfLivingNeighbours(int x, int y) {
        boolean[][] board = super.getBoard();
        if (!checkInBoundMultiDimArray(board, x, y)) {
            return 0;
        }

        int neigbours = 0;
        for (int i = 0; i < board.length; i++) {
            boolean[] bs = board[i];
            for (int j = 0; j < bs.length; j++) {
                if ((i == x + 1 || i == x - 1 || x == i) && (j == y + 1 || j == y - 1 || j == y)) {
                    if(x == i && y == j) {
                        
                    }
                    else if (bs[j] != false) {
                        neigbours++;
                    }

                }

            }

        }
        return neigbours;
    }

    @Override
    public void manageCell(int x, int y, int livingNeigbours) {
        if (livingNeigbours < 2) {
            super.getBoard()[x][y] = false;
        }
        else if (livingNeigbours > 3) {
            super.getBoard()[x][y] = false;
        }
        else if (livingNeigbours == 3) {
             super.getBoard()[x][y] = true;
        }

    }

    public static boolean checkInBoundMultiDimArray(Object array, int x, int y) {

        if (x < Array.getLength(array) && x >= 0) {
            if (y < Array.getLength(Array.get(array, x)) && y >= 0) {
                return true;
            }
        }
        return false;
    }

}
