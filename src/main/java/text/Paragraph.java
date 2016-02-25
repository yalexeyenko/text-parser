package text;

import java.util.ArrayList;
import java.util.List;

public class Paragraph {
    private List<Sentence> sentences = new ArrayList<>();

    public Paragraph() {
    }

    public void add(Sentence sentence) {
        sentences.add(sentence);
    }

    public void remove(Sentence sentence) {
        sentences.remove(sentence);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Paragraph{");
        sb.append("sentences size=").append(sentences.size());
        sb.append('}');
        return sb.toString();
    }

    public void toPlainString(StringBuilder sb) {
        for (Sentence sentence : sentences) {
            sentence.toPlainString(sb);
        }
    }
}
