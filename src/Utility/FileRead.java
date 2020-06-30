package Utility;

import java.io.*;
import java.util.Scanner;

public class FileRead {
    private static String filename = "";
    private static final Scanner in = new Scanner(System.in);

    public static String getFilename() {
        return filename;
    }

    public static void setFilename(String filename) {
        FileRead.filename = filename;
    }

    public static String readFromFile(String filePath) throws FileNotFoundException {
        String data = "";
        try {
            InputStream stream = new FileInputStream(filePath);
            Reader reader = new InputStreamReader(stream);
            int ch = reader.read();
            while (ch != -1) {
                data += ((char) ch);
                ch = reader.read();
            }
            return data;
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static String readFromConsole() {
        System.out.print("$ ");
        return in.nextLine();
    }
}


