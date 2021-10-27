import java.util.Scanner;
public class Exercise14 {

    /* SHORT SURVEY

    Write a program that asks a user four questions and prints the results:
    - What is your first name?
    - What is your last name?
    - How many towns/cities have you lived in?
    - How many musical instruments can you play?

    Store each answer in a variable with an appropriate type.
    Print the results after the user has answered all four questions.

    Use methods to break the program into reusable blocks of code.
     */
    public static void main(String[] args) {
        String firstName = getFirstName();
        String lastName = getLastName();
        String towns = getTowns();
        String instruments = getInstruments();
        System.out.format("%s %s has lived in %s and plays %s instruments", firstName, lastName, towns, instruments);

    }

    public static String getFirstName() {
        Scanner console = new Scanner(System.in);
        System.out.println("What is your first name");
        String firstName = console.nextLine();
        return firstName;
    }

    public static String getLastName() {
        Scanner console = new Scanner(System.in);
        System.out.println("What is your last name");
        String LastName = console.nextLine();
        return LastName;
    }

    public static String getTowns() {
        Scanner console = new Scanner(System.in);
        System.out.println("How many towns/cities have you lived in?");
        String numberOfCities = console.nextLine();
        return numberOfCities;
    }

    public static String getInstruments() {
        Scanner console = new Scanner(System.in);
        System.out.println("How many musical instruments can you play?");
        String numberOfInstruments = console.nextLine();
        return numberOfInstruments;


    }
}
