package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import parser.Parser;
import text.Component;
import text.TextComposite;

import java.util.ArrayList;
import java.util.List;

public class TextService {

    private final static Logger LOG = LoggerFactory.getLogger(TextService.class);

    /**Swaps first and last words in every sentence of String text.
     * @param text the source text
     * @return     the modified text
     */
    public static String swapFirstAndLastWordsInSentences(String text) {
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

    /**
     * Searches for unique words in first sentence of String text, which does not appear in other sentences
     * @param text          the source text
     * @return uniqueWords  the list with unique words found
     */
    public static List<String> findUniqueWords(String text) {
        Parser parser = new Parser();
        TextComposite textComposite = parser.parse(text);
        List<TextComposite> sentences = textComposite.getSentences(); // get all sentences of text
        TextComposite firstSentence = sentences.get(0);
        List<TextComposite> uniqueWords = firstSentence.getWords(); // list for unique words
        LOG.debug("First sentence size: {}", firstSentence.size());
        List<TextComposite> subSentences = sentences.subList(1, sentences.size());
        LOG.debug("Other sentences number: {}", subSentences.size());
        for (TextComposite word : firstSentence.getWords()) {
            for (TextComposite sentence : subSentences) {
                for (TextComposite wordSource : sentence.getWords()) {
                    if ((word.toPlainString(new StringBuilder()).toString()).equalsIgnoreCase(
                            (wordSource.toPlainString(new StringBuilder()).toString())
                    )) {
                        uniqueWords.remove(word);
                    }
                }
            }
        }
        List<String> uniqueWordsList = new ArrayList<>();
        for (TextComposite uniqueWord : uniqueWords) {
            uniqueWordsList.add(uniqueWord.toPlainString(new StringBuilder()).toString());
        }
        return uniqueWordsList;
    }
    /**
     * Sorts sentences in a String text by words number
     * @param text          the source text
     * @return sortedText   the list of sorted sentences
     */
    public static List<String> sortTextByWordsCountInSentences(String text) {
        Parser parser = new Parser();
        TextComposite textComposite = parser.parse(text);
        List<String> sortedText = new ArrayList<>();
        List<TextComposite> sentences = textComposite.getSentences();
        sentences.sort(TextComposite.WORDS_NUMBER_COMPARE);
        for (TextComposite sentence : sentences) {
            sortedText.add((sentence.toPlainString(new StringBuilder()).toString()).trim());
        }
        return sortedText;
    }



}
