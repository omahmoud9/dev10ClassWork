import java.util.Scanner;

public class Exercise03 {

    public static void main(String[] args) {
        // 1. Change the code to accept input from the user.
        // Use a Scanner and parse the input with Integer.parseInt.
        // int value = 11;
        System.out.println("Enter a value");
        Scanner console = new Scanner(System.in);
        int value = Integer.parseInt(console.nextLine());

        if (value >= 10 && value < 26) {
            System.out.println("Value is in the acceptable range.");
        }
    }
}
