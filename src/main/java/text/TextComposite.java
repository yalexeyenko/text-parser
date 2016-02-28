package text;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements Component {
    private List<Component> components;
    private CompositeType compositeType;

    public TextComposite(CompositeType compositeType) {
        components = new ArrayList<>();
        this.compositeType = compositeType;
    }

    public void add(Component component) {
        components.add(component);
    }

    public void remove(Component component) {
        components.remove(component);
    }

    public int size() {
        return components.size();
    }

    public CompositeType getCompositeType() {
        return compositeType;
    }



//    public List<Component> getComponents() {
//        ArrayList<Component> componentList = new ArrayList<>();
//        for(Component component : components) {
//            componentList.addAll(component.getComponents());
//        }
//        return componentList;
//    }

    public Component getComponent(int index) {
        return components.get(index);
    }

    public String toPlainString(StringBuilder sb) {
        for (Component component : components) {
            component.toPlainString(sb);
        }
        return sb.toString();
    }

}
