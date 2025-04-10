
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Queue {

    private static final int PORT = 3000;

    private static final ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();

    static void clientHandler(Socket socket) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream())); PrintWriter out = new PrintWriter(socket.getOutputStream(), true);) {
            String req = br.readLine();
            if ("ENQUEUE".equals(req)) {
                int data = Integer.parseInt(br.readLine());
                queue.offer(data);
                out.println("Pushed to queue: " + data);
            } else if ("DEQUEUE".equals(req)) {
                Integer data = queue.poll();
                if (data != null) {
                    out.println("Removed from queue: " + data);
                } else {
                    out.println("Queue is empty");
                }
            } else {
                out.println("Invalid command");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Queue is running on port : " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();

            new Thread(() -> {
                try {
                    clientHandler(socket);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }

}
