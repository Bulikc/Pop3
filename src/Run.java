import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Run {
    public static void main(String[] args)  {
        try {
            ServerSocket server = new ServerSocket(110);
            while (true) {

                Socket newClientSocket = server.accept();
                System.out.println("1");
                new Thread(new Session(newClientSocket), "1").start();
            }
        } catch (IOException e) {

        }



    }
}
