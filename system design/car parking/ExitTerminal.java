
import java.time.Duration;
import java.time.LocalTime;

public class ExitTerminal extends Terminal {

    public ExitTerminal(Ticket ticket) {
        printExitTicket(ticket);
        calculateFair(ticket);
        getpayment(ticket);
    }

    void calculateFair(Ticket ticket) {
        System.out.println(
                Duration.between(ticket.getEnterTime(), LocalTime.now()).toMillis() * 100
        );
        System.out.println("Your charges, please pay on next screen");
    }

    void getpayment(Ticket ticket) {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
    }

}
