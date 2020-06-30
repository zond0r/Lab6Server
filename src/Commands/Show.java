package Commands;

import Controller.CommandWithoutArg;
import Ticket.Ticket;
import Ticket.TicketCollection;
import Utility.FromArrayToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Show implements CommandWithoutArg {
    private TicketCollection ticketCollection = new TicketCollection();

    @Override
    public Object execute(Object object) {
        if (ticketCollection.getSize() != 0) {
            ArrayList<String> answer = new ArrayList<>();
            ticketCollection.getTickets().entrySet().stream()
                    .forEach(t -> answer.add("\n" + t.getValue().getInfo() + "\n"));
            return FromArrayToString.convert(answer);
        }
        else return "Коллекция итак пустая";
    }


    @Override
    public String getName() {
        return "show";
    }

}
