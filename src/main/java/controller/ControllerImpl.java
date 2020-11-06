package controller;

import model.IModel;
import model.SanitaryRegion;
import model.State;
import view.IView;

public class ControllerImpl implements IController {
    private final IView view;
    private final IModel model;

    public ControllerImpl(IModel model, IView view) {
        this.view = view;
        this.model = model;
    }

    public void onCreateUserEvent(int dni, String email, int tel, String cat, String name, boolean is_valid) {
        model.createUser(dni, email, tel, cat, name, is_valid);
    }

    public void onUpdateUserEvent(int dni, String email, int tel, String cat, String name, boolean is_valid) {
        model.updateUser(dni, email, tel, cat, name, is_valid);
    }

    public void onDeleteUserEvent(int dni) {
        model.deleteUser(dni);
    }

    public void onCreateStateEvent(String name) {
        model.createState(name);
    }

    public void onUpdateStateEvent(String name) {
        model.updateState(name);
    }

    public void onDeleteStateEvent(int id_state) {
        model.deleteState(id_state);
    }

    public void onCreateDistrictEvent(float surface, String name, int population, int id_district, int zipCode, SanitaryRegion mySanitaryRegion, State myState) {
        model.createDistrict(surface, name, population, id_district, zipCode, mySanitaryRegion, myState);
    }

    public void onUpdateDistrictEvent(float surface, String name, int population, int id_district, int zipCode, SanitaryRegion mySanitaryRegion, State myState) {
        model.updateDistrict(surface, name, population, id_district, zipCode, mySanitaryRegion, myState);
    }

    public void onDeleteDistrictEvent(int id_district) {
        model.deleteDistrict(id_district);
    }

    public void onCreateSanitaryRegionEvent(String name, int id) {
        model.createSanitaryRegion(name, id);
    }

    public void onUpdateSanitaryRegionEvent(String name, int id) {
        model.updateSanitaryRegion(name, id);
    }

    public void onDeleteSanitaryRegionEvent(int id) {
        model.deleteSanitaryRegion(id);
    }

    public void onCreateEstablishmentEvent(String address, boolean is_valid, String name, int id) {
        model.createEstablishment(address, is_valid, name, id);
    }

    public void onUpdateEstablishmentEvent(String address, boolean is_valid, String name, int id) {
        model.updateEstablishment(address, is_valid, name, id);
    }

    public void onDeleteEstablishmentEvent(int id) {
        model.deleteEstablishment(id);
    }


}
