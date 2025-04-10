
public class Candidate extends Person {

    private String candidateId;
    private String partyAffiliation;

    public Candidate(String name, int age, String candidateId, String partyAffiliation) {
        super(name, age);
        this.candidateId = candidateId;
        this.partyAffiliation = partyAffiliation;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public String getPartyAffiliation() {
        return partyAffiliation;
    }
}
