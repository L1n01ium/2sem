public class LaboratoryItem {
    private String serialNumber;
    private int biohazardLevel;
    private Integer sessionID;

    public LaboratoryItem(String serialNumber, int biohazardLevel, Integer sessionID) {
        this.serialNumber = serialNumber;
        this.biohazardLevel = biohazardLevel;
        this.sessionID = sessionID;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getBiohazardLevel() {
        return biohazardLevel;
    }

    public void setBiohazardLevel(int biohazardLevel) {
        this.biohazardLevel = biohazardLevel;
    }

    public Integer getSessionID() {
        return sessionID;
    }

    public void setSessionID(Integer sessionID) {
        this.sessionID = sessionID;
    }
}
