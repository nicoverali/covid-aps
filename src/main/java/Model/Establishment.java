package Model;

public class Establishment {
    private String address;
    private boolean is_valid;
    private String name;
    private int id;

    public Establishment(String address, boolean is_valid, String name, int id) {
        this.address = address;
        this.is_valid = is_valid;
        this.name = name;
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isIs_valid() {
        return is_valid;
    }

    public void setIs_valid(boolean is_valid) {
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

    public void setId(int id) {
        this.id = id;
    }
}
