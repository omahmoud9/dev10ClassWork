import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Exercise05 {

    private LocalDate nextFriday(LocalDate date) {
        LocalDate friday = date;
        do {
            friday = friday.plusDays(1);
        } while (friday.getDayOfWeek() != DayOfWeek.FRIDAY);
        return friday;
    }

    // THE GODMOTHER
    // ========================
    // Complete the numbered tasks below.
    // Open and execute the accompanying tests to confirm your solution is correct.

    // 1. Your Godmother gives you $10 every other Friday throughout the year.
    // Payments start on the first Friday of the year.
    // Given a date, calculate payments expected from that date until the end of the year.
    BigDecimal calculateGiftsTilEndOfYear(LocalDate date) {
      BigDecimal result = BigDecimal.ZERO;
      List<LocalDate> payDays = getOddFridays(date.getYear());

      for (LocalDate payday: payDays) {
          if (date.compareTo(payday) <= 0){
              result = result.add(BigDecimal.TEN);
          }
      }


      return result;
    }

    private LocalDate firstFridayOfYear(int year) {
        LocalDate firstFriday = LocalDate.of(year,1,1);
        while(firstFriday.getDayOfWeek() != DayOfWeek.FRIDAY) {
            firstFriday = firstFriday.plusDays(1);
        }
        return firstFriday;
    }

    private List<LocalDate> getOddFridays(int year) {
        ArrayList<LocalDate> fridays = new ArrayList<>();
        LocalDate newYears = LocalDate.of(year + 1, 1, 1);
        LocalDate friday = firstFridayOfYear(year);
        do {
            fridays.add(friday);
            friday = friday.plusWeeks(2);
        }while (friday.isBefore(newYears));
        return fridays;
    }

    // 2. Your Godmother is getting quirky. She adjusted her payment schedule.
    // She still pays every other Friday throughout the year, starting on the first Friday of the year.
    // But now, she pays a number of dollars equal to the day of the month.
    // Examples
    // Jan 31 == $31
    // Mar 1 == $1
    // July 12 == $12
    // Given a date, calculate payments expected from that date until the end of the year.
    BigDecimal calculateQuirkyGiftsTilEndOfYear(LocalDate date) {
        BigDecimal result = BigDecimal.ZERO;
        List<LocalDate> payDays = getOddFridays(date.getYear());

        for (LocalDate payday: payDays) {
            if (date.compareTo(payday) <= 0){
                result = result.add(BigDecimal.valueOf(payday.getDayOfMonth()));
            }
        }
        return result;
    }
}
