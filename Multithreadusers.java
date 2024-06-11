import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.ArrayList;

public class Multithreadusers extends Thread{

private Socket socket;
private BufferedReader in;
private PrintWriter out;
private int id;
private static ArrayList<Multithreadusers> list = new ArrayList <Multithreadusers>();

public Multithreadusers (Socket s, int id){
    this.socket = s;
    this.id = id;
    list.add(this);
}

@Override
public void run(){
        try{
            out = new PrintWriter(socket.getOutputStream(),true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            while (!socket.isClosed()) {
                String input = in.readLine();
                if (input != null){
                    for (Multithreadusers user : list){
                        if (user.equals(this)) continue;
                        user.getWriter().println("User"+ id +": "+ input);
                    }
                }
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public PrintWriter getWriter(){
        return out;
    }
}
