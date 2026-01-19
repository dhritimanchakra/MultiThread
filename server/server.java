package server;

import java.net.ServerSocket;

public class server {

    public void run(){
        int port=3000;
        ServerSocket socket=new ServerSocket(port);
        socket.setSoTimeout(port);
    }
    public static void main(String[] args) {
        
    }
    
}
