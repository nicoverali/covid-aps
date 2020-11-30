package model;

public class Pacients {
    private int totalInfected;
    private int totalSuspicious;
    private int totalRecovered;
    private int totalDeceased;

    public Pacients(int totalInfected, int totalSuspicious, int totalRecovered, int totalDeceased) {
        this.totalInfected = totalInfected;
        this.totalSuspicious = totalSuspicious;
        this.totalRecovered = totalRecovered;
        this.totalDeceased = totalDeceased;
    }

    public void setTotalInfected(int totalInfected) {
        this.totalInfected = totalInfected;
    }

    public void setTotalSuspicious(int totalSuspicious) {
        this.totalSuspicious = totalSuspicious;
    }

    public void setTotalRecovered(int totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    public void setTotalDeceased(int totalDeceased) {
        this.totalDeceased = totalDeceased;
    }

    public int getTotalInfected() {
        return totalInfected;
    }

    public int getTotalSuspicious() {
        return totalSuspicious;
    }

    public int getTotalRecovered() {
        return totalRecovered;
    }

    public int getTotalDeceased() {
        return totalDeceased;
    }
}
