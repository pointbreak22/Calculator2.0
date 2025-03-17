package Operations;

public class Division extends MainOperation {
    public Division() {
        sign = "/";
    }

    @Override
    public int calculate(int a, int b) {
        return a / b;
    }
}
