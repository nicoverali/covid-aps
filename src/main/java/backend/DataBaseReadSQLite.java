package backend;

import Model.*;

import java.util.List;

public class DataBaseReadSQLite implements DataBaseRead {

    private static DataBaseReadSQLite instance;

    private SQLDataBase dataBaseSQLite;

    private DataBaseReadSQLite() {
        dataBaseSQLite = SQLDataBaseLite.getInstance();
    }

    public static DataBaseReadSQLite getInstance() {
        if (instance == null) {
            instance = new DataBaseReadSQLite();
        }
        return instance;
    }

    @Override
    public List<User> getUserList(Bundle bundle, OnUserListReadListener listener) {
        return null;
    }

    @Override
    public List<State> getStateList(Bundle bundle, OnStateListReadListener listener) {
        return null;
    }

    @Override
    public List<District> getDistrictList(Bundle bundle, OnDistrictListReadListener listener) {
        return null;
    }

    @Override
    public List<SanitaryRegion> getSanitaryRegionList(Bundle bundle, OnSanitaryRegionListReadListener listener) {
        return null;
    }

    @Override
    public List<Mayor> getMayorList(Bundle bundle, OnMayorListReadListener listener) {
        return null;
    }

    @Override
    public List<Establishment> getEstablishmentList(Bundle bundle, OnEstablishmentListReadListener listener) {
        return null;
    }
}
