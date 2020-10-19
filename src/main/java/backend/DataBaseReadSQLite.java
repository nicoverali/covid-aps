package backend;

import Model.State;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataBaseReadSQLite implements DataBaseRead {

    private static DataBaseReadSQLite instance;

    private final SQLDataBase dataBaseSQLite;

    private DataBaseReadSQLite() {
        dataBaseSQLite = SQLDataBaseLite.getInstance();
    }

    public static DataBaseReadSQLite getInstance() {
        if (instance == null) {
            instance = new DataBaseReadSQLite();
        }
        return instance;
    }

    private String addConditions(Bundle bundle, String sqlQuery) {
        if (bundle != null) {
            StringBuilder sqlBuilder = new StringBuilder(sqlQuery);
            sqlBuilder.append(" WHERE ");

            Iterator<String> iterator = bundle.getStringKeySet().iterator();
            String key;
            String expectedValue;
            while (iterator.hasNext()) {
                key = iterator.next();
                expectedValue = bundle.getString(key, "");

                sqlBuilder
                        .append(key)
                        .append(" = ")
                        .append("\"")
                        .append(expectedValue)
                        .append("\"");

                if (iterator.hasNext()) {
                    sqlBuilder.append(" AND ");
                } else {
                    sqlBuilder.append(";");
                }
            }

            return sqlBuilder.toString();
        }

        return sqlQuery + ";";
    }

    @Override
    public void getUserList(Bundle bundle, OnUserListReadListener listener) {

    }

    @Override
    public void getStateList(Bundle bundle, OnStateListReadListener listener) {
        String sqlQuery = "SELECT * FROM " + SQLDataBaseLite.DB_STATE_TABLE;
        sqlQuery = addConditions(bundle, sqlQuery);

        try {
            ResultSet resultSet = dataBaseSQLite.executeQuery(sqlQuery);
            List<State> stateList = buildStatesFromResultSet(resultSet);
            listener.onRead(stateList);

        } catch (SQLException ignored) {
            listener.onRead(null);
        }
    }

    private List<State> buildStatesFromResultSet(ResultSet resultSet) throws SQLException {
        List<State> stateList = new ArrayList<>();

        String nombre;
        int id;
        State state;
        while (resultSet.next()) {
            nombre = resultSet.getString("nombre");
            id = resultSet.getInt("id");
            state = new State(id, nombre);

            stateList.add(state);
        }
        return stateList;
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
