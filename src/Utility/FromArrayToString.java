package Utility;

import java.util.ArrayList;

public class FromArrayToString {
    public static String convert(ArrayList<String> arrayList) {
        String s = "";
        for (String value : arrayList)
            s += value;
        return s;
    }
}
