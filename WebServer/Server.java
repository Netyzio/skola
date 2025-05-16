import java.net.ServerSocket;
import java.net.Socket;
import java.io.OutputStream;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ServerSocket serverSocket = null;
try {
    serverSocket = new ServerSocket(8080);
    while (true) {
        Socket s = serverSocket.accept();

        Scanner clientSc = new Scanner(s.getInputStream());
        while(clientSc.hasNext()){
            String line = clientSc.nextLine();
            System.out.println(line);

            String response = "AAA";

            String httpResponse =
                    "HTTP/1.1 200 OK\r\n" +
                            "Content-Type: text/plain\r\n" +
                            "Content-Length: " + response.length() + "\r\n" +
                            "Connection: close\r\n" +
                            "\r\n" +
                            response;
            OutputStream out = s.getOutputStream();
            out.write(httpResponse.getBytes());
            out.flush();
        }
    }

} catch (Exception e) {
    System.out.println(e);
}
