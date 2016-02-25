package text;

public class WordChar extends WordPart {
    private final char value;

    private WordChar(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    private static class Cache { // 4 byte 8 byte
        static WordChar[] chars = new WordChar[65536]; //A 65 Z 65+26 a 97
    }

    public static WordChar valueOf(char ch) {
        if (isWordChar(ch) == false) {
            throw new IllegalArgumentException("Illegal argument. A letter is expected");
        }
        WordChar wordChar = Cache.chars[ch];
        if(wordChar == null) {
            wordChar = new WordChar(ch);
            Cache.chars[ch] = wordChar;
        }
        return wordChar;
    }

    private static boolean isWordChar(char ch) {
        return Character.isLetter(ch);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WordChar{");
        sb.append("value=").append(value);
        sb.append('}');
        return sb.toString();
    }

    public void toPlainString(StringBuilder sb) {
        sb.append(value);
    }
}
