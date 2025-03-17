package Operations;

public class Deduct extends MainOperation {
    public Deduct() {
        sign = "-";
    }

    @Override
    public int Calculate(int a, int b) {
        return a - b;
    }
}
