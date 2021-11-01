package learn.gomoku.game;

import java.util.List;

import static learn.gomoku.game.Gomoku.WIDTH;

public class Board  {
    private final static String EMPTY_SPACE = " _ ";
    private final static String BLACK_STONE = " X ";
    private final static String WHITE_STONE = " O ";

    public static void printBoard (List<Stone> stones) {
        for (int row = 0; row < WIDTH + 1; row++) {
            for (int col = 0; col < WIDTH + 1; col++) {
                if (row == 0 && col == 0) {
                    System.out.print(" ");
                } else if (row == 0 && col < 10) {
                    System.out.print(" 0" + col);
                } else if (row == 0 && col < WIDTH) {
                    System.out.print(" " + col);
                } else if (row == 0 && col == WIDTH) {
                    System.out.println(" " + col);
                } else if (row < 10 && col == 0) {
                    System.out.print("0" + row);
                } else if (row < WIDTH + 1 && col == 0) {
                    System.out.print(row);
                } else if (col == WIDTH ) {
                    System.out.println(getStringAtBoardSpace(stones,row - 1,col -1));
                } else {
                    System.out.print(getStringAtBoardSpace(stones,row - 1,col -1));
                }
            }
        }
    }

    public static String getStringAtBoardSpace(List<Stone> stones, int row, int col) {
        for (int i=0; i<stones.size();i++) {
            if (stones.get(i).getRow() == row && stones.get(i).getColumn() == col) {
                if(stones.get(i).isBlack()){
                    return BLACK_STONE;
                } else {
                    return WHITE_STONE;
                }
            }
        }
        return EMPTY_SPACE;
    }
}