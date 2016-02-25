package text;

import java.util.ArrayList;
import java.util.List;

public class Text {
    private List<Paragraph> paragraphs = new ArrayList<>();

    public Text() {
    }

    public void add(Paragraph paragraph) {
        paragraphs.add(paragraph);
    }

    public void remove(Paragraph paragraph) {
        paragraphs.remove(paragraph);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Text{");
        sb.append("paragraphs size=").append(paragraphs.size());
        sb.append('}');
        return sb.toString();
    }

    public void toPlainString(StringBuilder sb) {
        for (Paragraph paragraph : paragraphs) {
            paragraph.toPlainString(sb);
        }
    }
}
