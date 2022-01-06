import java.io.IOException;

public interface ClientInterface {

    void send(String message) throws IOException;

    void close();
}
