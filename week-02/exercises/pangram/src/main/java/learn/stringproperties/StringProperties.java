package learn.stringproperties;

import java.util.Arrays;
import java.util.Locale;

public class StringProperties {

    private final String subject;

    public StringProperties(String subject) {
        this.subject = subject;
    }

    public boolean isPangram(String subject) {
        String removeCase = subject.toLowerCase();
        String removePunct = removeCase.replaceAll("\\p{Punct}", "");
        String removeWhiteSpaces = removePunct.replace(" ", "");

        if (subject == null) {
            return false;
        }
        int[] checkArray = new int[26];
        for (int i =0; i< removeWhiteSpaces.length(); i++) {
            int letter = removeWhiteSpaces.charAt(i);
            checkArray[letter - 97] +=1;
        }
        return !Arrays.asList(checkArray).contains(null);

    }
}
