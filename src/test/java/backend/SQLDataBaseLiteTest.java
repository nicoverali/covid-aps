package backend;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SQLDataBaseLiteTest {

    @Test
    public void test() throws SQLException {
        SQLDataBase sqlDataBase = SQLDataBaseLite.getInstance();

        sqlDataBase.executeUpdate("INSERT OR REPLACE INTO State VALUES (1, \"Chubut\")");

        ResultSet resultSet = sqlDataBase.executeQuery("SELECT * FROM Rol");
        while (resultSet.next()) {
            String nombre = resultSet.getString("tipo");
            assertEquals(nombre, "admin");
        }
    }

}