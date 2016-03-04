package runner;

import parser.Parser;
import reader.TextReader;
import service.TextService;
import text.TextComposite;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {

        Parser p = new Parser();

        String textString = TextReader.readFileToString("books/cyclone.txt");

        TextComposite text = p.parse(textString, TextComposite.Type.TEXT);
        String result = text.toPlainString(new StringBuilder()).toString();

        System.out.println(textString.equals(result));

        System.out.println(text.getWords().size());
        System.out.println(text.getSentences().size());
        System.out.println(text.getParagraphs().size());

//        for (TextComposite t : text.getParagraphs()) {
//            System.out.print(t.toPlainString(new StringBuilder()).toString());
//        }

//        TextService.changeFirstAndLastWordInSentences(text);
//        System.out.println(text.toPlainString(new StringBuilder()).toString());



    }
}
