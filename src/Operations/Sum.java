package Operations;

public class Sum extends MainOperation {
    public Sum() {
        sign = "+";
    }

    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}
