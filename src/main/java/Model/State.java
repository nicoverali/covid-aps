package Model;

import java.util.ArrayList;

public class State extends Environment {
    private String name;
    private int id_state;
    private ArrayList<District> myDistricts;

    public State(String name) {
        this.name = name;
        myDistricts = new ArrayList<District>();
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

    public int getId_state() {
        return id_state;
    }

    public void setId_state(int id_state) {
        this.id_state = id_state;
    }
}
