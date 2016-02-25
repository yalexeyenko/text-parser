package text;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private List<SentencePart> sentenceParts = new ArrayList<>();

    public Sentence() {
    }

    public void add(SentencePart sentencePart) {
        sentenceParts.add(sentencePart);
    }

    public void remove(SentencePart sentencePart) {
        sentenceParts.remove(sentencePart);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Sentence{");
        sb.append("sentenceParts size=").append(sentenceParts.size());
        sb.append('}');
        return sb.toString();
    }

    public void toPlainString(StringBuilder sb) {
        for (SentencePart sentencePart : sentenceParts) {
            sentencePart.toPlainString(sb);
        }
    }
}
