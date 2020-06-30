package Commands;

import Controller.CommandWithoutArg;

import java.io.IOException;

public class Exit implements CommandWithoutArg {
    @Override
    public Object execute(Object object) throws IOException {
        new Save().execute(null);
        System.out.println("Коллекция сохранена");
        return "Коллекция сохранена";
    }

    @Override
    public String getName() {
        return "exit";
    }


}
