import java.util.Arrays;
import java.util.Random;

public class Exercise11 {

    public static void main(String[] args) {
        int[] values = makeRandomArray();
        int[] positive = new int[numberOfPositive(values)];
        int position = 0;
        for(int i= 0; i < values.length; i++) {

            if (values[i] % 2 == 0) {
                positive[position] = values[i];
                position++;
            }
        }
        System.out.println(Arrays.toString(positive));



        // 1. Count the number of positive elements in `values`.
        // 2. Create a new int[] to hold the positive elements.
        // (We must count first to know the capacity to allocate.)
        // 3. Loop through `values` a second time. Add positive elements to the new array.
        // 4. Confirm the positive array is properly populated either by debugging or printing its elements.
    }

    public static int[] makeRandomArray() {
        Random random = new Random();
        int[] result = new int[random.nextInt(100) + 50];
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(1000) - 500;
        }
        return result;
    }

    public static int numberOfPositive(int[] numbers){
        int numberOfPositive = 0;
        for(int i= 0; i < numbers.length; i++){
            if (numbers[i] % 2 ==0){
                numberOfPositive++;
            };
        }return numberOfPositive;
    }
}
