import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerImpl implements ServerInterface {

    public static List<ServerThread> threadList = new ArrayList<>();

//    public ServerImpl() {
//        try {
//            // 创建服务端socket
//            ServerSocket serverSocket = new ServerSocket(8088);
//            int count = 0;
//
//            //循环监听等待客户端的连接
//            while (count < 10) {
//                // 监听客户端
//                Socket socket = serverSocket.accept();
//                ServerThread thread = new ServerThread("name", socket);
//                threadList.add(thread);
//                thread.start();
//                count++;
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public ServerImpl() {
        try {
            // 创建服务端socket
            int count = 0;
            int port = 8000;

            //循环监听等待客户端的连接
            while (true) {
                ServerSocket serverSocket = new ServerSocket(port++);
                Socket socket = serverSocket.accept();

                int type = socket.getInputStream().read();
                if (type == MessageEnum.CONNECT_MESSAGE){
                    int usernameSize = socket.getInputStream().read();
                    byte[] usernameByte = new byte[usernameSize];
                    socket.getInputStream().read(usernameByte);
                    String username = new String(usernameByte);
                    System.out.println("User: "+username+" connected! ");

                    if (count < 10){
                        socket.getOutputStream().write(MessageEnum.CONNECT_RESPONSE);
                        socket.getOutputStream().write(1);
                        String message = "There are "+count+" other connected clients.";
                        socket.getOutputStream().write(message.getBytes().length);
                        socket.getOutputStream().write(message.getBytes());
                    }else{
                        socket.getOutputStream().write(MessageEnum.CONNECT_RESPONSE);
                        socket.getOutputStream().write(0);
                        String message = "There are "+count+" other connected clients.";
                        socket.getOutputStream().write(message.getBytes().length);
                        socket.getOutputStream().write(message.getBytes());
                        return;
                    }

                    ServerThread thread = new ServerThread(username, socket);
                    threadList.add(thread);
                    thread.start();
                    count++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        new ServerImpl();
    }
}
