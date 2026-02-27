public class Main1_2 {
    public static void main(String[] args) {
        System.out.println("===== Сценарий 1 =====");
        ResearchHub<ResearchSample<Double>> sampleHub = new ResearchHub<>();
        // sampleHub.register(new MedicalDevice("SN001", 1, 100, "Microscope", 0.01));
        // Попытка добавить MedicalDevice приводит к ошибке компиляции, потому что параметр типа S ограничен ResearchSample<Double>, а MedicalDevice не является его подтипом
        System.out.println("===== Сценарий 2 =====");
        ResearchHub<LaboratoryItem> hub = new ResearchHub<>();
        ResearchSample<Double> s1 = new ResearchSample<>("SN001", 1, null, "Sample1", 0.8);
        ResearchSample<Integer> s2 = new ResearchSample<>("SN002", 2, null, "Sample2", 90);
        MedicalDevice d1 = new MedicalDevice("SN003", 3, null, "Centrifuge", 0.5);
        hub.register(s1);
        hub.register(s2);
        hub.register(d1);
        System.out.println("Текущее кол-во элементов: " + hub.getCount());
        hub.release(1);
        System.out.println("Отчет");
        LabUtils.generateReport(hub);
        System.out.println();
        System.out.println("===== Сценарий 3 =====");
        ResearchHub<LaboratoryItem> hub3 = new ResearchHub<>();
        ResearchSample<Double> s11 = new ResearchSample<>("SN101", 1, null, "DoubleSample", 0.5);
        ResearchSample<Integer> s22 = new ResearchSample<>("SN102", 2, null, "IntSample", 50);
        ResearchSample<Fraction> s33 = new ResearchSample<>("SN103", 3, null, "FractionSample", new Fraction(1, 2));
        hub3.register(s11);
        hub3.register(s22);
        hub3.register(s33);
        hub3.adjustPurity(10, 0.5);
        double avg = hub3.getAveragePurity();
        System.out.println("Средняя чистота: " + avg);
        System.out.println("Ожидаемое среднее: 13.5");
        // пришлось использовать instanceof и приводить типы, для Integer - округление, а для Fracction - точные вычисления
        System.out.println();
        System.out.println("===== Сценарий 4 =====");
        ResearchHub<LaboratoryItem> hub4 = new ResearchHub<>();
        ResearchSample<Double> item1 = new ResearchSample<>("SN201", 1, 100, "Item1", 0.5);
        ResearchSample<Double> item2 = new ResearchSample<>("SN202", 2, 200, "Item2", 0.6);
        System.out.println("Проверка: " + hub4.checkSession(item1, 100));
        System.out.println("Проверка " + hub4.checkSession(item2, 100));
        ResearchSample<Double> item3 = new ResearchSample<>("SN203", 3, 250, "Item3", 0.7);
        ResearchSample<Double> item4 = new ResearchSample<>("SN204", 4, 250, "Item4", 0.8);
        System.out.println("Проверка: " + hub4.checkSession(item3, 250));
        System.out.println("Проверка: " + hub4.checkSession(item4, 250));
        // Для значений 100 оператор == сравнивает ссылки на один и тот же объект, поэтому true. Для 250 кеширования нет, создаются новые объекты, поэтому false
        System.out.println();
        System.out.println("===== Сценарий 5 =====");
        LaboratoryItem[] items = new LaboratoryItem[5];
        items[0] = new ResearchSample<>("SN301", 2, null, "SampleA", 0.1);
        items[1] = new MedicalDevice("SN302", 9, null, "DeviceX", 0.01);
        items[2] = new ResearchSample<>("SN303", 4, null, "SampleB", 0.2);
        items[3] = new MedicalDevice("SN304", 10, null, "DeviceY", 0.02);
        items[4] = new ResearchSample<>("SN305", 3, null, "SampleC", 0.3);
        LaboratoryItem max = LabUtils.findMaxHazard(items);
        System.out.println("Самый опасный объект: " + max);
        ResearchHub<LaboratoryItem> hub5 = new ResearchHub<>();
        for (int i = 0; i < items.length; i++) {
            hub5.register(items[i]);
        }
        hub.clearByhazardLevel(5);
        System.out.println("После удаления");
        LabUtils.generateReport(hub5);
        ResearchHub<MedicalDevice> hub51 = new ResearchHub<>();
        hub51.register(new MedicalDevice("SN999", 1, null, "DeviceZ", 0.05));
        boolean typesEqual = LabUtils.compareHubTypes(hub5, hub51);
        System.out.println("Типы идентичны? " + typesEqual);
    }
}
