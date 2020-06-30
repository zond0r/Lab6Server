package Utility;

import Ticket.Ticket;
import Ticket.TicketCollection;

import java.io.*;
import java.lang.management.ThreadInfo;
import java.util.Iterator;
import java.util.Map;

public class SaveInFile {
    public void Saving(String path) throws IOException {
        try {
            TicketCollection ticketCollection = new TicketCollection();
            Iterator it = ticketCollection.getTickets().entrySet().iterator();
            OutputStream outputStream = new FileOutputStream(new File(path));
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                String ticketInfo = ((Ticket) entry.getValue()).getCsvTicket();
                outputStreamWriter.write(ticketInfo + "\n");
            }
            outputStreamWriter.close();
        }
        catch (NullPointerException | FileNotFoundException e){
        }
        }

}
