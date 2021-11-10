import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Exercise01 {


    private LocalDate nextFriday(LocalDate date) {
        LocalDate friday = date;
        do {
            friday = friday.plusDays(1);
        } while (friday.getDayOfWeek() != DayOfWeek.FRIDAY);
        return friday;
    }

    // LocalDate
    // ========================
    // Complete the numbered tasks below.
    // Open and execute the accompanying tests to confirm your solution is correct.

    // 1. return today's date
    LocalDate getToday() {
        return LocalDate.now();
    }

    // 2. return December 17, 1903 as a LocalDate
    LocalDate getFirstFlightDate() {
        return LocalDate.of(1903,12,17);
    }

    // 3. if parameter is in the future, return null.
    // Otherwise, add 5 days to the parameter and return the result.
    LocalDate makeFutureNullShiftThePast(LocalDate date) {
        return date.isAfter((getToday()))
                ? null
                : date.plusDays(5);
    }

    // 4. return the fifth Friday from the parameter date.
    // if the date is Friday, don't count it.
    LocalDate fiveFridaysFromDate(LocalDate date) {
        LocalDate dateInFiveWeeks = date.plusWeeks(5);
        if(dateInFiveWeeks.getDayOfWeek() == DayOfWeek.FRIDAY){
            dateInFiveWeeks = dateInFiveWeeks.plusDays(7);
        }
        while(dateInFiveWeeks.getDayOfWeek() != DayOfWeek.FRIDAY){
            dateInFiveWeeks = dateInFiveWeeks.plusDays(1);
        }

        return dateInFiveWeeks;
    }

    // 5. given a date and a count,
    // return a list of the next `fridayCount` Fridays after the date.
    // if the date is Friday, don't include it.
    List<LocalDate> getNextFridays(LocalDate date, int fridayCount) {
        List<LocalDate> fridays = new ArrayList<>();
        LocalDate nextFriday = nextFriday(date);
        int numberOfFridays = 0;
        for( int index=0; index<fridayCount; index++) {
            fridays.add(nextFriday);
            nextFriday= nextFriday.plusWeeks(1);
        }
        return fridays;
    }





//     6. return the absolute value of the days between two dates.
//     one may be before two, two may be before one, but neither will be null
    int getDaysBetween(LocalDate one, LocalDate two) {
       // return (int)Math.abs(ChronoUnit.DAYS.between(one,two));
        return Math.abs((int)one.until(two,ChronoUnit.DAYS));
    }

}
