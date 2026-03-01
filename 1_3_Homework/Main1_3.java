public class Main1_3 {
    public static void main(String[] args) {
// 1. Создаем отсеки
        CargoBay<Phone> phoneBay = new CargoBay<>(10);
        phoneBay.add(new Phone("iPhone 15"));
        phoneBay.add(new Phone("Samsung S24"));
        CargoBay<Electronics> electronicsBay = new CargoBay<>(10);
        CargoBay<Cargo> generalCargoBay = new CargoBay<>(20);
        CargoBay<Food> foodBay = new CargoBay<>(10);
// ==========================================
// ПРОВЕРКА 1: inspectCargo (Producer Extends)
// ==========================================
        CustomsTerminal.inspectCargo(phoneBay);
        CustomsTerminal.inspectCargo(foodBay);
// ==========================================
// ПРОВЕРКА 2: loadHumanitarianApples (Consumer Super)
// ==========================================
        CustomsTerminal.loadHumanitarianApples(foodBay);
        CustomsTerminal.loadHumanitarianApples(generalCargoBay);
// Ошибка: в этом методе (CargoBay<? super Fruit>) не применим к аргументу (Cargo<Electronics>)
// ==========================================
// ПРОВЕРКА 3: transferCargo (PECS в чистом виде)
// ==========================================
        CustomsTerminal.transferCargo(phoneBay, electronicsBay);
        CustomsTerminal.transferCargo(electronicsBay, generalCargoBay);
// Ошибка: невозможно вывести тип T для метода transferCargo - нет общего типа, который одновременно является супертипом food и подтипом electronics
        System.out.println("Если код скомпилировался и вывел это сообщение — вы стали мастером Wildcards и PECS!");
    }
}
