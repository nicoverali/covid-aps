package Model;

import java.util.ArrayList;

public class State extends Environment {
    private String name;
    private int id;
    private ArrayList<District> myDistricts;

    public State(String name) {
        this(-1, name);
    }

    public State(int id, String name) {
        this.name = name;
        this.id = id;
        myDistricts = new ArrayList<>();
    }

    public ArrayList<District> getMyDistricts() {
        return myDistricts;
    }

    public void setMyDistricts(ArrayList<District> myDistricts) {
        this.myDistricts = myDistricts;
    }

    public void addDistrict(District district) {
        myDistricts.add(district);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //TODO ids deben tener valor por defecto -1
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
