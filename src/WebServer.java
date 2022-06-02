import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    private static BufferedReader in;
    private static BufferedWriter out;
    private static ServerSocket serv;
    private static Socket clientSocket;
    public static void main(String[] args) throws IOException {
        while(true){
            try {
                serv = new ServerSocket(23);
                System.out.println("Сервер запущен");
                clientSocket = serv.accept();
                try {
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                    String mess = in.readLine();
                    System.out.println(mess);
                    out.write("Вы написали"+mess+"\n");
                    out.flush();
                } finally {
                    clientSocket.close();
                    in.close();
                    out.close();
                }
            } finally {
                System.out.println("Сервер закрыт");
                serv.close();
            }
        }

    }
}