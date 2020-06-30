package Ticket;

import java.io.Serializable;

public class Coordinates implements Serializable {
    private int x;
    private int y; //Максимальное значение поля:

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}


