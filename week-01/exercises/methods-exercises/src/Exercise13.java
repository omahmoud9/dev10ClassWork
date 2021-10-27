public class Exercise13 {

    // 1. Create a method.
    // Name: areInOrder
    // Inputs: int, int, int
    // Output: boolean
    // Description: return true if the three parameters are in ascending order.
    // Otherwise, returns false.
    // (See Exercise07.)
    public static boolean areInOrder(int one, int two, int three){
        boolean order = false;
        if(one<two && two < three ){
            order = true;
        }
        return order;
    }
    public static boolean areContiguous(int one, int two, int three){
        boolean contiguous = false;
        if( two +1 == one || two - 1 == one) {
            if (three +1 == two || three - 1 == two) {
                contiguous = true;
            }
        }
        return contiguous;
    }

    // 2. Create a method.
    // Name: areContiguous
    // Inputs: int, int, int
    // Output: boolean
    // Description: return true if a parameter is one step away from the next parameter. That is, they're "next to" one
    // another. A step can be either a step up or a step down.
    // Otherwise, returns false.
    // Examples
    // 1, 2, 3 -> true
    // 1, 1, 2 -> false (first param must be either one less or one more than the second)
    // 1, 2, 1 -> true
    // 1, 5, 7 -> false
    // 0, 1, 2 -> true
    // 7, 6, 5 -> true
    // 7, 5, 6 -> false
    // 1, 0, 1 -> true

        public static boolean isAscendingContiguous(int one, int two, int three){
            boolean both = false;
            boolean ascending = areInOrder(one,two,three);
            boolean contiguous = areContiguous(one,two,three);
            if (ascending && contiguous){
                both = true;
            }
            return both;

    }
    // 3. Create a method.
    // Name: isAscendingContiguous
    // Inputs: int, int, int
    // Output: boolean
    // Description: return true if the three parameters are in ascending order and are contiguous
    // Otherwise, returns false.
    // Hint: call areInOrder and areContiguous. Neither method can guarantee the result alone, but together they solve
    // the problem.

    public static void main(String[] args) {
        // 4. Uncomment the code below and confirm it works.
         System.out.println(isAscendingContiguous(3, 4, 5)); // true
         System.out.println(isAscendingContiguous(-10, 4, 100)); // false
         System.out.println(isAscendingContiguous(2, 1, 2)); // false
         System.out.println(isAscendingContiguous(5, 4, 3)); // false, not ascending
    }
}
