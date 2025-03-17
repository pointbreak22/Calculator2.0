package Operations;

public abstract class MainOperation {
    protected String sign;

    public String getSign() {
        return sign;
    }

    public abstract int Calculate(int a, int b);

}
