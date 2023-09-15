package composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    List<Component> components = new ArrayList<>();

    public void addComponent(Component component) {
        components.add(component);
    }

    public void removeComponent(Component component) {
        components.remove(component);
    }

    @Override
    public double getPreco() {
        double total = 0;
        for (Component component : components) {
            total += component.getPreco();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Composite [components=" + components + "]";
    }

}
