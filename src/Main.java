
import App.ServerReceiver;
import App.ServerSender;
import Commands.Save;
import Controller.Commandable;
import Ticket.TicketCollection;
import Utility.Decoder;
import Utility.FileRead;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String filename = "";
        if (args.length != 0) filename = args[0];
        else {
            while (filename.equals("")) {
                System.out.print("Вы не указали имя файла:\n$ ");
                filename = in.nextLine();
            }
        }
        Save.filename = filename;
        FileRead.setFilename(filename);
        ServerSender serverSender = new ServerSender();
        ServerReceiver serverReceiver = new ServerReceiver("localhost", 35259);
        TicketCollection tickets = new TicketCollection();
        tickets.setTickets(Decoder.decodeIntoCollection(FileRead.readFromFile(filename)));
        checkForSaveCommand();
        tickets.setDateOFCreation(java.time.ZonedDateTime.now());
        while (true) {
            Map<Commandable, String> commandableStringMap = (Map<Commandable, String>) ServerReceiver.receive();
            ServerReceiver.isBusy = true;

            try {
                System.out.println("Получена команда " + commandableStringMap.entrySet().iterator().next().getKey().getName() + " от клиента.");
                String answer = (String) commandableStringMap.entrySet().iterator().next().getKey().execute(commandableStringMap.entrySet().iterator().next().getValue());
                serverSender.send(answer, 0);
                ServerReceiver.isBusy = false;
            } catch (NullPointerException e) {
                ;
                ServerSender.currentClientSocket.close();
                System.out.println("Клиент не cтал заполнять поля и отключился :(");
                ServerReceiver.isBusy = false;
            }
        }
    }

    public static void checkForSaveCommand() throws IOException {
        Thread backgroundReaderThread = new Thread(() -> {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
                while (!Thread.interrupted()) {
                    String line = bufferedReader.readLine();
                    if (line == null)
                        break;
                    if (line.equalsIgnoreCase("save")) {
                        Save save = new Save();
                        save.execute(null);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        );
        backgroundReaderThread.setDaemon(true);
        backgroundReaderThread.start();
    }
}