package reader;

import java.io.InputStream;
import java.util.Scanner;

public class TextReader {

    public static String readFileToString(String fileName) {
        InputStream in = TextReader.class.getClassLoader().getResourceAsStream(fileName);
        return new Scanner(in).useDelimiter("\\A").next();
    }

}
