package Model;

import java.util.ArrayList;
import java.util.List;

public class SanitaryRegion extends Environment{
    private String name;
    private int id;
    private ArrayList<District> districts ;

    public SanitaryRegion(String name, int id) {
        this.name = name;
        this.id = id;
        districts = new ArrayList<District>();
    }

    public void addDistrict(District district){
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

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
