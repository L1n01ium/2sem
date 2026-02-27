public class MainUniversalCalculator {
    public static void main(String[] args) {
        Fraction f = new Fraction(1, 2);
        Fraction f2 = new Fraction(3,4);
        System.out.println("//////////////////Для Integer////////////");
        System.out.println("+    " + UniversalCalculator.add(100, 50) + "\n" + "-   " + UniversalCalculator.subtract(100, 50) + "\n" + "*    " + UniversalCalculator.multiply(100,50) + "\n" + "/     " + UniversalCalculator.divide(100,50));
        System.out.println("/////////////Для Double////////////");
        System.out.println("+    " + UniversalCalculator.add(22.4, 43.4) + "\n" + "-      " + UniversalCalculator.subtract(22.4, 43.4) + "\n" + "*     " + UniversalCalculator.multiply(22.4, 43.4) + "\n" + "/     " + UniversalCalculator.divide(22.4, 43.4));
        System.out.println("/////////////Для Fraction//////////");
        System.out.println("+    " + UniversalCalculator.add(f, f2) + "\n" + "-       " + UniversalCalculator.subtract(f, f2) + "\n" + "*       " + UniversalCalculator.multiply(f, f2) + "\n" + "/     " + UniversalCalculator.divide(f, f2));
    }
}
