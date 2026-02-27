public class MainNumberBox {
    public static void main(String[] args) {
        NumberBox<Integer> intBox = new NumberBox<>(new Integer[]{1, 2, 3});
        NumberBox<Double> doubleBox = new NumberBox<>(new Double[]{4.0, 5.0, 6.0});
        NumberBox.printSquared(intBox);
        System.out.println("Sum = " + NumberBox.sum(intBox));
        NumberBox<Double> randomBox = new NumberBox<>(new Double[5]);
        NumberBox.fillWithRandom(randomBox);
        NumberBox<Number> target = new NumberBox<>(new Number[3]);
        NumberBox.copy(intBox, target);
        NumberBox<Number> numBox = new NumberBox<>(new Number[]{1, 2, 3});
        numBox.append(doubleBox);
    }
}