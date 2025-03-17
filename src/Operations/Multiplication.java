package Operations;

public class Multiplication extends MainOperation {
    public Multiplication() {
        sign = "*";
    }

    @Override
    public int calculate(int a, int b) {
        return a * b;
    }
}
