package backend;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class SQLDataBaseLite implements SQLDataBase {

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
    public void executeUpdate(String sqlUpdate) {
        try {

            Statement statement = c.createStatement();
            statement.executeUpdate(sqlUpdate);
            statement.close();

        } catch (SQLException e) {
            //TODO manage exception
            e.printStackTrace();
        }
    }

    @Override
    public ResultSet executeQuery(String sqlQuery) {
        CachedRowSet rowSet = null;

        try {

            Statement statement = c.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            rowSet = createCachedResultSet(resultSet);
            statement.close();

        } catch (SQLException e) {
            //TODO manage exception
            e.printStackTrace();
        }
        return rowSet;
    }

    private CachedRowSet createCachedResultSet(ResultSet resultSet) throws SQLException {
        CachedRowSet rowset;
        RowSetFactory factory = RowSetProvider.newFactory();
        rowset = factory.createCachedRowSet();
        rowset.populate(resultSet);
        return rowset;
    }
}
