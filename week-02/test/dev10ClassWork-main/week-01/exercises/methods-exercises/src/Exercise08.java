public class Exercise08 {

    // 1. Create a method.
    // Name: getRandomFruit
    // Inputs: none
    // Output: String
    // Description: returns a random fruit name as a string.
    // See Exercise01.
    // Choose from at least 5 fruit.

    public static void main(String[] args) {
        // 2. Call your method in various ways to test it here.
        System.out.println(getRandomFruit());
        System.out.println(getRandomFruit());
        System.out.println(getRandomFruit());
    }
    public static String getRandomFruit() {

        switch ((int) (Math.random() * 5)) {
            case 0:
                return "Apple";
            case 1:
                return "Banana";
            case 2:
                return "Plum";
            case 3:
                return "Watermelon";
            case 4:
                return "Pear";
        }

        return ""; // Should never happen.
    }
}
