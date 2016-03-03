package text;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CharTest {
    private String punctuationChars = ".,?!:;―—()[]{}\"";
    private String wordMarks = "-'";
    private String letters = "abcdefghijklmnopqrstuvwxysABCDEFGHIJKLMNOPQRSTUVQXYZ" +
                            "абвгдеёжзийклмнопрстуфхцшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦШЩЪЫЬЭЮЯ";
    private String digits = "0123456789";
    private String whitespaces = "\t\n\r\f";

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetType() throws Exception {
        for(char c : punctuationChars.toCharArray()) {
            Char testChar = Char.valueOf(c);
            assertEquals(testChar.getType(), Char.Type.PUNCTUATION);
        }
        for(char c : wordMarks.toCharArray()) {
            Char testChar = Char.valueOf(c);
            assertEquals(testChar.getType(), Char.Type.WORDMARK);
        }
        for(char c : letters.toCharArray()) {
            Char testChar = Char.valueOf(c);
            assertEquals(testChar.getType(), Char.Type.LETTER);
        }
        for(char c : digits.toCharArray()) {
            Char testChar = Char.valueOf(c);
            assertEquals(testChar.getType(), Char.Type.DIGIT);
        }
        for(char c : whitespaces.toCharArray()) {
            Char testChar = Char.valueOf(c);
            assertEquals(testChar.getType(), Char.Type.WHITE_SPACE);
        }
    }
}