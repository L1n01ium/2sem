public class MainCalculator {
    public static void main(String[] args) {
        Calculator<Integer> x = new Calculator<>();
        Calculator<Double> y = new Calculator<>();
        Fraction f = new Fraction(1, 2);
        Fraction f2 = new Fraction(3,4);
        Calculator<Fraction> z = new Calculator<>();
        System.out.println("//////////////////Для Integer////////////");
        System.out.println("+    " + x.add(100, 50) + "\n" + "-   " + x.subtract(100, 50) + "\n" + "*    " + x.multiply(100,50) + "\n" + "/     " + x.divide(100,50));
        System.out.println("/////////////Для Double////////////");
        System.out.println("+    " + y.add(22.4, 43.4) + "\n" + "-      " + y.subtract(22.4, 43.4) + "\n" + "*     " + y.multiply(22.4, 43.4) + "\n" + "/     " + y.divide(22.4, 43.4));
        System.out.println("/////////////Для Fraction//////////");
        System.out.println("+    " + z.add(f, f2) + "\n" + "-       " + z.subtract(f, f2) + "\n" + "*       " + z.multiply(f, f2) + "\n" + "/     " + z.divide(f, f2));
    }
}
