package server;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
public class Client {


    public void run() throws Exception{
        int port =3000;
        InetAddress address=InetAddress.getByName("localhost");
        Socket socket=new Socket(address,port);
        PrintWriter toSocket=new PrintWriter(socket.getOutputStream());
    }
    public static void main(String[] args) {

        
    }
    
}
