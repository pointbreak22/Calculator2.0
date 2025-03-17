package Operations;

public abstract class MainOperation {
    protected String sign;

    public String getSign() {
        return sign;
    }

    public abstract int calculate(int a, int b);

}
