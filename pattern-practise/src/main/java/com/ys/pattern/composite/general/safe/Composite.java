package com.ys.pattern.composite.general;

import org.junit.validator.PublicClassValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/4/2 10:00
 * @Version: 1.0
 */
public class Composite extends Component {
    private List<Component> child = new ArrayList<Component>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public String operate() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.name);
        for (int i = 0; i < child.size(); i++) {
            builder.append("\n");
            builder.append(child.get(i).operate());
        }
        return builder.toString();
    }

    public void addChild(Component component) {
        child.add(component);
    }

    public void removeChild(Component component) {
        child.remove(component);
    }

    public Component getChild(int index) {
        return child.get(index);
    }
}
