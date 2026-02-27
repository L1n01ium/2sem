public class LabUtils {

    public static <T extends LaboratoryItem> T findMaxHazard(T[] items) {
        if (items == null || items.length == 0) return null;
        T max = items[0];
        for (int i = 1; i < items.length; i++) {
            if (items[i] != null && items[i].getBiohazardLevel() > max.getBiohazardLevel()) {
                max = items[i];
            }
        }
        return max;
    }

    public static <T> void shuffle(T[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1)); // случайный индекс от 0 до i
            T temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public static <T extends LaboratoryItem, U extends LaboratoryItem> boolean compareHubTypes(ResearchHub<T> hub1, ResearchHub<U> hub2) {
        if (hub1.getCount() == 0 || hub2.getCount() == 0) {
            return false;
        }
        return hub1.get(0).getClass().equals(hub2.get(0).getClass());
    }

    public static <T extends LaboratoryItem> void generateReport(ResearchHub<T> hub) {
        for (int i = 0; i < hub.getCount(); i++) {
            LaboratoryItem item = hub.get(i);
            String className = item.getClass().getSimpleName();
            Integer id = item.getSessionID();
            String name = "";
            if (item instanceof ResearchSample) {
                name = ((ResearchSample) item).getMaterialName();
            } else if (item instanceof MedicalDevice) {
                name = ((MedicalDevice) item).getDeviceName();
            }
            System.out.printf("[%s] ID: %s | Имя: %s%n", className, id == null ? "null" : id, name);
        }
    }
}