package learn.stringproperties;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringPropertiesTest {

    @Test
    void isPangramShouldBeTrueForValidPangram() {
        String pangram = "The quick brown fox jumps over a lazy dog";
        StringProperties stringProps = new StringProperties(pangram);

        boolean result = stringProps.isPangram(pangram);

        assertTrue(result);
    }
}