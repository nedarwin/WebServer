import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class WebServer {
    private static BufferedReader in;
    private static BufferedWriter out;
    private static ServerSocket serv;
    private static Socket clientSocket;

    public static void main(String[] args) throws IOException {
        while (true) {
            try {
                serv = new ServerSocket(1234);
                System.out.println("Сервер запущен");
                clientSocket = serv.accept();
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            } catch (Exception r) {
            }
            Scanner sc = new Scanner(System.in);

            try {
                String mess = in.readLine();
                if (mess.equals("bye")) {
                    clientSocket.close();
                    in.close();
                    out.close();
                    System.out.println("Сервер закрыт");
                    serv.close();
                    System.exit(0);
                }


                System.out.println(mess);
                String mess2 = sc.nextLine();
                out.write(mess2 + "\n");
                out.flush();
            } catch (Exception e) {
            }




        }

    }
}
