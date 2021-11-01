import java.util.Random;
import java.util.Scanner;

public class Game {

    // constants
    private static int WIDTH = 10;
    private final static String WALL_CHARACTER = "M";
    private final static String EMPTY_CHARACTER = " ";

    private final Scanner console = new Scanner(System.in);
    private Hero hero;
    private Treasure treasure;
    private Treasure treasure1;
    private Treasure treasure3;
    private Traps trap1;
    private Traps monster1;
    private boolean isOver;
    public boolean tCollected = false;
    public boolean t1Collected = false;
    public int treasuresCollected = 0;


    public void run() {
        setUp();
        while (!isOver) {
            printWorld();
            System.out.println(treasure3.getX() + " " + treasure3.getY());
            System.out.println(hero.getX() + " " + hero.getY());
            move();
        }
        printWorld();
    }

    private void setUp() {
        System.out.print("What is the name of your hero?: ");
        String name = console.nextLine();
        System.out.println("Choose your characters symbol");
        String symbol = console.nextLine();
        System.out.println("Choose a world size");
        WIDTH = Integer.parseInt(console.nextLine());


        Random rand = new Random();
        int x = rand.nextInt(WIDTH);
        int y = rand.nextInt(WIDTH);

        hero = new Hero(name, symbol, x, y);

        do {
            x = rand.nextInt(WIDTH);
            y = rand.nextInt(WIDTH);
        } while (x == hero.getX() && y == hero.getY());

        treasure = new Treasure(x, y);

        do {
            x = rand.nextInt(WIDTH);
            y = rand.nextInt(WIDTH);
        } while (x == hero.getX() && y == hero.getY() ||
                x == treasure.getX() && y == treasure.getY());

        treasure1 = new Treasure(x, y);

        do {
            x = rand.nextInt(WIDTH);
            y = rand.nextInt(WIDTH);
        } while (x == hero.getX() && y == hero.getY() ||
                x == treasure.getX() && y == treasure.getY() ||
                x == treasure1.getX() && y == treasure1.getY());

        trap1 = new Traps(x, y);

        do {
            x = rand.nextInt(WIDTH);
            y = rand.nextInt(WIDTH);
        } while (x == hero.getX() && y == hero.getY() ||
                x == treasure.getX() && y == treasure.getY() ||
                x == treasure1.getX() && y == treasure1.getY() ||
                x == trap1.getX() && y == trap1.getY());

        treasure3 = new Treasure(x, y);

        do {
            x = rand.nextInt(WIDTH);
            y = rand.nextInt(WIDTH);
        } while (x == hero.getX() && y == hero.getY() ||
                x == treasure.getX() && y == treasure.getY() ||
                x == treasure1.getX() && y == treasure1.getY() ||
                x == trap1.getX() && y == trap1.getY() ||
                x == treasure3.getX() && y == treasure3.getY());

        monster1 = new Traps(x, y);
    }

    private void printWorld() {
        // top wall border
        System.out.println(WALL_CHARACTER.repeat(WIDTH + 2));

        for (int row = 0; row < WIDTH; row++) {
            // left wall border
            System.out.print(WALL_CHARACTER);
            for (int col = 0; col < WIDTH; col++) {
                if (row == hero.getY() && col == hero.getX()) {
                    System.out.print(hero.getSymbol());
                } else if (row == treasure.getY() && col == treasure.getX() && !tCollected) {
                    System.out.print("T");
                } else if (row == treasure1.getY() && col == treasure1.getX() && !t1Collected) {
                    System.out.print("G");
                } else if (row == monster1.getY() && col == monster1.getX()) {
                    System.out.print("M");
                } else {
                    System.out.print(EMPTY_CHARACTER);
                }
            }

            // right wall border
            System.out.println(WALL_CHARACTER);
        }

        // bottom wall border
        System.out.println(WALL_CHARACTER.repeat(WIDTH + 2));
    }

    private void move() {

        System.out.print(hero.getName() + ", move [WASD]: ");
        String move = console.nextLine().trim().toUpperCase();

        if (move.length() != 1) {
            return;
        }

        switch (move.charAt(0)) {
            case 'W':
                hero.moveUp();
                monster1.moveDown();
                break;
            case 'A':
                hero.moveLeft();
                monster1.moveRight();
                break;
            case 'S':
                hero.moveDown();
                monster1.moveUp();
                break;
            case 'D':
                hero.moveRight();
                monster1.moveLeft();
                break;
        }

        if (hero.getX() < 0 || hero.getX() >= WIDTH
                || hero.getY() < 0 || hero.getY() >= WIDTH) {
            System.out.println(hero.getName() + " touched lava! You lose.");
            isOver = true;
        } else if (hero.getX() == treasure1.getX() && hero.getY() == treasure1.getY()) {
            System.out.println(hero.getName() + " Collected a treasure!");
            t1Collected = true;
            treasuresCollected++;
            if (treasuresCollected == 3) {
                System.out.println("All treasures Collected! You Win!");
                isOver = true;
            }


        } else if (hero.getX() == treasure.getX() && hero.getY() == treasure.getY()) {
            System.out.println(hero.getName() + " Collected a treasure!");
            tCollected = true;
            treasuresCollected++;
            if (treasuresCollected == 3) {
                System.out.println("All treasures Collected! You Win!");
                isOver = true;
            }
        } else if (hero.getX() == treasure3.getX() && hero.getY() == treasure3.getY()) {
            System.out.println(hero.getName() + " found the hidden treasure!");
            treasuresCollected++;
            if (treasuresCollected == 3) {
                System.out.println("All treasures Collected! You Win!");
                isOver = true;
            }
        } else if (hero.getX() == trap1.getX() && hero.getY() == trap1.getY()) {
            System.out.println(hero.getName() + " has stepped on a trap! you lose");
            isOver = true;
        } else if (hero.getX()  + 1 == monster1.getX() && hero.getY() + 0 == monster1.getY()  ||
                   hero.getX() + 0 == monster1.getX()  && hero.getY() + 1 == monster1.getY()  ||
                   hero.getX() + 1 == monster1.getX()  && hero.getY() - 1 == monster1.getY()  ||
                   hero.getX() + 0 == monster1.getX()  && hero.getY() + 1 == monster1.getY()  ) {
            System.out.println(hero.getName() + " Ran into a monster. You've died!");
            isOver = true;
        }
    }
}


