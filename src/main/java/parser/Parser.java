package parser;

import text.Char;
import text.Component;
import text.CompositeType;
import text.TextComposite;

import java.util.HashMap;
import java.util.Map;

public class Parser {
    private static Map<CompositeType, String> regexes;
    private static Map<CompositeType, CompositeType> components;

    static {
        regexes  = new HashMap<>();
        regexes.put(CompositeType.TEXT, "(?<=\\n)");
        regexes.put(CompositeType.PARAGRAPH, "(?<=[.!?])(?= [A-Z])");
        regexes.put(CompositeType.SENTENCE, "(?<=\\s+)");
    }

    static {
        components = new HashMap<>();
        components.put(CompositeType.TEXT, CompositeType.PARAGRAPH);
        components.put(CompositeType.PARAGRAPH, CompositeType.SENTENCE);
        components.put(CompositeType.SENTENCE, CompositeType.WORD);
    }

    public TextComposite parse (String string, CompositeType type) throws ClassNotFoundException {
        if (type.equals(CompositeType.WORD)) {
            TextComposite composite = new TextComposite(type);
            for (int i = 0; i < string.length(); i++) {
                char ch = string.charAt(i);
                Char charr = Char.valueOf(ch);
                composite.add(charr);
            }
            return composite;
        }
        String regex = regexes.get(type);
        TextComposite composite = new TextComposite(type);
        String[] chunks = string.split(regex);
        CompositeType childType = components.get(type);
        for (String chunk : chunks) {
            Component component = parse(chunk, childType);
            composite.add(component);
        }
        return composite;
    }
}
