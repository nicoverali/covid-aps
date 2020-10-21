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
        try {
            String id = user.getId() != -1 ? String.valueOf(user.getId()) : "NULL";

            String sqlUpdate = "INSERT OR REPLACE INTO " +
                    SQLDataBaseLite.DB_USER_TABLE +
                    " VALUES (" +
                    id + "," +
                    "\"" + user.getName() + "\" ," +
                    "\"" + user.getEmail() + "\" ," +
                    "\"" + user.getPassword() + "\" ," +
                    "\"" + user.getPhonenumber() + "\" ," +
                    "\"" + user.getCategory() + "\" ," +
                    "\"" + user.getRoleId() + "\" ," +
                    user.is_valid() +
                    ");";

            dataBase.executeUpdate(sqlUpdate);

            listener.onWrite(true);
        } catch (SQLException throwables) {
            listener.onWrite(false);
        }

    }

    @Override
    public void write(District district, OnWriteListener listener) {
        try {
            String id = district.getId() != -1 ? String.valueOf(district.getId()) : "NULL";

            String sqlUpdate = "INSERT OR REPLACE INTO " +
                    SQLDataBaseLite.DB_DISTRICT_TABLE +
                    " VALUES (" +
                    id + "," +
                    "\"" + district.getName() + "\" ," +
                    district.getSateId() +
                    district.getSanitaryRegionId() +
                    district.getZipCode() +
                    district.getPopulation() +
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
            String id = establishment.getId() != -1 ? String.valueOf(establishment.getId()) : "NULL";

            String sqlUpdate = "INSERT OR REPLACE INTO " +
                    SQLDataBaseLite.DB_ESTABLISHMENT_TABLE +
                    " VALUES (" +
                    id + "," +
                    ", \"" + establishment.getName() + "\" ," +
                    "\"" + establishment.getAddress() + "\" ," +
                    establishment.getDistrictId() +
                    establishment.isValid() +
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
            // NULL indica que el valor del id se autoincremente
            String id = state.getId() != -1 ? String.valueOf(state.getId()) : "NULL";

            String sqlUpdate = "INSERT OR REPLACE INTO " +
                    SQLDataBaseLite.DB_STATE_TABLE +
                    " VALUES (" +
                    id + "," +
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
            String id = sanitaryRegion.getId() != -1 ? String.valueOf(sanitaryRegion.getId()) : "NULL";

            String sqlUpdate = "INSERT OR REPLACE INTO " +
                    SQLDataBaseLite.DB_SANITARYREGION_TABLE +
                    " VALUES (" +
                    id + "," +
                    "\"" + sanitaryRegion.getName() + "\"" +
                    sanitaryRegion.getDistricts() + // TODO no entiendo la relacion district-sanitaryregion
                    ");";

            dataBase.executeUpdate(sqlUpdate);

            listener.onWrite(true);

        } catch (SQLException throwables) {
            listener.onWrite(false);
        }
    }

}
