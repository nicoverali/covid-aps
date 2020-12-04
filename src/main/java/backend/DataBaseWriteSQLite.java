package backend;

import model.*;

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
            String sqlUpdate = "INSERT OR REPLACE INTO " +
                    SQLDataBaseLite.DB_USER_TABLE +
                    " VALUES (" +
                    user.getId() + "," +
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
            String id;
            if (establishment.getId() == -1) {
                id = "NULL";
            } else {
                id = String.valueOf(establishment.getId());
            }

            String sqlUpdate = "INSERT OR REPLACE INTO " +
                    SQLDataBaseLite.DB_ESTABLISHMENT_TABLE +
                    " VALUES (" +
                    id  +
                    ", \"" + establishment.getName() + "\" ," +
                    "\"" + establishment.getAddress() + "\" ," +
                    establishment.getDistrictId() + ", " +
                    establishment.isValid() +
                    ");";

            dataBase.executeUpdate(sqlUpdate);

            listener.onWrite(true);
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
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

    @Override
    public void write(EstablishmentResources establishmentResources, OnWriteListener listener) {
        try {
            String id = establishmentResources.getId() != -1 ? String.valueOf(establishmentResources.getId()) : "NULL";

            String sqlUpdate = "INSERT OR REPLACE INTO " +
                    SQLDataBaseLite.DB_ESTABLISHMENT_RESOURCES_TABLE +
                    " VALUES (" +
                    id + "," +
                    "\"" + establishmentResources.getEstablishmentId() + "\"" +
                    "\"" + establishmentResources.getTotalSimpleBedsUsed() + "\"" +
                    "\"" + establishmentResources.getTotalIntensiveTherapyBedsUsed() + "\"" +
                    "\"" + establishmentResources.getTotalRespirators() + "\"" +
                    ");";

            dataBase.executeUpdate(sqlUpdate);

            listener.onWrite(true);
        } catch (SQLException throwables) {
            listener.onWrite(false);
        }
    }

    @Override
    public void write(EstablishmentPatients resources, OnWriteListener listener) {
        try {
            // NULL indica que el valor del id se autoincremente
            String id = resources.getId() != -1 ? String.valueOf(resources.getId()) : "NULL";

            String sqlUpdate = "INSERT OR REPLACE INTO " +
                    SQLDataBaseLite.DB_ESTABLISHMENT_PATIENTS_TABLE +
                    " VALUES (" +
                    id + "," +
                    "\"" + resources.getEstablishmentId() + "\"" +
                    "\"" + resources.getTotalInfected() + "\"" +
                    "\"" + resources.getTotalSuspicious() + "\"" +
                    "\"" + resources.getTotalRecovered() + "\"" +
                    "\"" + resources.getTotalDeceased() + "\"" +
                    ");";

            dataBase.executeUpdate(sqlUpdate);

            listener.onWrite(true);
        } catch (SQLException throwables) {
            listener.onWrite(false);
        }
    }

    @Override
    public void drop(User user, OnDropListener listener) throws IllegalArgumentException {
        try {
            String sqlDrop = "DELETE FROM " +
                    SQLDataBaseLite.DB_USER_TABLE +
                    "WHERE id = " + user.getId();

            dataBase.executeUpdate(sqlDrop);
            listener.onDrop(true);
        } catch (SQLException throwables) {
            listener.onDrop(false);
        }

    }

    @Override
    public void drop(District district, OnDropListener listener) throws IllegalArgumentException {
        try {
            if (district.getId() == -1)
                throw new IllegalArgumentException("The entity must have an ID assigned to drop it from database");

            String sqlDrop = "DELETE FROM " +
                    SQLDataBaseLite.DB_DISTRICT_TABLE +
                    "WHERE id = " + district.getId();

            dataBase.executeUpdate(sqlDrop);
            listener.onDrop(true);
        } catch (SQLException throwables) {
            listener.onDrop(false);
        }
    }

    @Override
    public void drop(Establishment establishment, OnDropListener listener) throws IllegalArgumentException {
        try {
            if (establishment.getId() == -1)
                throw new IllegalArgumentException("The entity must have an ID assigned to drop it from database");

            String sqlDrop = "DELETE FROM " +
                    SQLDataBaseLite.DB_ESTABLISHMENT_TABLE +
                    "WHERE id = " + establishment.getId();

            dataBase.executeUpdate(sqlDrop);
            listener.onDrop(true);
        } catch (SQLException throwables) {
            listener.onDrop(false);
        }
    }

    @Override
    public void drop(State state, OnDropListener listener) throws IllegalArgumentException {
        try {
            if (state.getId() == -1)
                throw new IllegalArgumentException("The entity must have an ID assigned to drop it from database");

            String sqlDrop = "DELETE FROM " +
                    SQLDataBaseLite.DB_STATE_TABLE +
                    "WHERE id = " + state.getId();

            dataBase.executeUpdate(sqlDrop);
            listener.onDrop(true);
        } catch (SQLException throwables) {
            listener.onDrop(false);
        }
    }

    @Override
    public void drop(SanitaryRegion sanitaryRegion, OnDropListener listener) throws IllegalArgumentException {
        try {
            if (sanitaryRegion.getId() == -1)
                throw new IllegalArgumentException("The entity must have an ID assigned to drop it from database");

            String sqlDrop = "DELETE FROM " +
                    SQLDataBaseLite.DB_SANITARYREGION_TABLE +
                    "WHERE id = " + sanitaryRegion.getId();

            dataBase.executeUpdate(sqlDrop);
            listener.onDrop(true);
        } catch (SQLException throwables) {
            listener.onDrop(false);
        }
    }

}
