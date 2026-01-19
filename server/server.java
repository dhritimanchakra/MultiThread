package server;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

    public static void run(){
        int port =3000;
        
        ServerSocket socket = null;
        try {
            socket = new ServerSocket(port);
            socket.setSoTimeout(3000);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("Server is running on port " + port);
        while(true){
            
            try{
                Socket accept=socket.accept();
                System.out.println("Connection accepted"+accept.getRemoteSocketAddress());
                PrintWriter toClient=new PrintWriter(accept.getOutputStream());
                BufferedReader fromClient=new BufferedReader(new InputStreamReader(accept.getInputStream()));
                toClient.println("Hello from the server");
                toClient.close();
                fromClient.close();
                accept.close();

            }catch (IOException e){
               e.printStackTrace();
            }

        }


    }
    public static void main(String[] args) {
        server sv=new server();
        try{
            sv.run();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}
