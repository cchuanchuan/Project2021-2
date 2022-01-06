import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServerThread extends Thread {

    private String name;
    InputStream is = null;
    OutputStream os = null;
    private Socket socket = null;

    public ServerThread(String name, Socket socket) {
        this.name = name;
        this.socket = socket;
        try {
            is = socket.getInputStream();
            os = socket.getOutputStream();
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
                        System.out.println("LOG:BROADCAST_MESSAGE-- "+username+": " + message);

                        // broadcast
                        for (ServerThread thread : ServerImpl.threadList) {
                            thread.os.write(MessageEnum.BROADCAST_MESSAGE);
                            thread.os.write(username.getBytes().length);
                            thread.os.write(username.getBytes());
                            thread.os.write(message.getBytes().length);
                            thread.os.write(message.getBytes());
                        }
                        break;
                    }
                    case MessageEnum.DISCONNECT_MESSAGE: {
                        int usernameSize = is.read();
                        byte[] usernameByte = new byte[usernameSize];
                        is.read(usernameByte);
                        String username = new String(usernameByte);

                        // broadcast
                        for (ServerThread thread : ServerImpl.threadList) {
                            if (thread.name.equals(username)){
                                String message = "You are no longer connected!";
                                thread.os.write(MessageEnum.DISCONNECT_MESSAGE);
                                thread.os.write(message.getBytes().length);
                                thread.os.write(message.getBytes());
                                System.out.println(username+" disconnected!");
                                thread.interrupt();
                            }
                        }
                        break;
                    }
                    case MessageEnum.QUERY_CONNECTED_USERS: {
                        int usernameSize = is.read();
                        byte[] usernameByte = new byte[usernameSize];
                        is.read(usernameByte);
                        String username = new String(usernameByte);

                        System.out.println("end:"+username);

                        // broadcast
                        for (ServerThread thread : ServerImpl.threadList) {
                            if (thread.name.equals(username)){
                                thread.os.write(MessageEnum.QUERY_USER_RESPONSE);
                                thread.os.write(ServerImpl.threadList.size());
                                for (int i = 0; i < ServerImpl.threadList.size(); i++) {
                                    String message = ServerImpl.threadList.get(i).name;
                                    thread.os.write(message.getBytes().length);
                                    thread.os.write(message.getBytes());
                                }
                            }
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
                        String rec = new String(recByte);

                        int messageSize = is.read();
                        byte[] messageByte = new byte[messageSize];
                        is.read(messageByte);
                        String message = new String(messageByte);

                        // broadcast
                        for (ServerThread thread : ServerImpl.threadList) {
                            if (thread.name.equals(rec)){
                                thread.os.write(MessageEnum.DIRECT_MESSAGE);
                                thread.os.write(username.getBytes().length);
                                thread.os.write(username.getBytes());
                                thread.os.write(rec.getBytes().length);
                                thread.os.write(rec.getBytes());
                                thread.os.write(message.getBytes().length);
                                thread.os.write(message.getBytes());
                            }

                        }
                        break;
                    }
                    case MessageEnum.SEND_INSULT: {
                        int usernameSize = is.read();
                        byte[] usernameByte = new byte[usernameSize];
                        is.read(usernameByte);
                        String username = new String(usernameByte);

                        int recSize = is.read();
                        byte[] recByte = new byte[recSize];
                        is.read(recByte);
                        String rec = new String(usernameByte);

                        String message = username+" -> " +rec+": "+InsultComponent.getRandomInsult();

                        // broadcast
                        for (ServerThread thread : ServerImpl.threadList) {
                            thread.os.write(MessageEnum.BROADCAST_MESSAGE);
                            thread.os.write(username.getBytes().length);
                            thread.os.write(username.getBytes());
                            thread.os.write(message.getBytes().length);
                            thread.os.write(message.getBytes());
                        }
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("read wrong message!");
                continue;
            }
        }

    }

    public void close() {
        try {
            if (os != null)
                os.close();
            if (is != null)
                is.close();
            if (socket != null)
                socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(String message) {
        try {
            os.write(message.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
