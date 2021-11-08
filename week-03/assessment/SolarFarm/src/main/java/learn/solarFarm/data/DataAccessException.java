package learn.solarFarm.data;

public class DataAccessException extends Exception {

    public DataAccessException(String message, Throwable rootcause) {
        super(message, rootcause);
    }

}