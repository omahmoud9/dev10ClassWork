import java.util.Locale;

public class Exercise03 {

    // 1. Read the hasAllVowels JavaDocs.
    // 2. Complete the hasAllVowels method.
    // 3. Create tests to fully test hasAllVowels and confirm that it's 100% correct.

    /**
     * Determines if a String contains all English vowels: a, e, i, o, and u.
     * Both uppercase and lowercase vowels are allowed.
     * The `null` value should return false.
     *
     * @param value the string to test
     * @return true if the value contains all 5 vowels, false if it doesn't
     */
    static boolean hasAllVowels(String value) {
        int hasA =0;
        int hasE =0;
        int hasI =0;
        int hasO =0;
        int hasU =0;
        String valueLowercase = value.toLowerCase(Locale.ROOT);
        for (int i = 0; i<value.length(); i++){
            if (valueLowercase.charAt(i) == 'a'){
                hasA = 1;
            }else if (valueLowercase.charAt(i) == 'e'){
                hasE = 1;
            }else if (valueLowercase.charAt(i) == 'i') {
                hasI = 1;
            }else if (valueLowercase.charAt(i) == 'o') {
                hasO = 1;
            }else if (valueLowercase.charAt(i) == 'u'){
                hasU = 1;}
        }
        if (hasA + hasE + hasI + hasO + hasU ==5)
            return true;

        return false;
    }
}
