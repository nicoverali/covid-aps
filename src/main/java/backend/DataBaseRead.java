package backend;

import Model.*;

import java.util.List;

public interface DataBaseRead {

    /**
     * obtiene una lista de User de la base de datos
     *
     * @param bundle   bundle para almacenar datos filtrables
     * @param listener listener de finalizacion
     */
    void getUserList(Bundle bundle, OnUserListReadListener listener);

    /**
     * @param bundle
     * @param listener
     * @return
     */
    void getStateList(Bundle bundle, OnStateListReadListener listener);

    /**
     * @param bundle
     * @param listener
     * @return
     */
    void getDistrictList(Bundle bundle, OnDistrictListReadListener listener);

    /**
     * @param bundle
     * @param listener
     * @return
     */
    void getSanitaryRegionList(Bundle bundle, OnSanitaryRegionListReadListener listener);

    /**
     * @param bundle
     * @param listener
     * @return
     */
    void getMayorList(Bundle bundle, OnMayorListReadListener listener);

    /**
     * @param bundle
     * @param listener
     * @return
     */
    void getEstablishmentList(Bundle bundle, OnEstablishmentListReadListener listener);


    interface OnUserListReadListener {
        void onRead(List<User> userList);
    }

    interface OnStateListReadListener {
        void onRead(List<State> stateList);
    }

    interface OnDistrictListReadListener {
        void onRead(List<District> districtList);
    }

    interface OnSanitaryRegionListReadListener {
        void onRead(List<SanitaryRegion> SanitaryRegionList);
    }

    interface OnMayorListReadListener {
        void onRead(List<Mayor> mayorList);
    }

    interface OnEstablishmentListReadListener {
        void onRead(List<Establishment> establishmentList);
    }

}
