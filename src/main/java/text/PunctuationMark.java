package text;

public class PunctuationMark extends SentencePart {
    private char value;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PunctuationMark{");
        sb.append("value=").append(value);
        sb.append('}');
        return sb.toString();
    }

    public void toPlainString(StringBuilder sb) {
        sb.append(value);
    }
}
