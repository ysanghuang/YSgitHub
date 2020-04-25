package com.ys.pattern.composite.general.safe;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/4/2 10:01
 * @Version: 1.0
 */
public class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    @Override
    public String operate() {
        return this.name;
    }
}
