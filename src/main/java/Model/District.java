package Model;

import java.util.ArrayList;

public class District extends Environment {
    private float surface;
    private String name;
    private int population;
    private int id_district;
    private int zipCode; // ?

    private SanitaryRegion mySanitaryRegion;
    private State myState;
    private ArrayList<Establishment> myEstablishments;
    private Mayor myMayor;

    public District(float surface, String name, int population, int id_district, int zipCode, SanitaryRegion mySanitaryRegion,
                    State myState, Mayor mayor) {
        this.surface = surface;
        this.name = name;
        this.population = population;
        this.id_district = id_district;
        this.zipCode = zipCode;
        this.mySanitaryRegion = mySanitaryRegion;
        myEstablishments = new ArrayList<>();
        this.myState = myState;
        myMayor = mayor;
    }

    public SanitaryRegion getMySanitaryRegion() {
        return mySanitaryRegion;
    }

    public void setMySanitaryRegion(SanitaryRegion mySanitaryRegion) {
        this.mySanitaryRegion = mySanitaryRegion;
    }

    public State getMyState() {
        return myState;
    }

    public void setMyState(State myState) {
        this.myState = myState;
    }

    public Mayor getMyMayor() {
        return myMayor;
    }

    public void setMyMayor(Mayor myMayor) {
        this.myMayor = myMayor;
    }

    public ArrayList<Establishment> getMyEstablishments() {
        return myEstablishments;
    }

    public void setMyEstablishments(ArrayList<Establishment> myEstablishments) {
        this.myEstablishments = myEstablishments;
    }

    public void addEstablishment(Establishment establishment) {
        myEstablishments.add(establishment);
    }

    public SanitaryRegion getSanitaryRegion() {
        return mySanitaryRegion;
    }

    public void setSanitaryRegion(SanitaryRegion sanitaryRegion) {
        this.mySanitaryRegion = sanitaryRegion;
    }

    public float getSurface() {
        return surface;
    }

    public void setSurface(float surface) {
        this.surface = surface;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getId_district() {
        return id_district;
    }

    public void setId_district(int id_district) {
        this.id_district = id_district;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}
