package multithread;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;
import java.io.PrintWriter;
import java.lang.Thread;
public class Server {


    public Consumer<Socket> getConsumer(){
        return (clientSocket)->{
            try{
                PrintWriter toClient=new PrintWriter(clientSocket.getOutputStream());
                toClient.println("Hello from this new server");
                toClient.close();
                clientSocket.close();

            }catch(Exception e){
                e.printStackTrace();    

            }
        }

    }
    public static void main(String[] args) {
        int port =3000;
        Server server=new Server();
        try{
            ServerSocket serverSocket=new ServerSocket(port);
            serverSocket.setSoTimeout(70000);
            System.out.println("Server is running on the port"+port);
            while(true){
                Socket clientSocket=serverSocket.accept();
                Thread thread=new Thread(()->server.getConsumer().accept(clientSocket));
                thread.start();

            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}
