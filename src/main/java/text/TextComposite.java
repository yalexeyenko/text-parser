package text;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TextComposite implements Component, Iterable<Component> {

    private final static Logger LOG = LoggerFactory.getLogger(TextComposite.class);

    private List<Component> components;
    private Type type;
    private int size;

    public TextComposite(Type type) {
        components = new ArrayList<>();
        this.type = type;
    }

    public Component getComponent(int index) {
        return components.get(index);
    }

    public Type getType() {
        return type;
    }

    public void add(Component component) {
        components.add(component);
    }

    public int getIndexOf(Component component) {
        return this.components.indexOf(component);
    }

    public int size() {
        return components.size();
    }

    public List<Component> getComponents() {
        return components;
    }

    public List<TextComposite> getParagraphs() {
        List<TextComposite> paragraphsList = new ArrayList<>();
        fillParagraphsList(paragraphsList);
        LOG.debug("Paragraphs number: " + paragraphsList.size());
        return paragraphsList;
    }

    private void fillParagraphsList(List<TextComposite> paragraphsList) {
        for (Component component : this.components) {
            if (component instanceof TextComposite) {
                TextComposite textComposite = (TextComposite) component;
                if (textComposite.getType() == Type.PARAGRAPH) {
                    paragraphsList.add(textComposite);
                } else {
                    textComposite.fillParagraphsList(paragraphsList);
                }
            }
        }
    }

    public List<TextComposite> getSentences() {
        List<TextComposite> sentencesList = new ArrayList<>();
        fillSentencesList(sentencesList);
        LOG.debug("Sentences number: " + sentencesList.size());
        return sentencesList;
    }

    private void fillSentencesList(List<TextComposite> sentencesList) {
        for (Component component : this.components) {
            if (component instanceof TextComposite) {
                TextComposite textComposite = (TextComposite) component;
                if (textComposite.getType() == Type.SENTENCE) {
                    sentencesList.add(textComposite);
                } else {
                    textComposite.fillSentencesList(sentencesList);
                }
            }
        }
    }

    public List<TextComposite> getWords() {
        List<TextComposite> wordsList = new ArrayList<>();
        fillWordsList(wordsList);
        LOG.debug("Words number: " + wordsList.size());
        return wordsList;
    }

    private void fillWordsList(List<TextComposite> wordsList) {
        for (Component component : this.components) {
            if (component instanceof TextComposite) {
                TextComposite textComposite = (TextComposite) component;
                if (textComposite.getType() == Type.WORD) {
                    wordsList.add(textComposite);
                } else {
                    textComposite.fillWordsList(wordsList);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "TextComposite{" +
                "type=" + type +
                ", size=" + size +
                '}';
    }

    public StringBuilder toPlainString(StringBuilder sb) {
        for (Component component : components) {
            component.toPlainString(sb);
        }
        return sb;
    }

    @Override
    public Iterator<Component> iterator() {
        return components.iterator();
    }

    public enum Type {
        TEXT,
        PARAGRAPH,
        SENTENCE,
        WORD
    }
}
