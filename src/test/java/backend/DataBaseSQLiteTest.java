package backend;

import Model.State;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataBaseSQLiteTest {

    @Test
    public void test() {
        DataBaseWrite dbWrite = DataBaseWriteSQLite.getInstance();

        dbWrite.write(new State("RioNegro"), result -> {
            if (result) {
                getWithoutFilter();
                getWithFilter();
            }
        });
    }

    private void getWithoutFilter() {
        DataBaseRead dataBaseRead = DataBaseReadSQLite.getInstance();
        dataBaseRead.getStateList(null, stateList ->
                assertEquals(stateList.get(0).getName(), "RioNegro")
        );
    }

    private void getWithFilter() {
        DataBaseRead dataBaseRead = DataBaseReadSQLite.getInstance();

        Bundle bundle = new Bundle();
        bundle.putString("nombre", "RioNegro");

        dataBaseRead.getStateList(bundle, userList ->
                assertEquals(userList.get(0).getName(), "RioNegro")
        );
    }

}