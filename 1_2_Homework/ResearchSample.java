public class ResearchSample<T extends Number> extends LaboratoryItem {
    private String materialName;
    private T purity;

    public ResearchSample(String serialNumber, int biohazardLevel, Integer sessionID, String materialName, T purity) {
        super(serialNumber, biohazardLevel, sessionID);
        this.materialName = materialName;
        this.purity = purity;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public T getPurity() {
        return purity;
    }

    public void setPurity(T purity) {
        this.purity = purity;
    }
}
