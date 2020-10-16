package Controller;

import Model.Mayor;
import Model.SanitaryRegion;
import Model.State;

public interface IController {
    void onCreateUserEvent(int dni, String email, int tel, String cat, String name, boolean is_valid);
    void onUpdateUserEvent(int dni, String email, int tel, String cat, String name, boolean is_valid);
    void onDeleteUserEvent(int dni);

    void onCreateStateEvent(String name);
    void onUpdateStateEvent(String name);
    void onDeleteStateEvent(int id_state);

    void onCreateDistrictEvent(float surface, String name, int population, int id_district, int zipCode, SanitaryRegion mySanitaryRegion,
                               State myState, Mayor mayor);
    void onUpdateDistrictEvent(float surface, String name, int population, int id_district, int zipCode, SanitaryRegion mySanitaryRegion,
                               State myState, Mayor mayor);
    void onDeleteDistrictEvent(int id_district);

    void onCreateSanitaryRegionEvent(String name, int id);
    void onUpdateSanitaryRegionEvent(String name, int id);
    void onDeleteSanitaryRegionEvent(int id);

    void onCreateEstablishmentEvent(String address, boolean is_valid, String name, int id);
    void onUpdateEstablishmentEvent(String address, boolean is_valid, String name, int id);
    void onDeleteEstablishmentEvent(int id);

}
