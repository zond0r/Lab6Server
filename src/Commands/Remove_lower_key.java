package Commands;

import Controller.Commandable;
import Ticket.Ticket;
import Ticket.TicketCollection;

import java.io.IOException;
import java.util.HashMap;

public class Remove_lower_key implements Commandable {
    @Override
    public Object execute(Object o) throws IOException {
        try {
            TicketCollection ticketCollection = new TicketCollection();
            long size = ticketCollection.getSize();
            if (size == 0) {
                return ("Коллекция как бы пустая.");
            } else {
                long givenId = Long.parseLong((String) o);
                HashMap<Long, Ticket> result = new HashMap<Long, Ticket>();
                ticketCollection.getTickets().entrySet().stream()
                        .filter(t -> t.getKey() > givenId)
                        .forEach(entry -> result.put(entry.getKey(), entry.getValue()));
                ticketCollection.setTickets(result);
                if (size == ticketCollection.getSize())
                    return "Коллекция осталась без изменений";
                return ("Все возможные обьекты были удалены.");
            }
        } catch (NumberFormatException | NullPointerException e) {
            return ("Неверный аргумент команды.");
        }
    }


    @Override
    public String getName() {
        return "remove_lower_key";
    }

}
