package Operations;

public class Multiplication extends MainOperation {
    public Multiplication() {
        sign = "*";
    }

    @Override
    public int Сalculate(int a, int b) {
        return a * b;
    }
}
