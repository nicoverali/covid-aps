package Model;

public class Establishment {
    private final int id;
    private String name, address;
    private int districtId;
    private boolean is_valid;

    public Establishment(String name, String address, int districtId, boolean is_valid) {
        this(-1, name, address, districtId, is_valid);
    }

    public Establishment(int id, String name, String address, int districtId, boolean is_valid) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.districtId = districtId;
        this.is_valid = is_valid;
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
        return is_valid;
    }

    public void isValid(boolean is_valid) {
        this.is_valid = is_valid;
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
