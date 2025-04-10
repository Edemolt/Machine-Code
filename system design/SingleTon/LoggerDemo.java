
public class LoggerDemo {

    public static void main(String[] args) {
        LoggerSingleTon logger1 = LoggerSingleTon.getInstance();
        System.out.println("Logger 1: " + logger1);

        LoggerSingleTon logger2 = LoggerSingleTon.getInstance();
        System.out.println("Logger 2: " + logger2);
    }
}
