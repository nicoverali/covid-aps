package backend;

import Model.State;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataBaseWriteSQLiteTest {

    @Test
    public void test() {
        DataBaseWrite dbWrite = DataBaseWriteSQLite.getInstance();

        dbWrite.write(new State("RioNegro"), result -> validate());
    }

    private void validate() {
        SQLDataBase sqlDataBase = SQLDataBaseLite.getInstance();
        ResultSet resultSet = sqlDataBase.executeQuery("select * from State;");
        try {
            while (resultSet.next()) {
                assertEquals(resultSet.getString("nombre"), "RioNegro");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        sqlDataBase.executeUpdate("delete from State;");
    }

}