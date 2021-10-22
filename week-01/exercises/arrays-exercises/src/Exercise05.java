public class Exercise05 {

    public static void main(String[] args) {
        // 1. Declare an array to hold the names of the world's continents.
        // Do not use array literal notation. Allocate space for 6 continents and then set each value by index.
        // 2. Loop over each element and print it.
        String[] continents = new String[5];
        continents[0] = "North America";
        continents[1] = "South America";
        continents[2] = "Europe";
        continents[3] = "Asia";
        continents[4] = "Africa";
        for (int i = 0; i< continents.length; i++){
            System.out.println(continents[i]);
        }
    }
}
