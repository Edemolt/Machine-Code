
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 3000);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Enter 1 to enqueue");
            System.out.println("Enter 2 to dequeu");
            int choice = Integer.parseInt(br.readLine());
            if (choice == 1) {
                System.out.println("Enter the number to push");
                int num = Integer.parseInt(br.readLine());

                out.println("ENQUEUE");
                out.println(num);
                System.out.println("Server says: " + in.readLine());

            } else if (choice == 2) {
                out.println("DEQUEUE");
                System.out.println("Server says: " + in.readLine());
            }
        }
    }

}
