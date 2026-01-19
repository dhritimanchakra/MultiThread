package server;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
public class Client {


    public void run() throws Exception{
        int port =3000;
        InetAddress address=InetAddress.getByName("localhost");
        Socket socket=new Socket(address,port);
        PrintWriter toSocket=new PrintWriter(socket.getOutputStream());
        BufferedReader fromSocket=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        toSocket.println("Hellow from meeeeeeeeee");
        String line=fromSocket.readLine();
        System.out.println("Received from server: "+line);  
        toSocket.close();
        fromSocket.close();
        socket.close();
    }
    public static void main(String[] args) {
        Client cl=new Client();
        try{
            cl.run();
        }catch(Exception e){
            e.printStackTrace();
        }   

        
    }
    
}
