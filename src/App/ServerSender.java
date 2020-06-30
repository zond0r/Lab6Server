package App;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ServerSender {
    public static Socket currentClientSocket;

    public static void send(Object o, int answer) {
        try {
            Map<Object, Integer> answerMap = new HashMap<>();
            answerMap.put(o, answer);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(currentClientSocket.getOutputStream());
            objectOutputStream.writeObject(answerMap);
            System.out.println("Отправил ответ клиенту.");
        } catch (IOException e) {
            System.err.println();
        }
    }
}
