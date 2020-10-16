package Model;

import java.util.Date;

public class Mayor {
    private String name;
    private String surname;
    private Date birthDate;
    private District myDistrict;

    public Mayor(String name, String surname, Date birthDate, District district) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        myDistrict = district;
    }

    public District getMyDistrict() {
        return myDistrict;
    }

    public void setMyDistrict(District myDistrict) {
        this.myDistrict = myDistrict;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
