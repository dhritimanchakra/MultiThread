package multithread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {


    public Runnable getRunnable() {
    return new Runnable() {
        @Override
        public void run() {
            try {
                int port = 3000;
                InetAddress address = InetAddress.getByName("localhost");
                Socket socket = new Socket(address, port);

                PrintWriter toSocket =
                    new PrintWriter(socket.getOutputStream(), true);
                BufferedReader fromSocket =
                    new BufferedReader(new InputStreamReader(socket.getInputStream()));

                toSocket.println("Hello from meeeeeeeeee");
                String line = fromSocket.readLine();
                System.out.println("Received from server: " + line);

                fromSocket.close();
                toSocket.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
                }
            }
        };
    }

    public static void main(String[] args) {
        Client cl=new Client();
        for(int i=0;i<100;i++){
            try{
                Thread thread=new Thread(cl.getRunnable())
                thread.start();
            }catch(Exception e){
                return; 
            }
        }
    }
    
}
