import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class warmupTest {
    private warmup warm = new warmup();
    private IllegalArgumentException e = new IllegalArgumentException();
    private BigDecimal salary = new BigDecimal(40000);

    @Test
    void calculateGrossSalaryShouldReturnFullSalary() {
        LocalDate startDate = LocalDate.of(2021,1,1);
        BigDecimal expected = salary;
        BigDecimal actual = warm.calculateGrossSalary(startDate,salary);

        assertEquals(expected,actual);
    }

    void calculateGrossSalaryShouldThrowIllegalArgumentException(){
        BigDecimal salary = new BigDecimal(30000);
        LocalDate notFirst = LocalDate.of(2021,1,2);
        try{
            warm.calculateGrossSalary(notFirst,salary);
            assertFalse(true);
        }catch(IllegalArgumentException e){
            assertTrue(true);
        }
    }


}