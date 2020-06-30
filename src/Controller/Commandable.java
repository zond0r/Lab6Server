package Controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public interface Commandable extends Serializable {
    public Object execute(Object o) throws FileNotFoundException, IOException;
    public String getName();
}
