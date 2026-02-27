public class ResearchHub<S extends LaboratoryItem> {
    private S[] storage;
    private int count;

    public ResearchHub() {
        this.storage = (S[]) new LaboratoryItem[2];
        this.count = 0;
    }

    public S[] getStorage() {
        return storage;
    }

    public void setStorage(S[] storage) {
        this.storage = storage;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void register(S item) {
        newSize();
        storage[count++] = item;
    }

    public S release(int index) {
        S removed = storage[index];
        for (int i = index; i < count - 1; i++) {
            storage[i] = storage[i+1];
        }
        storage[--count] = null;
        return removed;
    }

    public S get(int index) {
        if (index < 0 || index >= count) throw new IndexOutOfBoundsException();
        return storage[index];
    }

    public void newSize() {
        if (count == storage.length) {
            int k = storage.length * 2;
            S[] newStorage = (S[]) new LaboratoryItem[k];
            for (int i = 0; i < count; i++) {
                newStorage[i] = storage[i];
            }
            storage = newStorage;
        }
    }

    public int indexOf(S item) {
        for (int i = 0; i < count; i++) {
            if (storage[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public void clearByhazardLevel(int limit) {
        int i = 0;
        while (i < count) {
            if (storage[i].getBiohazardLevel() > limit) {
                release(i);
            } else {
                i++;
            }
        }
    }

    public void adjustPurity(Number offset, Number multiplier) {
        for (int i = 0; i < count; i++) {
            LaboratoryItem item = storage[i];
            if (item instanceof ResearchSample) {
                ResearchSample sample = (ResearchSample) item;
                Number oldPurity = sample.getPurity();
                if (oldPurity instanceof Double) {
                    double result = (oldPurity.doubleValue() + offset.doubleValue()) * multiplier.doubleValue();
                    sample.setPurity(result);
                } else if (oldPurity instanceof Integer) {
                    double result = (oldPurity.doubleValue() + offset.doubleValue()) * multiplier.doubleValue();
                    sample.setPurity((int) Math.round(result));
                }
            }
        }
    }

    public double getAveragePurity() {
        double sum = 0;
        int sampleCount = 0;
        for (int i = 0; i < count; i++) {
            if (storage[i] instanceof ResearchSample) {
                ResearchSample sample = (ResearchSample) storage[i];
                sum += sample.getPurity().doubleValue();
                sampleCount++;
            }
        }
        if (sampleCount == 0) {
            return 0;
        } else {
            return sum / sampleCount;
        }
    }

    public boolean checkSession(S item, Integer sessionId) {
        if (item == null) {
            return false;
        }
        return item.getSessionID() == sessionId;
    }
}