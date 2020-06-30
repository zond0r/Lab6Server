package Ticket;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class Ticket implements Comparable, Serializable {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Double price; //Поле не может быть null, Значение поля должно быть больше 0
    private TicketType type; //Поле не может быть null
    private Event event; //Поле не может быть null

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
    public String getCsvTicket(){
        return id+","+name+","+coordinates.getX()+","+ coordinates.getY() + "," + creationDate + "," + price + "," + type + "," +
                event.getName() + "," + event.getEventType()+"," + event.getDate();
    }

    public String getInfo(){
        return "Билет (id:" + id + "):\n\tИмя: " + name + ",\n\tКоординаты:\n\t\tx: " + coordinates.getX() +
                ",\n\t\ty: " + coordinates.getY() +  ",\n\tДата создания: " + creationDate +",\n\tЦена: " + price +
                ",\n\tТип билета: " + type + ",\n\tМероприятие (id:" + event.getId() + "):" + "\n\t\tИмя: " + event.getName() +
                ",\n\t\tДата проведения " + event.getDate() + ",\n\t\tТип: " + event.getEventType() +".";
    }

    @Override
    public int compareTo(Object o) {
        Ticket ticket = (Ticket) o;
        return this.getInfo().length() - ticket.getInfo().length();
    }
}
