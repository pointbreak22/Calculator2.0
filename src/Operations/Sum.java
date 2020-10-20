package Operations;

public class Sum extends MainOperation {
    public Sum() {
        sign = "+";
    }

    @Override
    public int Сalculate(int a, int b) {
        return a + b;
    }
}
