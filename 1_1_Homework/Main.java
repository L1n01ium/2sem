public class Main {
    public static void main(String[] args) {

        ItemStorage<Integer> x = new ItemStorage<>(100);
        x.compareWith(100);
        // 100 попадает в кеш Integer, поэтому оба раза используется один объект, сравнение ссылок (==) дает true
        ItemStorage<Integer> y = new ItemStorage<>(200);
        y.compareWith(200);
        // 200 не кешируется, создаются разные объекты, ссылки не равны, поэтому метод compareWith не выводит сообщение (нет else)
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 2);
        ItemStorage<Fraction> z = new ItemStorage<>(f1);
        ItemStorage<Fraction> z2 = new ItemStorage<>(f2);
        z.compareWith(f2);
        // f1 и f2 - разные объекты, поэтому compareWith (использующий ==) не дает вывода.
        System.out.println(f1.equals(f2));
        // метод equals в Fraction переопределен и сравнивает содержимое, поэтому f1.equals(f2) возвращает true
    }
}
