package parser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import reader.TextReader;
import text.TextComposite;

import static org.junit.Assert.*;

public class ParserTest {
    private String textString;
    private Parser parser;
    private String result;

    @Before
    public void setUp() throws Exception {
        parser = new Parser();
        textString = TextReader.readFileToString("books/cyclone.txt");
    }

    @After
    public void tearDown() throws Exception {
        parser = null;
        result = null;
    }

    @Test
    public void testParseAndToPlainStringIdentity() throws Exception {
        TextComposite textComposite = parser.parse(textString);
        assertEquals(textString, textComposite.toPlainString(new StringBuilder()).toString());
    }


}