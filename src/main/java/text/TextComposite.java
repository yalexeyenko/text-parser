package text;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class TextComposite implements Component, Iterable<Component> {

    private final static Logger LOG = LoggerFactory.getLogger(TextComposite.class);

    private List<Component> components;
    private Type type;

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

    public void remove(int index) {
        components.remove(index);
    }

    public void set(int index, Component component) {
        components.set(index, component);
    }

    public int getIndexOf(Component component) {
        return this.components.indexOf(component);
    }

    public int size() {
        return components.size();
    }

    public List<TextComposite> getComposite(Type type) {
        List<TextComposite> compositeList = new ArrayList<>();
        fillCompositeList(compositeList, type);
//        LOG.debug(type.name() + " number: {}", compositeList.size());
        return compositeList;
    }

    private void fillCompositeList(List<TextComposite> compositeList, Type type) {
        for (Component component : this.components) {
            if (component instanceof TextComposite) {
                TextComposite textComposite = (TextComposite) component;
                if (textComposite.getType() == type) {
                    compositeList.add(textComposite);
                } else {
                    textComposite.fillCompositeList(compositeList, type);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "TextComposite{" +
                "type=" + type +
                ", size=" + size() +
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextComposite that = (TextComposite) o;

        if (components != null ? !components.equals(that.components) : that.components != null) return false;
        return type == that.type;

    }

    @Override
    public int hashCode() {
        int result = components != null ? components.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    public static final Comparator<TextComposite> WORDS_NUMBER_COMPARE = (o1, o2) -> Integer.compare(o1.getComposite(Type.WORD).size(), o2.getComposite(Type.WORD).size());

    public enum Type {
        TEXT,
        PARAGRAPH,
        SENTENCE,
        WORD
    }
}
