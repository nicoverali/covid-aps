package backend;

import Model.*;

public class DataBaseWriteSQLite implements DataBaseWrite {

    private static DataBaseWriteSQLite instance;
    private final String DB_STATE_TABLE = "State";
    private SQLDataBase dataBase;

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

    }

    @Override
    public void write(Establishment establishment, OnWriteListener listener) {

    }

    @Override
    public void write(State state, OnWriteListener listener) {

        // NULL indica que el valor del id se autoincremente
        dataBase.executeUpdate("INSERT OR REPLACE INTO " +
                DB_STATE_TABLE +
                " VALUES (NULL," +
                "\"" + state.getName() + "\"" +
                ");");

        listener.onWrite(true);
    }

    @Override
    public void write(SanitaryRegion sanitaryRegion, OnWriteListener listener) {

    }

    @Override
    public void write(Mayor mayor, OnWriteListener listener) {

    }
}
