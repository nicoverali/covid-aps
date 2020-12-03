package backend;

import model.Establishment;
import model.EstablishmentPatients;
import model.EstablishmentResources;
import org.junit.jupiter.api.Test;

public class InstituteEntryTest {

    @Test
    public void newEntryTest() {
        Establishment establishment = new Establishment("Lugar1", "Baker St 221b", -1, true);
        DataBaseWrite write = DataBaseWriteSQLite.getInstance();

        write.write(establishment, result -> {
            DataBaseRead read = DataBaseReadSQLite.getInstance();
            read.getEstablishmentList(null, establishmentList -> {

                Establishment establishmentReal = establishmentList.get(0);
                createResourcesPatients(establishmentReal);
            });

        });

        EstablishmentResources resources = new EstablishmentResources();
    }

    private void createResourcesPatients(Establishment establishmentReal) {
        EstablishmentResources resources = new EstablishmentResources();
        resources.setEstablishmentId(establishmentReal.getId());

        EstablishmentPatients patients = new EstablishmentPatients();
        patients.setEstablishmentId(establishmentReal.getId());

        DataBaseWrite write = DataBaseWriteSQLite.getInstance();
        write.write(resources, result -> {
        });
        write.write(patients, result -> {
        });
    }


}
