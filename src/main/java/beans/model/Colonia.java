package beans.model;

public class Colonia {
    private int coloniaId;
    private String nameColonia;
    private int postalCode;

    public Colonia() {
    }
    public Colonia(int coloniaId, String nameColonia, int postalCode) {
        this.coloniaId = coloniaId;
        this.nameColonia = nameColonia;
        this.postalCode = postalCode;
    }

    public int getColoniaId() {
        return coloniaId;
    }
    public void setColoniaId(int coloniaId) {
        this.coloniaId = coloniaId;
    }

    public String getNameColonia() {
        return nameColonia;
    }
    public void setNameColonia(String nameColonia) {
        this.nameColonia = nameColonia;
    }

    public int getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
    
    
}
