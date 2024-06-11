import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
        public static void main(String[] args)
    {
        try {
            int port = 1234;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Chat Server is running on port "+ port);
            int id = 1;
            while (true) {
                try{
                    Socket socket = serverSocket.accept();

                    Multithreadusers thread = new Multithreadusers(socket,id++);
                    thread.start();

                } catch (IOException e){
                    e.printStackTrace();
                }
                
            }

        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}


