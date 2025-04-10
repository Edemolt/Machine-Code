
public class Voter extends Person {

    private String voterId;

    public Voter(String name, int age, String voterId) {
        super(name, age);
        this.voterId = voterId;
    }

    public String getVoterId() {
        return voterId;
    }
}
