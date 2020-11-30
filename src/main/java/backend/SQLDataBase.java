package backend;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface SQLDataBase {

    /**
     * @param sqlUpdate
     */
    void executeUpdate(String sqlUpdate) throws SQLException;

    /**
     * @param sqlQuery
     * @return
     */
    ResultSet executeQuery(String sqlQuery) throws SQLException;
}
