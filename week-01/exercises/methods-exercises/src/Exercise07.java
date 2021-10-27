public class Exercise07 {

    // 1. Create a method.
    // Name: areInOrder
    // Inputs: int, int, int, int
    // Output: boolean
    // Description: return true if the four parameters are in ascending order.
    // Otherwise, returns false.

    public static void main(String[] args) {
        // 2. Call your method in various ways to test it here.
        System.out.println(areInOrder(1,2,3,4));
        System.out.println(areInOrder(2,1,3, 5));
        System.out.println(areInOrder(4,7,2, 5));
    }
    public static boolean areInOrder(int one, int two, int three, int four){
        boolean order = false;
        if(one<two && two < three && three < four){
            order = true;
        }
        return order;
    }
}

