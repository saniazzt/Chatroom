import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Client {
public static void main(String[] args){

    try{
    Socket socket = new Socket("localhost", 1234);
    System.out.println("Connected to chat server");
    
    PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    BufferedReader user = new BufferedReader(new InputStreamReader(System.in));

    Scanner scanner = new Scanner(System.in);
        
    while(!socket.isClosed()){

        if (in.ready()){
            String input = in.readLine();
            if (input != null){
                System.out.println(input);
            } 
        }

        if(user.ready()){
            out.println(user.readLine());
        }
    }

    }catch (Exception e) {
        System.out.println("Couldn't connect to chat server.");
        e.printStackTrace();
    }
    }
}
