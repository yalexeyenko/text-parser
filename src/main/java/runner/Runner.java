package runner;

import parser.Parser;
import reader.TextReader;
import text.CompositeType;
import text.TextComposite;

public class Runner {
    public static void main(String[] args) throws ClassNotFoundException {

        Parser p = new Parser();

        String textString = TextReader.readFileToString("books/cyclone.txt");

        TextComposite text = p.parse(textString, CompositeType.TEXT);
        String result = text.toPlainString(new StringBuilder());

        System.out.println(textString.equals(result));
//        System.out.print(result);






    }
}
