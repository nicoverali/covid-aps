package model;

public class Establishment {
    private final int id;
    private String name, address;
    private int districtId;
    private boolean isValid;
    private EstablishmentPatients patients;
    private EstablishmentResources resources;

    public Establishment(String name, String address, int districtId, boolean isValid) {
        this(-1, name, address, districtId, isValid);
    }

    public Establishment(int id, String name, String address, int districtId, boolean isValid) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.districtId = districtId;
        this.isValid = isValid;
    }

    public EstablishmentPatients getPatients() {
        return patients;
    }

    public void setPatients(EstablishmentPatients patients) {
        this.patients = patients;
    }

    public EstablishmentResources getResources() {
        return resources;
    }

    public void setResources(EstablishmentResources resources) {
        this.resources = resources;
    }


    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isValid() {
        return isValid;
    }

    public void isValid(boolean is_valid) {
        this.isValid = is_valid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
}
