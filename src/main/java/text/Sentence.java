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

    public List<Word> getWords() {
        ArrayList<Word> wordList = new ArrayList<>();
        for (SentencePart sentencePart : sentenceParts) {
            if (sentencePart instanceof Word) {
                wordList.add((Word) sentencePart);
            }
        }
        return wordList;
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
