package parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import text.Char;
import text.Component;
import text.TextComposite;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Parser {

    private final static Logger LOG = LoggerFactory.getLogger(Parser.class);

    private static Map<TextComposite.Type, TextComposite.Type> components;

    static {
        components = new HashMap<>();
        components.put(TextComposite.Type.TEXT, TextComposite.Type.PARAGRAPH);
        components.put(TextComposite.Type.PARAGRAPH, TextComposite.Type.SENTENCE);
        components.put(TextComposite.Type.SENTENCE, TextComposite.Type.WORD);
    }

    public TextComposite parse(String string) {
        return parse(string, TextComposite.Type.TEXT);
    }

    public TextComposite parse(String string, TextComposite.Type type) {
        TextComposite composite = new TextComposite(type);
        String[] chunks = string.split(getRegex(type));
        TextComposite.Type childType = components.get(type);
        for (String chunk : chunks) {
            if (childType == TextComposite.Type.WORD) {
                TextComposite wComposite = new TextComposite(TextComposite.Type.WORD);
                for (int i = 0; i < chunk.length(); i++) {
                    Char character = Char.valueOf(chunk.charAt(i));
                    if (character.isValidWordChar()) {
                        wComposite.add(character);
                        if (!(Char.valueOf(chunk.charAt(i + 1)).isValidWordChar())) {//!!!
                            composite.add(wComposite);
                        }
                    } else {
                        composite.add(character);
                    }
                }
            } else {
                Component component = parse(chunk, childType);
                composite.add(component);

            }
        }
        LOG.debug(composite.getType().name() + " : " + composite.size());
        return composite;
    }

    private static String getRegex(TextComposite.Type type) {
        InputStream in = Parser.class.getClassLoader().getResourceAsStream("regex.properties");
        Properties regexProperties = new Properties();
        try {
            regexProperties.load(in);
        } catch (IOException e) {
            LOG.error("File was not found");
        }
        return regexProperties.getProperty(type.name().toLowerCase());
    }

}
