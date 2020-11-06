package backend;

import model.*;

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
        String sqlQuery = "SELECT * FROM " + SQLDataBaseLite.DB_USER_TABLE;
        sqlQuery = addConditions(bundle, sqlQuery);

        try {
            ResultSet resultSet = dataBaseSQLite.executeQuery(sqlQuery);
            List<User> userList = buildUsersFromResultSet(resultSet);
            listener.onRead(userList);

        } catch (SQLException ignored) {
            listener.onRead(null);
        }
    }

    private List<User> buildUsersFromResultSet(ResultSet resultSet) throws SQLException {
        List<User> userList = new ArrayList<>();


        String id, name, email, password, phonenumber, category, roleId;
        boolean is_valid;
        User user;
        while (resultSet.next()) {
            id = resultSet.getString("dni");
            name = resultSet.getString("name");
            email = resultSet.getString("email");
            password = resultSet.getString("password");
            phonenumber = resultSet.getString("phonenumber");
            category = resultSet.getString("category");
            roleId = resultSet.getString("role");
            is_valid = resultSet.getBoolean("is_valid");

            user = new User(id, name, email, password, phonenumber, category, roleId, is_valid);

            userList.add(user);
        }
        return userList;
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
            nombre = resultSet.getString("name");
            id = resultSet.getInt("id");
            state = new State(id, nombre);

            stateList.add(state);
        }
        return stateList;
    }

    @Override
    public void getDistrictList(Bundle bundle, OnDistrictListReadListener listener) {
        String sqlQuery = "SELECT * FROM " + SQLDataBaseLite.DB_DISTRICT_TABLE;
        sqlQuery = addConditions(bundle, sqlQuery);

        try {
            ResultSet resultSet = dataBaseSQLite.executeQuery(sqlQuery);
            List<District> districtList = buildDistrictFromResultSet(resultSet);
            listener.onRead(districtList);

        } catch (SQLException ignored) {
            listener.onRead(null);
        }
    }

    private List<District> buildDistrictFromResultSet(ResultSet resultSet) throws SQLException {
        List<District> districtList = new ArrayList<>();

        int id, stateId, sanitaryRegionId, zipCode, population;
        String name;
        District district;
        while (resultSet.next()) {
            id = resultSet.getInt("id");
            name = resultSet.getString("name");
            stateId = resultSet.getInt("state");
            sanitaryRegionId = resultSet.getInt("sanitary_region");
            zipCode = resultSet.getInt("zip_code");
            population = resultSet.getInt("population");

            district = new District(id, name, stateId, sanitaryRegionId, zipCode, population);

            districtList.add(district);
        }
        return districtList;
    }

    @Override
    public void getSanitaryRegionList(Bundle bundle, OnSanitaryRegionListReadListener listener) {
        String sqlQuery = "SELECT * FROM " + SQLDataBaseLite.DB_SANITARYREGION_TABLE;
        sqlQuery = addConditions(bundle, sqlQuery);

        try {
            ResultSet resultSet = dataBaseSQLite.executeQuery(sqlQuery);
            List<SanitaryRegion> sanitaryRegionsList = buildsanitariesFromResultSet(resultSet);
            listener.onRead(sanitaryRegionsList);

        } catch (SQLException ignored) {
            listener.onRead(null);
        }
    }

    private List<SanitaryRegion> buildsanitariesFromResultSet(ResultSet resultSet) throws SQLException {
        List<SanitaryRegion> sanitaryRegionsList = new ArrayList<>();

        String nombre;
        int id;
        SanitaryRegion sanitaryRegion;
        while (resultSet.next()) {
            nombre = resultSet.getString("name");
            id = resultSet.getInt("id");
            sanitaryRegion = new SanitaryRegion(nombre, id);

            sanitaryRegionsList.add(sanitaryRegion);
        }
        return sanitaryRegionsList;
    }

    @Override
    public void getEstablishmentList(Bundle bundle, OnEstablishmentListReadListener listener) {
        String sqlQuery = "SELECT * FROM " + SQLDataBaseLite.DB_ESTABLISHMENT_TABLE;
        sqlQuery = addConditions(bundle, sqlQuery);

        try {
            ResultSet resultSet = dataBaseSQLite.executeQuery(sqlQuery);
            List<Establishment> establishmentList = buildEstablishmentFromResultSet(resultSet);
            listener.onRead(establishmentList);

        } catch (SQLException ignored) {
            listener.onRead(null);
        }
    }

    private List<Establishment> buildEstablishmentFromResultSet(ResultSet resultSet) throws SQLException {
        List<Establishment> districtList = new ArrayList<>();

        int id, districtId;
        String name, address;
        boolean is_valid;
        Establishment establishment;
        while (resultSet.next()) {
            id = resultSet.getInt("id");
            name = resultSet.getString("name");
            address = resultSet.getString("address");
            districtId = resultSet.getInt("districtId");
            is_valid = resultSet.getBoolean("is_valid");

            establishment = new Establishment(id, name, address, districtId, is_valid);

            districtList.add(establishment);
        }
        return districtList;
    }
}
