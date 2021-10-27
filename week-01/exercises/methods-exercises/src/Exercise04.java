public class Exercise04 {

    public static void main(String[] args) {
        System.out.println(getFirstVowel("magnificent")); // Expected: a
        System.out.println(getFirstVowel("winsome")); // Expected: i
        System.out.println(getFirstVowel("xxx")); // Expected:
        System.out.println(getFirstVowel("bgwex"));

        // 2. Call getFirstVowel at least one more time.
    }

    // getFirstVowel returns the first vowel in a string as a char.
    // 1. Complete getFirstVowel.
    // If no vowel is found, return 0. (As a char, 0 represents the NULL value.)
    public static char getFirstVowel(String value) {
        char letter = 0;

        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == 'a') {
                letter = 'a';
                break;
            } else if (value.charAt(i) == 'e') {
                letter = 'e';
                break;
            } else if (value.charAt(i) == 'i') {
                letter = 'i';
                break;
            } else if (value.charAt(i) == 'o') {
                letter = 'o';
                break;
            } else if (value.charAt(i) == 'u') {
                letter = 'u';
                break;
            }
        }
        return letter;
    }
}

