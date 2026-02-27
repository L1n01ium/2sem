public class NumberBox<T extends Number> {
    private T[] list;

    public NumberBox(T[] list) {
        this.list = list;
    }

    public T[] getNumbers() {
        return list;
    }

    public void setNumbers(T[] list) {
        this.list = list;
    }

    public static void printSquared(NumberBox<?> list) {
        Number[] numbers = list.getNumbers();
        for (int i = 0; i < numbers.length; i++) {
            double square = UniversalCalculator.multiply(numbers[i], numbers[i]);
            System.out.print(square + ", ");
        }
        System.out.println();
    }

    public static double sum(NumberBox<?> list) {
        Number[] numbers = list.getNumbers();
        double s = 0.0;
        for (int i = 0; i < numbers.length; i++) {
            s = UniversalCalculator.add(s, numbers[i]);
        }
        return s;
    }

    public static void fillWithRandom(NumberBox<Double> list) {
        Double[] numbers = list.getNumbers();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Math.random();
        }
    }

    public static void copy(NumberBox<?> list1, NumberBox<?> list2) {
        Number[] numbers1 = list1.getNumbers();
        Number[] numbers2 = list2.getNumbers();
        for (int i = 0; i < numbers1.length; i++) {
            numbers2[i] = numbers1[i];
        }
    }

    public static NumberBox<Double> addBoxes(NumberBox<? extends Number> list1, NumberBox<? extends Number> list2) {
        Number[] numbers1 = list1.getNumbers();
        Number[] numbers2 = list2.getNumbers();
        if (numbers1.length != numbers2.length) {
            throw new IllegalArgumentException("коробки разного размера");
        }
        Double[] result = new Double[numbers1.length];
        for (int i = 0; i < numbers1.length; i++) {
            result[i] = UniversalCalculator.add(numbers1[i], numbers2[i]);
        }
        return new NumberBox<>(result);
    }

    public void append(NumberBox<? extends T> other) {
        T[] numbers1 = this.list;
        T[] numbers2 = other.getNumbers();
        T[] numbers = (T[]) new Number[numbers1.length + numbers2.length];
        for (int i = 0; i < numbers1.length; i++) {
            numbers[i] = numbers1[i];
        }
        for (int i = 0; i < numbers2.length; i++) {
            numbers[numbers1.length + i] = numbers2[i];
        }
        this.list = numbers;
    }
}
