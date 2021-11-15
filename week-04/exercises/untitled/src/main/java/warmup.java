import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class warmup {
//  * Write a method that accepts an employee's yearly salary and start date
//    and calculates their gross salary from the provided start date up through the end of the year
//  * Employees always start on the first of the month
//  * Throw an `IllegalArgumentException` if the provided start date is not the first of the month
//* Employees qualify for a 3% pay raise 3 months after their start date and another 6% 3 months after that
//* Use appropriate data types
//* Write unit tests to ensure that your method works as expected using a variety of method argument values
//* **Stretch goals**
//  * Write a unit test that confirms your method throws an `IllegalArgumentException` if the start date argument is not the first of the month
//  * Write a second method that returns a `HashMap` whose key's are the months and the values are the gross salary for that month


    public static void main(String[] args) {


    }


    public BigDecimal calculateGrossSalary(LocalDate date, BigDecimal salary) throws IllegalArgumentException{

        if(date.getDayOfMonth() != 1) {
            IllegalArgumentException e = new IllegalArgumentException("Not first of month");
            throw e;
        }

        LocalDate newYear = LocalDate.of(date.getYear()+1, 1, 1);
        BigDecimal monthsWorked = new BigDecimal(0);
        while (date.isBefore(newYear)) {
            monthsWorked = monthsWorked.add(BigDecimal.valueOf(1));
            date = date.plusMonths(1);
        }
        BigDecimal grossPayment = salary.multiply(monthsWorked.divide(BigDecimal.valueOf(12)));
        return grossPayment;
    }


}
