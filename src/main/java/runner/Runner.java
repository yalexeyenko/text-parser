package runner;

import reader.TextReader;
import service.TextService;

public class Runner {
    public static void main(String[] args) {

        String textString = TextReader.readFileToString("books/cyclone.txt");
        System.out.println(textString);

        String result2 = TextService.changeFirstAndLastWordInSentences(textString);
        System.out.println(result2);

    }
}
