import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class isogram {

//    * Create a methods that tests whether a given String is an isogram (heterogram)
//      * https://en.wikipedia.org/wiki/Heterogram_(literature)#Isograms
//            * Use streams, no loops or intermediate variables
//
//* Bonus: ignore whitespace and special characters
//* Super bonus: test for a "perfect pangram" - a pangram which is also an isogram.

    public static void main(String[] args) {
        boolean worked = checkIsogram("aabd");
        if( worked == true) {
            System.out.println("Is isogram");
        } else {
            System.out.println("Not a isogram");
        }

    }

    public static boolean checkIsogram(String text) {
        Set<Character> checkSet = new HashSet<>();
        List<Character> characters = text.chars()
                .mapToObj(e -> Character.valueOf((char) e))
                .collect(Collectors.toList());
        for (Character checkChar : characters) {
            if (checkSet.contains(checkChar)) {
                return false;
            } else {
                checkSet.add(checkChar);
            }
        }
        return true ;
    }

}


