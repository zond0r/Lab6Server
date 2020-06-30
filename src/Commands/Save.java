package Commands;

import Controller.CommandWithoutArg;
import Utility.SaveInFile;

import java.io.IOException;

public class Save implements CommandWithoutArg {
    public static String filename;

    @Override
    public Object execute(Object object) throws IOException {
        SaveInFile saveInFile = new SaveInFile();
        saveInFile.Saving(filename);
        System.out.println("Коллекция успешно сохранена");
        return "Коллекция успешно сохранена";
    }


    @Override
    public String getName() {
        return "save";
    }
}
