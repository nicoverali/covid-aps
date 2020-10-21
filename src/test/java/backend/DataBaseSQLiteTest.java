package backend;

import Model.SanitaryRegion;
import Model.State;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class DataBaseSQLiteTest {

    @Test
    public void testState() {
        DataBaseWrite dbWrite = DataBaseWriteSQLite.getInstance();

        dbWrite.write(new State("RioNegro"), result -> {
            if (result) {
                getWithoutFilterState();
                getWithFilterState();
            } else {
                fail();
            }
        });
    }

    @Test
    public void testSanitaryInsert() {
        DataBaseWrite dbWrite = DataBaseWriteSQLite.getInstance();

        dbWrite.write(new SanitaryRegion("Zona1", 1), result -> {
            if (result) {
                getWithoutFilterSanitary();
            }
        });
    }

    private void getWithoutFilterSanitary() {
        DataBaseRead dataBaseRead = DataBaseReadSQLite.getInstance();
        dataBaseRead.getStateList(null, userList ->
                assertEquals(userList.get(0).getName(), "Zona1")
        );
    }

    private void getWithoutFilterState() {
        DataBaseRead dataBaseRead = DataBaseReadSQLite.getInstance();
        dataBaseRead.getStateList(null, stateList ->
                assertEquals(stateList.get(0).getName(), "RioNegro")
        );
    }

    private void getWithFilterState() {
        DataBaseRead dataBaseRead = DataBaseReadSQLite.getInstance();

        Bundle bundle = new Bundle();
        bundle.putString("nombre", "RioNegro");

        dataBaseRead.getStateList(bundle, userList ->
                assertEquals(userList.get(0).getName(), "RioNegro")
        );
    }

}