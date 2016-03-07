package runner;

import reader.TextReader;

import java.util.List;

import static service.TextService.findUniqueWords;
import static service.TextService.swapFirstAndLastWordsInSentences;

public class Runner {
    public static void main(String[] args) {

        String textString = TextReader.readFileToString("books/cyclone.txt");
        System.out.println(textString);

        String result2 = swapFirstAndLastWordsInSentences(textString);
        System.out.println(result2);

        List<String> uniqueWords = findUniqueWords(textString);
        System.out.println(uniqueWords);
    }
}
