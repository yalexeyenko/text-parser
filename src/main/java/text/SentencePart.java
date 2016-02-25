package text;

import java.util.List;

public abstract class SentencePart {
    private List<WordChar> wordChars;


    public abstract void toPlainString(StringBuilder sb);
}
