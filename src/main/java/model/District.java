package model;

public class District extends Environment {
    private final int id;
    private String name;
    private int sateId, sanitaryRegionId;
    private int zipCode, population;

    public District(String name, int stateId, int sanitaryRegionId, int zipCode, int population) {
        this(-1, name, stateId, sanitaryRegionId, zipCode, population);
    }

    public District(int id, String name, int stateId, int sanitaryRegionId, int zipCode, int population) {
        this.id = id;
        this.name = name;
        this.sateId = stateId;
        this.sanitaryRegionId = sanitaryRegionId;
        this.zipCode = zipCode;
        this.population = population;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSateId() {
        return sateId;
    }

    public void setSateId(int sateId) {
        this.sateId = sateId;
    }

    public int getSanitaryRegionId() {
        return sanitaryRegionId;
    }

    public void setSanitaryRegionId(int sanitaryRegionId) {
        this.sanitaryRegionId = sanitaryRegionId;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
