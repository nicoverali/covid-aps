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
    public void getUserList(Bundle bundle, OnUserListReadListener listener) {

    }

    @Override
    public void getStateList(Bundle bundle, OnStateListReadListener listener) {

    }

    @Override
    public void getDistrictList(Bundle bundle, OnDistrictListReadListener listener) {

    }

    @Override
    public void getSanitaryRegionList(Bundle bundle, OnSanitaryRegionListReadListener listener) {

    }

    @Override
    public void getMayorList(Bundle bundle, OnMayorListReadListener listener) {

    }

    @Override
    public void getEstablishmentList(Bundle bundle, OnEstablishmentListReadListener listener) {

    }
}
