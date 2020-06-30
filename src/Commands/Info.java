package Commands;


import Controller.CommandWithoutArg;
import Ticket.TicketCollection;

public class Info implements CommandWithoutArg {

    @Override
    public Object execute(Object object){
        TicketCollection ticketCollection = new TicketCollection();
        return(ticketCollection.getInfo());
    }


    @Override
    public String getName() {
        return "info";
    }
}
