package backend;

import Model.SanitaryRegion;
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

    @Test
    public void testSanitaryInsert(){
        DataBaseWrite dbWrite = DataBaseWriteSQLite.getInstance();

        dbWrite.write(new SanitaryRegion("Zona1",1),result -> {
            if(result){
                getWithoutFilter2();
            }
        });
    }
    private void getWithoutFilter2(){
        DataBaseRead dataBaseRead = DataBaseReadSQLite.getInstance();
        dataBaseRead.getStateList(null, userList ->
                assertEquals(userList.get(0).getName(), "Zona1")
        );
    }

    private void getWithoutFilter() {
        DataBaseRead dataBaseRead = DataBaseReadSQLite.getInstance();
        dataBaseRead.getStateList(null, userList ->
                assertEquals(userList.get(0).getName(), "RioNegro")
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