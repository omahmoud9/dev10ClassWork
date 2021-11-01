import java.util.Scanner;

public class Exercise09 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println(" min value?");
        int min = Integer.parseInt(console.nextLine());

        System.out.println(" max value?");
        int max = Integer.parseInt(console.nextLine());

        System.out.println(" actual value?");
        int actual = Integer.parseInt(console.nextLine());

        if (min < actual && max > actual){
            System.out.println("true");
        }else {
            System.out.println("False");
        }
    }
}
