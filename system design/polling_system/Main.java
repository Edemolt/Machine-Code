
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    private static final int PORT = 8080;
    static Records record;

    public Main() {
        record = new Records();
    }

    static void handleVotes(Socket socket) {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); PrintWriter out = new PrintWriter(socket.getOutputStream(), true);) {
            while (true) {
                String line = in.readLine();
                if (line == null) {
                    break; // exit loop if connection is closed

                }
                int req = Integer.parseInt(line);

                if (req == 1) {
                    // Voter registration
                    String name = in.readLine();
                    int age = Integer.parseInt(in.readLine());
                    String voterId = in.readLine();

                    Voter voter = new Voter(name, age, voterId);
                    record.addVoter(voter);
                    out.println("Voter added successfully!");

                } else if (req == 2) {
                    // Candidate registration
                    String name = in.readLine();
                    int age = Integer.parseInt(in.readLine());
                    String candidateId = in.readLine();
                    String partyAffiliation = in.readLine();

                    Candidate candidate = new Candidate(name, age, candidateId, partyAffiliation);
                    record.addCandidate(candidate);
                    out.println("Candidate added successfully!");

                } else if (req == 3) {
                    // Cast vote (expects voter ID followed by candidate ID)
                    String voterId = in.readLine();
                    String candidateId = in.readLine();

                    Candidate candidate = record.getCandidateById(candidateId);
                    Voter voter = record.getVoterById(voterId);
                    if (candidate != null && voter != null) {
                        record.castVote(voter, candidate);
                        out.println("Vote cast successfully!");
                    } else {
                        out.println("Invalid candidate or voter ID.");
                    }

                } else if (req == 4) {
                    // Vote count
                    String voteCnt = record.getVoteCnt();
                    out.println(voteCnt);

                } else {
                    out.println("Invalid request. Please try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        // Initialize the Records instance
        new Main();

        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server running on port: " + PORT);

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                new Thread(() -> handleVotes(socket)).start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
