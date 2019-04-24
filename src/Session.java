import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class Session implements Runnable {

    private Socket clientSocket;
    public Session(Socket clientSocket) {
         this.clientSocket=clientSocket;

    }

    private String readRequest(DataInputStream in) throws IOException  {
        int contentSize = in.readInt();
        byte[] data = new byte[contentSize];
        in.readFully(data);
       // System.out.println(contentSize);
        return new String(data);
    }

    @Override
    public void run() throws NullPointerException {

        try (Socket clientSocke=this.clientSocket){
            InputStream sin = clientSocket.getInputStream();
            OutputStream sout = clientSocket.getOutputStream();

            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            String line = null;
            String lines="+OK POP3 server ready\r\n";
            sout.write( lines.getBytes());
            sout.flush();
            Commands commands=new Commands();

            while(!commands.isAuthorization()) {

               line = in.readLine();
               if(line !=null) {

            System.out.println("client: " + line);
                   String rezult="";

                rezult=commands.AuthorizationCommand(line);
            rezult+="\r\n";
                   System.out.print("return= "+rezult);

                   sout.write( rezult.getBytes());
        sout.flush();
                //   System.out.println("client:111 " + commands.isAuthorization());

    }

            }

            while(true) {

                line = in.readLine();
                if(line.length()>0) {
                    System.out.println("!!!!!!!!!!!!!!!");
                    System.out.println("client: " + line);
                    String rezult="";

                        rezult=commands.executeCommand(line);

                    // String rezult=commands.executeCommand(line);
                    rezult+="\r\n";
                    sout.write( rezult.getBytes());
                    sout.flush();

                }

            }

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
