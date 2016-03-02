package text;

public class Char implements Component {
    private static final String PUNCTUATION_MARKS = ".,?!:;―-()[]{}\"";
    private static final String WORD_MARKS = "'";
    private final char value;
    private Type type;

    private Char(char value) {
        this.value = value;
        type = checkType();
    }

    public Type getType() {
        return type;
    }

    private Type checkType() {
        if (PUNCTUATION_MARKS.indexOf(value) > -1) {
            type = Type.PUNCTUATION;
        }
        else if (WORD_MARKS.indexOf(value) > -1) {
            type = Type.WORDMARK;
        }
        else if (Character.isWhitespace(value)) {
            type = Type.WHITE_SPACE;
        }
        else if (Character.isLetter(value)) {
            type = Type.LETTER;
        }
        else if (Character.isDigit(value)) {
            type = Type.DIGIT;
        }
        return type;
    }

    private static class Cache {
        static Char[] chars = new Char[65536];
    }

    public static Char valueOf(char ch) {
        Char cachedChar = Cache.chars[ch];
        if(cachedChar == null) {
            cachedChar = new Char(ch);
            Cache.chars[ch] = cachedChar;
        }
        return cachedChar;
    }

    public boolean isValidWordChar() {
        return type.equals(Type.LETTER) || type.equals(Type.DIGIT) || type.equals(Type.WORDMARK);
    }

    @Override
    public String toString() {
        return "Char{" +
                "value=" + value +
                ", type=" + type +
                '}';
    }

    public StringBuilder toPlainString(StringBuilder sb){
            return sb.append(value);
    }

    public enum Type {
        PUNCTUATION,
        WORDMARK,
        WHITE_SPACE,
        LETTER,
        DIGIT
    }

}
