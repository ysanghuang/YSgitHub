package simpleFactoryPattern;

public class DivideOperation implements Operation{

    public double excute(double a, double b) throws Exception{
        if (b == 0){
            throw new Exception("除数不能为0");
        } {
            return a / b;
        }
    }
}
