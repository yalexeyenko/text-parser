package parser;

import text.*;
import text2.Char;

import java.util.HashMap;
import java.util.Map;

public class Parser {
    private Map<String, String> regex = new HashMap<>();
    private Map<String, String> components = new HashMap<>();

    public Text parseText(String textString) {
        Text text = new Text();
        String[] paragraphStrings = textString.split("(?<=\\n)");
        for(String paragraphString : paragraphStrings) {
            Paragraph paragraph = parseParagraph(paragraphString);
        }
        return text;
    }

    private Paragraph parseParagraph(String paragraphString) {
        Paragraph paragraph = new Paragraph();
        String[] sentenceStrings = paragraphString.split("(?<=[.!?])(?=\\ [A-Z])");
        for (String sentenceString : sentenceStrings) {
            Sentence sentence = parseSentence(sentenceString);
        }
        return paragraph;
    }

    private Sentence parseSentence(String sentenceString) {
        Sentence sentence = new Sentence();
        String[] wordStrings = sentenceString.split("\\s+");
        for (String wordString : wordStrings) {
            Word word = parseWord(wordString);
        }
        return sentence;
    }

    private Word parseWord(String wordString) {
        Word word = new Word();
        char[] wordChars = wordString.toCharArray();
        for (char wordChar : wordChars) {
            WordChar ch = WordChar.valueOf(wordChar);
            word.add(ch);
        }
        return word;
    }

}
