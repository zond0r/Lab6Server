package Controller;


import Ticket.Ticket;

public interface CommandWithObject extends Commandable{
    public boolean check(Object arg);
    public Ticket getNewTicket();
}
