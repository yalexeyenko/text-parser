package runner;

import parser.Parser;
import reader.TextReader;
import text.TextComposite;

public class Runner {
    public static void main(String[] args) {

        Parser p = new Parser();

        String textString = TextReader.readFileToString("books/cyclone.txt");

        TextComposite text = p.parse(textString, TextComposite.Type.TEXT);
        String result = text.toPlainString(new StringBuilder()).toString();

        System.out.println(textString.equals(result));

    }
}
