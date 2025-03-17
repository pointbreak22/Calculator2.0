package Operations;

public class Multiplication extends MainOperation {
    public Multiplication() {
        sign = "*";
    }

    @Override
    public int Calculate(int a, int b) {
        return a * b;
    }
}
