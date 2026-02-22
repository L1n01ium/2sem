public class Calculator<T extends Number> {

    private T value;

    public Calculator(T value) {
        this.value = value;
    }

    public Calculator() {

    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public double add(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }

    public double subtract(T a, T b) {
        return a.doubleValue() - b.doubleValue();
    }

    public double multiply(T a, T b) {
        return a.doubleValue() * b.doubleValue();
    }

    public double divide(T a, T b) {
        if (b.doubleValue() == 0) {
            throw new IllegalArgumentException("Деление на 0 невохможно");
        } else {
            return a.doubleValue() / b.doubleValue();
        }
    }
}
