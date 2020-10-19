package backend;

import Model.*;

import java.sql.SQLException;

public class DataBaseWriteSQLite implements DataBaseWrite {

    private static DataBaseWriteSQLite instance;

    private final SQLDataBase dataBase;

    private DataBaseWriteSQLite() {
        dataBase = SQLDataBaseLite.getInstance();
    }

    public static DataBaseWriteSQLite getInstance() {
        if (instance == null) {
            instance = new DataBaseWriteSQLite();
        }
        return instance;
    }

    @Override
    public void write(User user, OnWriteListener listener) {

    }

    @Override
    public void write(District district, OnWriteListener listener) {
        try {

            String sqlUpdate = "INSERT OR REPLACE INTO " +
                    SQLDataBaseLite.DB_STATE_TABLE +
                    " VALUES (" +
                    "NULL," + // NULL indica que el valor del id se autoincremente
                    "\"" + district.getSurface() + "\" ," +
                    district.getZipCode() +
                    ", \"" +district.getName() + "\" ," +
                    district.getPopulation()+
                    district.getMyState() +
                    district.getMyMayor().getId() +
                    ");";

            dataBase.executeUpdate(sqlUpdate);

            listener.onWrite(true);
        } catch (SQLException throwables) {
            listener.onWrite(false);
        }

    }

    @Override
    public void write(Establishment establishment, OnWriteListener listener) {
        try {

            String sqlUpdate = "INSERT OR REPLACE INTO " +
                    SQLDataBaseLite.DB_STATE_TABLE +
                    " VALUES (" +
                    "NULL," + // NULL indica que el valor del id se autoincremente
                    "\"" + establishment.getAddress() + "\" ," +
                    establishment.isIs_valid()+
                     ", \"" + establishment.getName() + "\" ," +
                    establishment.getId() +
                    ");";

            dataBase.executeUpdate(sqlUpdate);

            listener.onWrite(true);
        } catch (SQLException throwables) {
            listener.onWrite(false);
        }
    }

    @Override
    public void write(State state, OnWriteListener listener) {
        try {

            String sqlUpdate = "INSERT OR REPLACE INTO " +
                    SQLDataBaseLite.DB_STATE_TABLE +
                    " VALUES (" +
                    "NULL," + // NULL indica que el valor del id se autoincremente
                    "\"" + state.getName() + "\"" +
                    ");";

            dataBase.executeUpdate(sqlUpdate);

            listener.onWrite(true);
        } catch (SQLException throwables) {
            listener.onWrite(false);
        }
    }

    @Override
    public void write(SanitaryRegion sanitaryRegion, OnWriteListener listener) {
        try {

            String sqlUpdate = "INSERT OR REPLACE INTO " +
                    SQLDataBaseLite.DB_STATE_TABLE +
                    " VALUES (" +
                    "NULL," + // NULL indica que el valor del id se autoincremente
                    "\"" + sanitaryRegion.getName() + "\"" +
                    sanitaryRegion.getId() +
                    ");";

            dataBase.executeUpdate(sqlUpdate);

            listener.onWrite(true);
        } catch (SQLException throwables) {
            listener.onWrite(false);
        }
    }

    @Override
    public void write(Mayor mayor, OnWriteListener listener) {
        try {

            String sqlUpdate = "INSERT OR REPLACE INTO " +
                    SQLDataBaseLite.DB_STATE_TABLE +
                    " VALUES (" +
                    "NULL," + // NULL indica que el valor del id se autoincremente
                    "\"" + mayor.getName() + "\"" +
                    ", \"" + mayor.getSurname() + "\""+
                    mayor.getBirthDate() +
                    ");";

            dataBase.executeUpdate(sqlUpdate);

            listener.onWrite(true);
        } catch (SQLException throwables) {
            listener.onWrite(false);
        }
    }
}
