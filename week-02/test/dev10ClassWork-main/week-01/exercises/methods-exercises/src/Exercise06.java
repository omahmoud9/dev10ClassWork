public class Exercise06 {

    // 1. Create a method.
    // Name: isBetween
    // Inputs: int, int, int
    // Output: boolean
    // Description: return true if the first parameter is between the second and third parameter.
    // Otherwise, returns false.

    public static void main(String[] args) {
        // 2. Call your method in various ways to test it here.
        System.out.println(isBetween(1,2,3));
        System.out.println(isBetween(2,1,3));
        System.out.println(isBetween(4,7,2));
    }

    public static boolean isBetween(int one, int two, int three){
        boolean between = false;
        if(one>two && one < three || one< two && one > three){
            between = true;
        }

        return between;
    }
}

