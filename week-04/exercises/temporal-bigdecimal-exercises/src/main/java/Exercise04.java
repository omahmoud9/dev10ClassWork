import java.math.BigDecimal;
import java.math.RoundingMode;

public class Exercise04 {

    // BigDecimal
    // ========================
    // Complete the numbered tasks below.
    // Open and execute the accompanying tests to confirm your solution is correct.

    // 1. add a, b, and c together and return the result
    BigDecimal add(BigDecimal a, BigDecimal b, BigDecimal c) {
        BigDecimal sum = a.add(b.add(c));
        return sum;
    }

    // 2. divide a by b and return the result with only two decimal points
    BigDecimal divideWithTwoDecimalPlaces(BigDecimal a, BigDecimal b) {
        BigDecimal result = a.divide(b, 2, RoundingMode.HALF_EVEN);
        return result;
    }

    // 3. calculate the sum of elements in values and return it
    // with a scale of 4.
    BigDecimal sum(BigDecimal[] values) {
        BigDecimal sum = new BigDecimal(0);
        for(int index=0; index < values.length; index++ ) {
            sum = sum.add(values[index]);
        }
        return sum;
    }

    // 4. calculate the average of elements in values
    BigDecimal average(BigDecimal[] values) {
        BigDecimal average = new BigDecimal(0);
        for(BigDecimal existing: values) {
            average = average.add(existing);
        }
        BigDecimal length = new BigDecimal(values.length);
        average = average.divide(length);
        return average.setScale(4, RoundingMode.HALF_EVEN);
    }

    /**
     * 5. complete the calculateInterest method using the spec below.
     * <p>
     * Calculates the total interest earned on an investment.
     * Does *not* calculate the final balance, just the interest over and above the initial investment.
     *
     * @param investment   the starting balance
     * @param interestRate the interest rate expressed
     * @param periods      number of periods in which to apply the interest
     * @return total interest earned (final balance - initial investment)
     */
    BigDecimal calculateInterest(BigDecimal investment, BigDecimal interestRate, int periods) {
        BigDecimal balance = investment;
        for(int index=0; index < periods; index++){
            balance = balance.add(balance.multiply(interestRate));
        }
        return balance.subtract(investment);
    }
}
