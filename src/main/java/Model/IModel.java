package Model;

public interface IModel {
    void setListener(IModelListener listener);
    void searchWord(String term);

    void createUser(int dni, String email, int tel, String cat, String name, boolean is_valid);
    void updateUser(int dni, String email, int tel, String cat, String name, boolean is_valid);
    void deleteUser(int dni);

    void createState(String name);
    void updateState(String name);
    void deleteState(int id_state);

    void createDistrict(float surface, String name, int population, int id_district, int zipCode, SanitaryRegion mySanitaryRegion,
                               State myState, Mayor mayor);
    void updateDistrict(float surface, String name, int population, int id_district, int zipCode, SanitaryRegion mySanitaryRegion,
                               State myState, Mayor mayor);
    void deleteDistrict(int id_district);

    void createSanitaryRegion(String name, int id);
    void updateSanitaryRegion(String name, int id);
    void deleteSanitaryRegion(int id);

    void createEstablishment(String address, boolean is_valid, String name, int id);
    void updateEstablishment(String address, boolean is_valid, String name, int id);
    void deleteEstablishment(int id);

}
