package simpleFactoryPattern;

public class OperationFactory {
    public static Operation createOperation(String flag) throws Exception{
        if (flag == "+"){
            return new AddOperation();
        }else if (flag == "-"){
            return new CutOperation();
        }else if (flag == "*"){
            return new MultiOperation();
        }else if (flag == "/"){
            return new DivideOperation();
        }else{
            throw new Exception("输入的算法不存在");
        }
    }
}
