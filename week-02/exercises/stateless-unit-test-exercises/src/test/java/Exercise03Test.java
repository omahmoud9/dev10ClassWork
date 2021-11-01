import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise03Test {

    @Test
    void hasAllVowels() {
        assertEquals(true,Exercise03.hasAllVowels("aeiou"));
        assertEquals(true,Exercise03.hasAllVowels("AEIOU"));
        assertEquals(true,Exercise03.hasAllVowels("AeIoU"));
        assertEquals(false,Exercise03.hasAllVowels("AEIU"));
        assertEquals(false, Exercise03.hasAllVowels("aeio"));
        assertEquals(false, Exercise03.hasAllVowels("advwbtwrbwbfgbswb"));
        assertEquals(false, Exercise03.hasAllVowels("Hello World! how you doing this morning?"));
    }
}