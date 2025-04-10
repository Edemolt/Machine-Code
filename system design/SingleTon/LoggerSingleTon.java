
public class LoggerSingleTon {

    // private static LoggerSingleTon instance = new LoggerSingleTon(); 
    private static volatile LoggerSingleTon instance = null;

    private LoggerSingleTon() {
        // Private constructor to prevent instantiation
        if (instance != null) {
            throw new IllegalStateException("Instance already created.");
        }
    }

    public static synchronized LoggerSingleTon getInstance() {
        if (instance == null) {
            if (LoggerSingleTon.class) {
                if (instance == null) {
                    instance = new LoggerSingleTon(); // Lazy initialization
                }
            }
        }
        return instance;
    }
}
