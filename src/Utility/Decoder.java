package Utility;

import Ticket.*;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.HashMap;

public class Decoder {
    public static HashMap<Long, Ticket> decodeIntoCollection(String data) {
        HashMap<Long, Ticket> collection = new HashMap<Long, Ticket>();
        try {
            String[] lines = data.split("\n");
            for (String line : lines) {
                Ticket ticket = new Ticket();
                String[] params = line.split(",");
                ticket.setId(Long.parseLong(params[0]));
                ticket.setName(params[1]);
                Coordinates coordinates = new Coordinates();
                coordinates.setX(Integer.parseInt(params[2]));
                coordinates.setY(Integer.parseInt(params[3]));
                ticket.setCoordinates(coordinates);
                ticket.setCreationDate(ZonedDateTime.parse(params[4]));
                ticket.setPrice(Double.parseDouble(params[5]));
                ticket.setType(TicketType.valueOf(params[6]));
                Event event = new Event(ticket);
                event.setName(params[7]);
                event.setEventType(EventType.valueOf(params[8]));
                event.setDate(LocalDate.parse(params[9]));
                ticket.setCreationDate(ZonedDateTime.now());
                ticket.setEvent(event);
                collection.put(Long.parseLong(params[0]), ticket);
            }
            System.out.println("Коллекция успешно заполнена.");
        } catch (Exception e) {
            if (FileRead.getFilename().equals(""))
                System.out.println("Изначальный файл не указан.");
            else System.out.println("В указанном файле некорректные данные.");
            System.out.println("Коллекция пустая.");
            return collection;
        }
        return collection;
    }

}

