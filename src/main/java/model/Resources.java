package model;

public class Resources {

    private int totalSimpleBedsFree;
    private int totalIntensiveTherapyBedsFree;
    private int totalSimpleBedsUsed;
    private int totalIntensiveTherapyBedsUsed;
    private int totalRespirators;

    public Resources(int totalSimpleBedsFree, int totalIntensiveTherapyBedsFree, int totalSimpleBedsUsed, int totalIntensiveTherapyBedsUsed, int totalRespirators) {
        this.totalSimpleBedsFree = totalSimpleBedsFree;
        this.totalIntensiveTherapyBedsFree = totalIntensiveTherapyBedsFree;
        this.totalSimpleBedsUsed = totalSimpleBedsUsed;
        this.totalIntensiveTherapyBedsUsed = totalIntensiveTherapyBedsUsed;
        this.totalRespirators = totalRespirators;
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
}
