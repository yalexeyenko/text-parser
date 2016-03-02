package text;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements Component {
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

    public int size() {
        return components.size();
    }

    public List<Component> getComponents() {
        return components;
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

    public enum Type {
        TEXT,
        PARAGRAPH,
        SENTENCE,
        WORD
    }
}
