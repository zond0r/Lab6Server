package Commands;

import App.ServerReceiver;
import App.ServerSender;
import Controller.CommandWithObject;
import Ticket.*;
import Utility.CreateTicket;
import Utility.ScriptException;

import java.util.HashMap;
import java.util.Map;

public class Update implements CommandWithObject {

    @Override
    public Object execute(Object key) {
        boolean keyExist = false;
        try {
            TicketCollection ticketCollection = new TicketCollection();
            HashMap<Long, Ticket> tickets = ticketCollection.getTickets();
            long keyn = Long.parseLong((String) key);
            if (tickets.size() > 0) {
                for (Map.Entry<Long, Ticket> entry : tickets.entrySet()) {
                    if (entry.getKey() == (keyn)) {
                        keyExist = true;
                        break;
                    }
                }
            } else return("Коллекция пуста");
            if (keyExist) {
                ServerSender.send("kek", 1);
                ticketCollection.replaceMovie(Long.parseLong((String) key), getNewTicket());
                return("Элемент с ключом " + key + " обновлён.");
            } else
                return("Элемент с заданным ключом не существует, попробуйте ввести команду снова.");
        }
        catch (NumberFormatException |
                NullPointerException e){
            return("Неверный аргумент команды.");
        }
    }
    @Override
    public String getName(){
        return "update";
    }


    @Override
    public boolean check(Object arg) {
        return false;
    }

    @Override
    public Ticket getNewTicket() {
        CreateTicket createTicket = new CreateTicket();
        if (!CreateTicket.isInScript) return (Ticket) ServerReceiver.receive();
        else return null;
    }
}
