package Ticket;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TicketCollection implements Serializable {
    private static HashMap<Long, Ticket> tickets = new HashMap<>();
    private static java.time.ZonedDateTime DateOFCreation;

    public static void setDateOFCreation(ZonedDateTime dateOFCreation) {
        DateOFCreation = dateOFCreation;
    }

    public HashMap<Long, Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(HashMap<Long, Ticket> collection) {
        tickets = collection;
    }

    public void putTicket(Long key, Ticket ticket) {
        ticket.setId(key);
        tickets.put(key, ticket);
    }

    public void replaceMovie(Long key, Ticket ticket) {
        tickets.replace(key, ticket);
    }

    public void removeTicket(Long key) {
        tickets.remove(key);
    }

    public java.util.Set<Long> getKeySet() {
        return tickets.keySet();
    }

    public void getValue(Long key) {
        tickets.get(key);
    }

    public Integer getSize() {
        return tickets.size();
    }

    public void putAllInCollection(TreeMap<Long, Ticket> collection) {
        tickets.putAll(collection);
    }

    public String getInfo() {
        return "Тип коллекции: HashMap\nКоличество элементов коллекции: " + tickets.size()+
                "\nДата создания колекции: " + DateOFCreation.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
    }

    public Ticket getTicket(Long key) {
        return tickets.get(key);
    }

    public boolean isKeyFree(Long ind) {
        try {
            for (Map.Entry<Long, Ticket> entry : tickets.entrySet())
                if (entry.getKey() == ind) return false;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;

        }
    }
}
