package Commands;

import Controller.CommandWithoutArg;
import Ticket.Ticket;
import Ticket.TicketCollection;
import Utility.FromArrayToString;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Print_ascending implements CommandWithoutArg {

    @Override
    public Object execute(Object o) throws FileNotFoundException, IOException {
        TicketCollection ticketCollection = new TicketCollection();
        ArrayList<String> answer = new ArrayList<>();
        if (ticketCollection.getSize() != 0) {
            ticketCollection.getTickets().entrySet().stream()
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEach(t -> answer.add(t.getValue().getInfo()));
            return FromArrayToString.convert(answer);
        } else return ("Коллекция пуста.");
    }

    @Override
    public String getName() {
        return "print_ascending";
    }
}
