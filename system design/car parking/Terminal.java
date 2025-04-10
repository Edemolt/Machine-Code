
import java.time.Duration;
import java.time.LocalTime;

public abstract class Terminal {

    void printEntryTicket(Ticket ticket) {
        System.out.println("---------------------------------------");
        System.out.println();
        System.out.println("Entry Ticket:");
        System.out.println("Car No: " + ticket.getCar().getCarNo());
        System.out.println("Spot No: " + ticket.getSpotId());
        System.out.println("Entry Date: " + ticket.getEnterTime());
        System.out.println("---------------------------------------");
        System.out.println();
    }

    void printExitTicket(Ticket ticket) {
        System.out.println("---------------------------------------");
        System.out.println();
        System.out.println("Exit Ticket:");
        System.out.println("Car No: " + ticket.getCar().getCarNo());
        System.out.println("Spot No: " + ticket.getSpotId());
        System.out.println("Entry Time: " + ticket.getEnterTime());
        System.out.println("Exit Time: " + LocalTime.now());
        System.out.println("Total Duration: " + Duration.between(ticket.getEnterTime(), LocalTime.now()));
        System.out.println("---------------------------------------");
        System.out.println();
    }
}
