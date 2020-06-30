package Commands;

import App.ServerReceiver;
import App.ServerSender;
import Controller.CommandWithObject;
import Ticket.Ticket;
import Ticket.TicketCollection;
import Utility.CreateTicket;

import java.util.InputMismatchException;

public class Insert implements CommandWithObject {
    TicketCollection ticketCollection = new TicketCollection();
    long id;

    @Override
    public boolean check(Object arg) {
        return ticketCollection.isKeyFree((Long) arg);
    }

    @Override
    public Ticket getNewTicket() {
        CreateTicket createTicket = new CreateTicket();
        if (!CreateTicket.isInScript) return (Ticket) ServerReceiver.receive();
        else return null;
    }


    @Override
    public Object execute(Object object) {
        try {
            Long id = Long.parseLong((String) object);
            if (check(id)) ServerSender.send("kek", 1);
            if (ticketCollection.isKeyFree((id))) {
                Ticket ticket = getNewTicket();
                ticket.setId(id);
                ticketCollection.putTicket(id, ticket);
                return ("Билет успешно добавлен в коллекцию.");
            } else return ("Указанный ключ занят");
        } catch (NumberFormatException | InputMismatchException e) {
            return ("Аргумент команды должен быть типа \"long\"");
        }
    }

    @Override
    public String getName() {
        return "insert";
    }

}
