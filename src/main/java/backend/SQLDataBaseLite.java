package backend;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class SQLDataBaseLite implements SQLDataBase {

    public static final String DB_STATE_TABLE = "State";
    public static final String DB_DISTRICT_TABLE = "District";
    public static final String DB_ESTABLISHMENT_TABLE = "Establishment";
    public static final String DB_MAYOR_TABLE = "Mayor";
    public static final String DB_SANITARYREGION_TABLE = "SanitaryRegion";
    public static final String DB_USER_TABLE = "User";
    public static final String DB_ROLE_TABLE = "Role";
    private static final String DB_RELATIVE_PATH = "database.db";

    private static SQLDataBaseLite instance;
    private Connection c;

    private SQLDataBaseLite() {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:" + DB_RELATIVE_PATH);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static SQLDataBaseLite getInstance() {
        if (instance == null) {
            instance = new SQLDataBaseLite();
        }
        return instance;
    }

    @Override
    public void executeUpdate(String sqlUpdate) throws SQLException {
        Statement statement = c.createStatement();
        statement.executeUpdate(sqlUpdate);
        statement.close();
    }

    @Override
    public ResultSet executeQuery(String sqlQuery) throws SQLException {
        CachedRowSet rowSet;

        Statement statement = c.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        rowSet = createCachedResultSet(resultSet);

        statement.close();

        return rowSet;
    }

    private CachedRowSet createCachedResultSet(ResultSet resultSet) throws SQLException {
        CachedRowSet rowSet;
        RowSetFactory factory = RowSetProvider.newFactory();
        rowSet = factory.createCachedRowSet();
        rowSet.populate(resultSet);
        return rowSet;
    }
}
