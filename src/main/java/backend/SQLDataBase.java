package backend;

import java.sql.ResultSet;

public interface SQLDataBase {

    /**
     *
     * @param sqlUpdate
     */
    void executeUpdate(String sqlUpdate);

    /**
     *
     * @param sqlQuery
     * @return
     */
    ResultSet executeQuery(String sqlQuery);
}
