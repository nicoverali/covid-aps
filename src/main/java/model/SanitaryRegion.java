package model;

import java.util.ArrayList;

public class SanitaryRegion extends Environment {
    private final ArrayList<District> districts;
    private String name;
    private int id;

    public SanitaryRegion(String name, int id) {
        this.name = name;
        this.id = id;
        districts = new ArrayList<>();
    }

    public void addDistrict(District district) {
        districts.add(district);
    }

    public ArrayList<District> getDistricts() {
        return districts;
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
