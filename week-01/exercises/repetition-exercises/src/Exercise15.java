public class Exercise15 {

    public static void main(String[] args) {
        // BOX
        // 1. Use nested loops to print a box in the console.
        // One loop should represent rows and the other should represent columns.
        // 2. Change the row and column limit to change the shape of the box.


        int rowWIDTH = 5;
        int colWIDTH = 5;
            for (int row = 1; row < rowWIDTH; row++) {
                System.out.println("#");
                for (int col = 0; col < colWIDTH; col++) {
                    System.out.print("#");
                }
        }
        // Expected Output (5X5)
        // #####
        // #####
        // #####
        // #####
        // #####

        // (3X4)
        // ####
        // ####
        // ####
    }
}
