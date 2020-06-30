package Commands;

import Controller.CommandWithoutArg;
import Ticket.TicketCollection;

public class Clear implements CommandWithoutArg {
    TicketCollection ticketCollection = new TicketCollection();
    @Override
    public Object execute(Object object) {
        if (ticketCollection.getTickets().size()>0){
            ticketCollection.getTickets().clear();

            ticketCollection.setDateOFCreation(null);
            return("Коллекция очищена.");
        }
        return("Коллекция уже пуста.");
    }

    @Override
    public String getName() {
        return "clear";
    }


}
