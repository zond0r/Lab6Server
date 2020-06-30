package Commands;

import App.ServerReceiver;
import App.ServerSender;
import Controller.CommandWithObject;
import Ticket.Ticket;
import Ticket.TicketCollection;
import Utility.CreateTicket;
import Utility.ScriptException;

import java.io.IOException;
import java.util.HashMap;

public class Replace_if_lower implements CommandWithObject {

    @Override
    public Object execute(Object object) throws IOException {
        try {
            TicketCollection ticketCollection = new TicketCollection();
            if (ticketCollection.getSize() == 0) {
                return("Коллекция как бы пустая.");
            } else {
                long arg = Long.parseLong((String) object);
                HashMap<Long, Ticket> tickets = ticketCollection.getTickets();
                if (tickets.get(arg) != null) {
                    ServerSender.send("key", 1);
                    Ticket exmp = (Ticket) ServerReceiver.receive();
                    if (exmp.compareTo(tickets.get(arg)) < 0) {
                        tickets.put(arg, exmp);
                        return("Элемент с id " + object + " успешно заменен.");
                    } else return("Заданный элемент оказался больше.");

                } else return("Нет элемента с таким id.");
            }
        } catch (NumberFormatException |
                NullPointerException e) {
            return ("Ключ указан некорректно,попробуйте ещё раз.");
        }

    }

    @Override
    public String getName() {
        return "replace_if_lower";
    }

    @Override
    public boolean check(Object arg) {
        return false;
    }

    @Override
    public Ticket getNewTicket() {
        return null;
    }
}
