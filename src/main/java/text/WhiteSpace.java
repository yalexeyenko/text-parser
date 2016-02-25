package text;

public class WhiteSpace extends SentencePart {
    private char value;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WhiteSpace{");
        sb.append("value=").append(value);
        sb.append('}');
        return sb.toString();
    }

    public void toPlainString(StringBuilder sb) {
        sb.append(value);
    }
}
