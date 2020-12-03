package model;

public class EstablishmentResources {

    private int id = -1;
    private int totalSimpleBedsFree;
    private int totalIntensiveTherapyBedsFree;
    private int totalSimpleBedsUsed;
    private int totalIntensiveTherapyBedsUsed;
    private int totalRespirators;
    private int establishmentId;

    public int getEstablishmentId() {
        return establishmentId;
    }

    public void setEstablishmentId(int establishmentId) {
        this.establishmentId = establishmentId;
    }

    public void setTotalSimpleBedsFree(int totalSimpleBedsFree) {
        this.totalSimpleBedsFree = totalSimpleBedsFree;
    }

    public void setTotalIntensiveTherapyBedsFree(int totalIntensiveTherapyBedsFree) {
        this.totalIntensiveTherapyBedsFree = totalIntensiveTherapyBedsFree;
    }

    public void setTotalSimpleBedsUsed(int totalSimpleBedsUsed) {
        this.totalSimpleBedsUsed = totalSimpleBedsUsed;
    }

    public void setTotalIntensiveTherapyBedsUsed(int totalIntensiveTherapyBedsUsed) {
        this.totalIntensiveTherapyBedsUsed = totalIntensiveTherapyBedsUsed;
    }

    public void setTotalRespirators(int totalRespirators) {
        this.totalRespirators = totalRespirators;
    }

    public int getTotalSimpleBedsFree() {
        return totalSimpleBedsFree;
    }

    public int getTotalIntensiveTherapyBedsFree() {
        return totalIntensiveTherapyBedsFree;
    }

    public int getTotalSimpleBedsUsed() {
        return totalSimpleBedsUsed;
    }

    public int getTotalIntensiveTherapyBedsUsed() {
        return totalIntensiveTherapyBedsUsed;
    }

    public int getTotalRespirators() {
        return totalRespirators;
    }

    //TODO ids deben tener valor por defecto -1
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
