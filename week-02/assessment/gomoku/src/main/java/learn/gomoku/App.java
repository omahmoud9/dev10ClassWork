package learn.gomoku;

import learn.gomoku.game.Board;
import learn.gomoku.game.Gomoku;
import learn.gomoku.game.Result;
import learn.gomoku.game.Stone;
import learn.gomoku.players.HumanPlayer;
import learn.gomoku.players.Player;
import learn.gomoku.players.RandomPlayer;

import java.util.Scanner;

public class App {

    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        welcomeMessage();

        Player player1;
        Player player2;

        boolean isPlaying = true;

        int player1Type = getPlayerType(1);
        if (player1Type == 1) {
            player1 = new HumanPlayer(getPlayerName(1));
        } else {
            player1 = new RandomPlayer();
        }

        int player2Type = getPlayerType(2);
        if (player2Type == 1) {
            player2 = new HumanPlayer(getPlayerName(2));
        } else {
            player2 = new RandomPlayer();
        }
        System.out.println("Randomizing");

        Gomoku game = new Gomoku(player1, player2);

        while (isPlaying) {
            Stone stone;
            if (game.getCurrent() instanceof HumanPlayer) {
                stone = new Stone(getRow(game.getCurrent().getName()) - 1, getColumn() - 1, game.isBlacksTurn());
            } else  {
                stone = game.getCurrent().generateMove(game.getStones());
            }
            Result result = game.place(stone);

            if (!result.isSuccess()) {
                if (game.isOver()) {
                    System.out.println(result.getMessage());
                } else if (result.getMessage().equals("Stone is off the board.")) {
                    System.out.println(result.getMessage());
                } else if (result.getMessage().equals("Wrong player.")) {
                    System.out.println(result.getMessage());
                } else if (result.getMessage().equals("Duplicate move.")) {
                    System.out.println(result.getMessage());
                }
            } else if (result.isSuccess()) {
                if (game.isOver() && result.getMessage().equals("Game ends in a draw.")) {
                    System.out.println(result.getMessage());
                } else if (game.isOver()){
                    System.out.println(result.getMessage());
                }
            }

            Board.printBoard(game.getStones());
            if (game.isOver()) {
                if (playAgain().equals("y")) {
                    isPlaying = true;
                    game = new Gomoku(player1,player2);
                }else {
                    isPlaying = false;
                }
            }
        }
    }

    // prints welcome to gomoku
    public static void welcomeMessage () {
        System.out.println("Welcome to GomoKu");
        System.out.println("=".repeat(17));
    }

    // game set up, picking type of player
    public static int getPlayerType ( int playerNumber){
        System.out.println("Player " + playerNumber + " is:");
        System.out.println("1. Human");
        System.out.println("2. Random Player");
        System.out.println("Select [1-2]:");
        return Integer.parseInt(console.nextLine());
    }

    // naming players
    public static String getPlayerName ( int playerNumber){
        System.out.println("Player " + playerNumber + " what is your name: ");
        return console.nextLine();
    }

    // gets player choice for row
    public static int getRow (String name){
        System.out.println(name + "'s turn");
        System.out.println("Row:");
        return Integer.parseInt(console.nextLine());
    }

    // gets player choice for coloumn
    public static int getColumn () {
        System.out.println("Column:");
        return Integer.parseInt(console.nextLine());
    }

    // restart game with empty board
    public static String playAgain() {
        System.out.println("Play again: [y/n]");
        return console.nextLine();
    }
}
