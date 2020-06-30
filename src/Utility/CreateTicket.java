package Utility;

import Ticket.*;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CreateTicket {
    private final Scanner scanner = new Scanner(System.in);
    public static boolean isInScript = false;
    public static String[] params;

    public static void setParams(String[] params) {
        CreateTicket.params = params;
    }


    public Ticket createFromScript(long id) throws ScriptException {
        Ticket ticket = new Ticket();
        ticket.setId(id);
        this.setNameForTicket(ticket, params[0]);
        Coordinates coordinates = new Coordinates();
        this.setCoordinateXForCoordinates(coordinates, params[1]);
        this.setCoordinateYForCoordinates(coordinates, params[2]);
        ticket.setCoordinates(coordinates);
        this.setPriceForTicket(ticket, params[3]);
        this.setTicketTypeForTicket(ticket, params[4]);
        Event event = new Event(ticket);
        this.setNameForEvent(event, params[5]);
        this.setDateForEvent(event, params[6]);
        this.setEventTypeForEvent(event, params[7]);
        ticket.setEvent(event);
        ticket.setCreationDate(ZonedDateTime.now());
        return ticket;
    }
    public Ticket createFromScript() throws ScriptException {
        Ticket ticket = new Ticket();
        ticket.setId((long) 0);
        this.setNameForTicket(ticket, params[0]);
        Coordinates coordinates = new Coordinates();
        this.setCoordinateXForCoordinates(coordinates, params[1]);
        this.setCoordinateYForCoordinates(coordinates, params[2]);
        ticket.setCoordinates(coordinates);
        this.setPriceForTicket(ticket, params[3]);
        this.setTicketTypeForTicket(ticket, params[4]);
        Event event = new Event(ticket);
        this.setNameForEvent(event, params[5]);
        this.setDateForEvent(event, params[6]);
        this.setEventTypeForEvent(event, params[7]);
        ticket.setEvent(event);
        ticket.setCreationDate(ZonedDateTime.now());
        return ticket;
    }





    public void setNameForEvent(Event event, String name) throws ScriptException {
        if (name.equals("") || name.equals("null")) {
            throw new ScriptException("nameEvent");
        } else event.setName(name);
    }

    public void setDateForEvent(Event event, String date) throws ScriptException {
        try {
            LocalDate localDate = LocalDate.parse(date);
            event.setDate(localDate);
        } catch (Exception e) {
            System.out.println("Такого времени не может быть");
            throw new ScriptException("date");

        }
    }

    public void setEventTypeForEvent(Event event, String eventType) throws ScriptException {
        try {
            eventType = eventType.toUpperCase();
            if (eventType.equals("") || eventType.equals(null)) {
                throw new ScriptException("eventType");
            } else if (eventType.equals("E_SPORTS") || eventType.equals("FOOTBALL") || eventType.equals("BASKETBALL") || eventType.equals("EXPOSITION"))
                event.setEventType(EventType.valueOf(eventType));
            else throw new ScriptException("eventType");
        } catch (InputMismatchException e) {
            throw new ScriptException("eventType");
        }
    }

    public void setNameForTicket(Ticket ticket, String name) throws ScriptException {
        if (name.equals("") || name.equals("null")) {
            throw new ScriptException("nameTicket");
        } else ticket.setName(name);
    }

    public void setCoordinateXForCoordinates(Coordinates coords, String x) throws ScriptException {
        try {
            int xn = Integer.parseInt(x);
            if (x.equals("") || x.equals(null)) {
                coords.setX(null);
            } else coords.setX(xn);
        } catch (InputMismatchException | NumberFormatException e) {
            e.printStackTrace();
            throw new ScriptException("coordinate x");
        }
    }

    public void setCoordinateYForCoordinates(Coordinates coords, String y) throws ScriptException {
        try {
            Integer yn = Integer.parseInt(y);
            if (y.equals("") || y.equals(null) || yn > 483) {
                throw new ScriptException("coordinate y (значение должно быть больше 483");
            } else {
                coords.setY(yn);
            }

        } catch (InputMismatchException | NumberFormatException e) {
            throw new ScriptException("coordinate y");
        }
    }

    public void setPriceForTicket(Ticket ticket, String price) throws ScriptException {
        try {
            double pricen = Double.parseDouble(price);
            if (price.equals("") || price.equals(null) || pricen < 0) {
                throw new ScriptException("price");
            } else ticket.setPrice(pricen);
        } catch (InputMismatchException | NumberFormatException e) {
            throw new ScriptException("price");
        }
    }

    public void setTicketTypeForTicket(Ticket ticket, String ticketType) throws ScriptException {
        try {
            ticketType= ticketType.toUpperCase();
            if (ticketType.equals("") || ticketType.equals(null)) {
                this.setTicketTypeForTicket(ticket, ticketType);
            } else if (ticketType.equals("VIP") || ticketType.equals("USUAL") || ticketType.equals("BUDGETARY") || ticketType.equals("CHEAP"))
                ticket.setType(TicketType.valueOf(ticketType));
            else throw new ScriptException("ticketType");
        } catch (InputMismatchException e) {
            throw new ScriptException("ticketType");
        }
    }

    public void setNameForEvent(Event event) {
        System.out.println("Введите имя мероприятие.");
        System.out.print("$ ");
        String name = scanner.nextLine();
        if (name.equals("") || name.equals("null")) {
            this.setNameForEvent(event);
        } else event.setName(name);
    }

    public void setDateForEvent(Event event) {
        System.out.println("Введите время мероприятие в представленном формате: yyyy-mm-dd");
        System.out.print("$ ");
        String date = scanner.nextLine();
        try {
            LocalDate localDate = LocalDate.parse(date);
            event.setDate(localDate);
        } catch (Exception e) {
            System.out.println("Такого времени не может быть");
            this.setDateForEvent(event);
        }
    }

    public void setEventTypeForEvent(Event event) {
        try {
            System.out.println("Введите тип мероприятия(E_SPORTS, FOOTBALL, BASKETBALL, EXPOSITION)");
            System.out.print("$ ");
            String eventType = scanner.nextLine().toUpperCase();
            if (eventType.equals("") || eventType.equals(null)) {
                this.setEventTypeForEvent(event);
            } else if (eventType.equals("E_SPORTS") || eventType.equals("FOOTBALL") || eventType.equals("BASKETBALL") || eventType.equals("EXPOSITION"))
                event.setEventType(EventType.valueOf(eventType));
            else this.setEventTypeForEvent(event);
        } catch (InputMismatchException e) {
            this.setEventTypeForEvent(event);
        }
    }
}