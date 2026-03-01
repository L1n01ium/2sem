public class CustomsTerminal {
    public static void inspectCargo(CargoBay<? extends Cargo> list) {
        for (int i = 0; i < list.getCapacity(); i++) {
            Cargo item = list.get(i);
            if (item != null) {
                System.out.println(item.getName());
            }
        }
    }

    public static void loadHumanitarianApples(CargoBay<? super Fruit> list) {
        for (int i = 0; i < 5; i++) {
            list.add(new Fruit("Apple " + i));
        }
    }

    public static <T> void transferCargo(CargoBay<? extends T> list, CargoBay<? super T> dest) {
        for (int i = 0; i < list.getCapacity(); i++) {
            T item = list.get(i);
            if (item != null) {
                dest.add(item);
            }
        }
    }
}
