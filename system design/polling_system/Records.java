
import java.util.*;

public class Records {

    private List<Candidate> candidates;
    private List<Voter> voters;
    private Map<Candidate, Integer> votes; // Map to store votes for each candidate

    public Records() {
        candidates = new ArrayList<>();
        voters = new ArrayList<>();
        votes = new HashMap<>();
    }

    public void addCandidate(Candidate candidate) {
        candidates.add(candidate);
    }

    public void addVoter(Voter voter) {
        voters.add(voter);
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public List<Voter> getVoters() {
        return voters;
    }

    public Candidate getCandidateById(String candidateId) {
        for (Candidate candidate : candidates) {
            if (candidate.getCandidateId().equals(candidateId)) {
                return candidate;
            }
        }
        return null; // Candidate not found
    }

    public Voter getVoterById(String voterId) {
        for (Voter voter : voters) {
            if (voter.getVoterId().equals(voterId)) {
                return voter;
            }
        }
        return null; // Voter not found
    }

    public void castVote(Voter voter, Candidate candidate) {
        if (voters.contains(voter) && candidates.contains(candidate)) {
            votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        } else {
            System.out.println("Invalid voter or candidate.");
        }
    }

    public String getVoteCnt() {
        StringBuilder sb = new StringBuilder();
        for (Candidate candidate : candidates) {
            sb.append(candidate.getName()).append(" : ")
                    .append(votes.getOrDefault(candidate, 0)).append("\n");
        }
        return sb.toString();
    }
}
