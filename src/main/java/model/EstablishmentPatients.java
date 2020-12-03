package model;

public class EstablishmentPatients {

    private int id = -1;
    private int establishmentId;

    public int getEstablishmentId() {
        return establishmentId;
    }

    public void setEstablishmentId(int establishmentId) {
        this.establishmentId = establishmentId;
    }

    private int totalInfected;
    private int totalSuspicious;
    private int totalRecovered;
    private int totalDeceased;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
