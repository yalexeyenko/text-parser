package service;

import parser.Parser;
import text.Component;
import text.TextComposite;

import java.util.ArrayList;
import java.util.List;

public class TextService {

    public static String changeFirstAndLastWordInSentences(String text) {
        Parser parser = new Parser();
        TextComposite textComposite = parser.parse(text);
        List<TextComposite> sentences = textComposite.getSentences();
        for (TextComposite sentence : sentences) {
            List<Integer> indexesList = new ArrayList<>();
            for (Component component : sentence) {
                if (component instanceof TextComposite) {
                   int index = sentence.getIndexOf(component);
                    indexesList.add(index);
                }
            }
            TextComposite temp = (TextComposite) sentence.getComponent(indexesList.get(0));
            sentence.set(indexesList.get(0), sentence.getComponent(indexesList.get(indexesList.size() - 1)));
            sentence.set(indexesList.get(indexesList.size() - 1), temp);
        }
        return textComposite.toPlainString(new StringBuilder()).toString();
    }

}
