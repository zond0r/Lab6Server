package Commands;

import Controller.CommandWithoutArg;
import Ticket.Ticket;
import Ticket.TicketCollection;
import Ticket.TicketType;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Print_field_descending_type implements CommandWithoutArg {
    @Override
    public Object execute(Object o) throws FileNotFoundException, IOException {
        TicketCollection ticketCollection = new TicketCollection();
        HashMap<Long, Ticket> tickets = ticketCollection.getTickets();
        ArrayList<TicketType> types = new ArrayList<>();
        if (tickets.size() > 0) {
            for (Map.Entry<Long, Ticket> entry : tickets.entrySet()) {
                Ticket ticket = entry.getValue();
                types.add(ticket.getType());
            }
            Collections.sort(types);
            String message = "Поля type всех элементов в порядке убывания:";
            for (int i = types.size() - 1; i >= 0; i--) {
                message += types.get(i);
            }
            return message;
        } else return ("Коллекция пуста.");
    }

    @Override
    public String getName() {
        return "print_field_descending_type";
    }
}
