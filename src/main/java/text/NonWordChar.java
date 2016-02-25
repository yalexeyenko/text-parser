package text;

public class NonWordChar extends WordPart {
    private char value;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NonWordChar{");
        sb.append("value=").append(value);
        sb.append('}');
        return sb.toString();
    }

    public void toPlainString(StringBuilder sb) {
        sb.append(value);
    }

}
