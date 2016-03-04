package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import parser.Parser;
import text.Component;
import text.TextComposite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TextService {

    private final static Logger LOG = LoggerFactory.getLogger(TextService.class);

    public static String changeFirstAndLastWordInSentences(String text) {
        Parser parser = new Parser();
        TextComposite textComposite = parser.parse(text);
        List<TextComposite> sentences = textComposite.getSentences();
        for (TextComposite sentence : sentences) {
//            LOG.debug("sentence size: " + sentence.size());
            List<Integer> indexesList = new ArrayList<>();
            for (Component component : sentence) {
                if (component instanceof TextComposite) {
                   int index = sentence.getIndexOf(component);
//                    LOG.debug("index number: " + index);
                    indexesList.add(index);
                }
            }
            TextComposite temp = (TextComposite) sentence.getComponent(indexesList.get(0));
            LOG.debug("temp (first): {}", temp.toPlainString(new StringBuilder()));
            TextComposite first = (TextComposite) sentence.getComponent(indexesList.get(indexesList.size() - 1));
            LOG.debug("last: {}", first.toPlainString(new StringBuilder()));
            TextComposite last = temp;
        }
        return textComposite.toPlainString(new StringBuilder()).toString();
    }

    public static void main(String[] args) {
        Parser p = new Parser();

        String textString = "Today, however, they were not playing. Uncle Henry sat upon the doorstep and looked " +
                "anxiously at the sky, which was even grayer than usual. Dorothy stood in the door with Toto " +
                "in her arms, and looked at the sky too. Aunt Em was washing the dishes.\n" +
                "From the far north they heard a low wail of the wind, and Uncle Henry and Dorothy could see " +
                "where the long grass bowed in waves before the coming storm. There now came a sharp whistling " +
                "in the air from the south, and as they turned their eyes that way they saw ripples in the grass " +
                "coming from that direction also.";

        String res = changeFirstAndLastWordInSentences(textString);
        System.out.println(res);
    }
}
