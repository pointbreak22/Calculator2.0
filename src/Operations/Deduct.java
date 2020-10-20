package Operations;

public class Deduct extends MainOperation {
    public Deduct() {
        sign = "-";
    }

    @Override
    public int Сalculate(int a, int b) {
        return a - b;
    }
}
