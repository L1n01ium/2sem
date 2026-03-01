public class CargoBay<T> {
    private T[] items;

    public CargoBay(int size) {
        items = (T[]) new Object[size];
    }

    public CargoBay(T[] items) {
        this.items = items;
    }

    public CargoBay() {
    }

    public int getCapacity() {
        return items.length;
    }

    public T[] getItems() {
        return items;
    }

    public void setItems(T[] items) {
        this.items = items;
    }

    public void add(T item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                return;
            }
        }
        throw new RuntimeException("CargoBay is full");
    }

    public T get(int index) {
        return items[index];
    }

    public T[] getAll() {
        return items;
    }

    public int getSize() {
        int res = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                res++;
            }
        }
        return res;
    }
}
