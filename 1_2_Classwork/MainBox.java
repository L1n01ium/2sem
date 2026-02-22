public class MainBox {
    public static void main(String[] args) {
        Box<Integer> x = new Box<>();
        Box<Double> y = new Box<>();
        System.out.println(x.getClass() == y.getClass());
    }
}
