package text;

public class Char implements Component {
    private final char value;
    private CharType type;


    private Char(char value) {
        this.value = value;
        type = getType();
    }

    public char getValue() {
        return value;
    }

    public CharType getType() {
        if (value == '.' ||
            value == '?' ||
            value == '!' ||
            value == ':' ||
            value == ';' ||
            value == ',' ||
            value == '―' ||
            value == '(' ||
            value == ')' ||
            value == '[' ||
            value == ']') {
            type = CharType.PUNCTUATION;
        }
        else if (value == '"' ||
                value == '\'' ||
                value == '-') {
            type = CharType.NONWORD;
        }
        else if (Character.isWhitespace(value)) {
            type = CharType.WHITE_SPACE;
        }
        else if (Character.isLetter(value)) {
            type = CharType.LETTER;
        }
        else if (Character.isDigit(value)) {
            type = CharType.DIGIT;
        }
        return type;
    }

    private static class Cache {
        static Char[] chars = new Char[65536];
    }

    public static Char valueOf(char ch) {
        Char charr = Cache.chars[ch];
        if(charr == null) {
            charr = new Char(ch);
            Cache.chars[ch] = charr;
        }
        return charr;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Char{");
        sb.append("value=").append(value);
        sb.append('}');
        return sb.toString();
    }

    public String toPlainString(StringBuilder sb){
            return sb.append(value).toString();
    }
}
