import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) {
        try(ServerSocket socket = new ServerSocket(8020)){
            System.out.println("Listening...");
            if(!socket.isClosed()){
                while(true){
                    Socket soc =  socket.accept();
                    Runnable r = new Thread(soc);
                    Thread t = new Thread(r);
                    t.start();
                    System.out.println("Clients connected: ");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}