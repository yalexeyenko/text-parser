package text;

import java.util.ArrayList;
import java.util.List;

public class Word extends SentencePart {
    private List<WordPart> wordParts = new ArrayList<>();

    public Word() {
    }

    public void add(WordPart wordPart) {
        wordParts.add(wordPart);
    }

    public void remove(WordPart wordPart) {
        wordParts.remove(wordPart);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Word{");
        sb.append("wordParts size=").append(wordParts.size());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void toPlainString(StringBuilder sb) {
        for (WordPart wordPart : wordParts) {
            wordPart.toPlainString(sb);
        }
    }
}
