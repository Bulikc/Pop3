import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket=new Socket("localhost",110);
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            String line = null;
            while(true) {
                line = in.readUTF(); // ожидаем пока клиент пришлет строку текста.
                System.out.println("Server: " + line);
                System.out.println("send message");
                Scanner sc=new Scanner(System.in);
                //String message=sc.nextLine();
                out.writeUTF("USER 1111\n"); // отсылаем клиенту обратно ту самую строку текста.
                  out.flush(); // заставляем поток закончить передачу данных.
               // System.out.println("+OK POP3 server ready");


            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
