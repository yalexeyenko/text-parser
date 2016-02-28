package parser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import reader.TextReader;
import text.CompositeType;
import text.TextComposite;

import static org.junit.Assert.*;

public class ParserTest {
    Parser parser;
    String textString;
    TextComposite textComposite;
    String result;

    @Before
    public void setUp() throws Exception {
        parser = new Parser();
        textString = TextReader.readFileToString("books/cyclone.txt");
        textComposite = parser.parse(textString, CompositeType.TEXT);
        result = textComposite.toPlainString(new StringBuilder());
    }

    @After
    public void tearDown() throws Exception {
        parser = null;
        textString = null;
        textComposite = null;
        result = null;
    }

    @Test
    public void testParseText() throws Exception {
        assertEquals(textString, result);
    }


}