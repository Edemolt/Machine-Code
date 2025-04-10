
public class EntryTerminal extends Terminal {

    Car car;
    Ticket ticket;

    public EntryTerminal(Car car) {
        this.car = car;
        ticket = new Ticket(car);
        printEntryTicket(ticket);
    }

    public Ticket getTicket() {
        return ticket;
    }

}
