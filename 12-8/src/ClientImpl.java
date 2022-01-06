import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientImpl implements ClientInterface, Runnable {

    String commands = "logoff:sends a DISCONNECT_MESSAGE to the server\n" +
            "who: sends a QUERY CONNECTED USERS to the server\n" +
            "@user: sends a DIRECT MESSAGE to the specified user to the server\n" +
            "@all: sends a BROADCAST MESSAGE to the server, to be sent to all users connected\n" +
            "!user: sends a SEND INSULT message to the server, to be sent to the specified user";
    Socket socket;
    OutputStream os;
    InputStream is;
    static  Scanner sc = new Scanner(System.in);
    private final String userName;

    public ClientImpl(String userName,String ipAddress, int port) {
        this.userName = userName;
        try {
            socket = new Socket(ipAddress, port);
            os = socket.getOutputStream();
            is = socket.getInputStream();

            // 发送连接请求
            os.write(MessageEnum.CONNECT_MESSAGE);
            os.write(userName.getBytes().length);
            os.write(userName.getBytes());

            // 获取连接响应
            int type = is.read();
            if (type != MessageEnum.CONNECT_RESPONSE){
                System.out.println("Get message wrong!");
                return;
            }
            int success = is.read();
            int messageSize = is.read();
            byte[] messageByte = new byte[messageSize];
            is.read(messageByte);
            String message = new String(messageByte);

            if (success == 0){
                System.out.println("Connect failure: "+message);
                return;
            }else {
                System.out.println("Connect success!");
                System.out.println(message);
            }

            // 发送消息
            Thread thread = new Thread(this);
            thread.start();

            // 接收消息
            String line = "";
            while (true) {
                line = sc.nextLine();
                send(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void send(String command) throws IOException {
        if (command.trim().equals("?")){
            System.out.println(commands);
            return;
        }
        command = command.trim();
        switch (command.trim()) {
            case "logoff": {
                System.out.println("log:logoff");

                os.write(MessageEnum.DISCONNECT_MESSAGE);
                os.write(userName.getBytes().length);
                os.write(userName.getBytes());
                break;
            }
            case "who": {
                System.out.println("log:who");
                os.write(MessageEnum.QUERY_CONNECTED_USERS);
                os.write(userName.getBytes().length);
                os.write(userName.getBytes());
                break;
            }
            case "@user": {
                System.out.println("Please input recipient name:");
                String recipient = sc.nextLine();
                System.out.println("Please input message:");
                String message = sc.nextLine();
                os.write(MessageEnum.DIRECT_MESSAGE);
                os.write(userName.getBytes().length);
                os.write(userName.getBytes());
                os.write(recipient.getBytes().length);
                os.write(recipient.getBytes());
                os.write(message.getBytes().length);
                os.write(message.getBytes());

                break;
            }
            case "@all": {
                System.out.println("Please input message:");
                String message = sc.nextLine();
                os.write(MessageEnum.BROADCAST_MESSAGE);
                os.write(userName.getBytes().length);
                os.write(userName.getBytes());
                os.write(message.getBytes().length);
                os.write(message.getBytes());
                break;
            }
            case "!user": {
                System.out.println("Please input recipient name:");
                String recipient = sc.nextLine();
                os.write(MessageEnum.SEND_INSULT);
                os.write(userName.getBytes().length);
                os.write(userName.getBytes());
                os.write(recipient.getBytes().length);
                os.write(recipient.getBytes());
                break;
            }
            default: {

            }
        }
    }

    @Override
    public void close() {
        try {
            is.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        while (true) {
            try {
                int type = is.read();
                switch (type) {
                    case MessageEnum.BROADCAST_MESSAGE: {
                        int usernameSize = is.read();
                        byte[] usernameByte = new byte[usernameSize];
                        is.read(usernameByte);
                        String username = new String(usernameByte);
                        int messageSize = is.read();
                        byte[] messageByte = new byte[messageSize];
                        is.read(messageByte);
                        String message = new String(messageByte);
                        System.out.println(username + ": " + message);
                        break;
                    }
                    case MessageEnum.DISCONNECT_MESSAGE: {
                        int messageSize = is.read();
                        byte[] messageByte = new byte[messageSize];
                        is.read(messageByte);
                        String message = new String(messageByte);
                        System.out.println("Disconnect success: "+message);
                        System.exit(0);
                        break;
                    }
                    case MessageEnum.QUERY_USER_RESPONSE: {
                        int number = is.read();
                        for (int i = 0; i < number; i++) {
                            int messageSize = is.read();
                            byte[] messageByte = new byte[messageSize];
                            is.read(messageByte);
                            String message = new String(messageByte);

                            System.out.println("User "+(i+1)+": "+message);
                        }

                        break;
                    }
                    case MessageEnum.DIRECT_MESSAGE: {
                        int usernameSize = is.read();
                        byte[] usernameByte = new byte[usernameSize];
                        is.read(usernameByte);
                        String username = new String(usernameByte);

                        int recSize = is.read();
                        byte[] recByte = new byte[recSize];
                        is.read(recByte);
                        String rec = new String(usernameByte);

                        int messageSize = is.read();
                        byte[] messageByte = new byte[messageSize];
                        is.read(messageByte);
                        String message = new String(messageByte);

                        System.out.println(username + ": " + message);
                        break;
                    }
                }
            } catch (IOException e) {
                System.out.println("read wrong message!");
                continue;
            }
        }

    }


    public static void main(String[] args) {
        String user = "CLIENT2";
        String ip = "127.0.0.1";
        int port = 8000;
        System.out.println("Please input ip:");
        ip = sc.nextLine();
        System.out.println("Please input port:");
        port = Integer.parseInt(sc.nextLine());
        System.out.println("Please input username:");
        user = sc.nextLine();
        ClientImpl client = new ClientImpl(user,ip,port);

    }
}
