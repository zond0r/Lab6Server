package Commands;

import Controller.Commandable;
import Ticket.Ticket;
import Ticket.TicketCollection;
import Utility.FromArrayToString;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Filter_starts_with_name implements Commandable {
    @Override
    public Object execute(Object o) throws IOException {
        TicketCollection ticketCollection = new TicketCollection();
        String subSt = (String) o;
        ArrayList<String> answer = new ArrayList<>();
        ticketCollection.getTickets().entrySet().stream()
                .filter(t -> t.getValue().getName().indexOf(subSt) == 0)
                .forEach(t -> answer.add(t.getValue().getInfo() + "\n"));
        if (answer.size() == 0) return ("Нет таких элементов в коллекции");
        else return FromArrayToString.convert(answer);
    }


    @Override
    public String getName() {
        return "filter_starts_with_name";
    }
}
