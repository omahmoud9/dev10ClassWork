import java.util.Scanner;

public class Exercise12 {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Enter a phrase: ");
        String phrase = console.nextLine();
        int numberOfX = 0;

        for (int i = 0; i<phrase.length(); i++){
            if(phrase.charAt(i) == 'x') {
            numberOfX++;
            }
        }
        if(numberOfX > 0){
            System.out.println("Number of x's: " + numberOfX);
        }else
            System.out.println("No x's found");

        // 1. Write a loop to determine if the letter `x` occurs in a user-entered phrase.
        // 2. Print a message for both finding and not finding the `x`.
    }
}
