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
    List<User> getUserList(Bundle bundle, OnUserListReadListener listener);

    /**
     * @param bundle
     * @param listener
     * @return
     */
    List<State> getStateList(Bundle bundle, OnStateListReadListener listener);

    /**
     * @param bundle
     * @param listener
     * @return
     */
    List<District> getDistrictList(Bundle bundle, OnDistrictListReadListener listener);

    /**
     * @param bundle
     * @param listener
     * @return
     */
    List<SanitaryRegion> getSanitaryRegionList(Bundle bundle, OnSanitaryRegionListReadListener listener);

    /**
     * @param bundle
     * @param listener
     * @return
     */
    List<Mayor> getMayorList(Bundle bundle, OnMayorListReadListener listener);

    /**
     * @param bundle
     * @param listener
     * @return
     */
    List<Establishment> getEstablishmentList(Bundle bundle, OnEstablishmentListReadListener listener);


    interface OnUserListReadListener {
        void onRead(List<User> userList);
    }

    interface OnStateListReadListener {
        void onRead(List<State> userList);
    }

    interface OnDistrictListReadListener {
        void onRead(List<District> userList);
    }

    interface OnSanitaryRegionListReadListener {
        void onRead(List<SanitaryRegion> userList);
    }

    interface OnMayorListReadListener {
        void onRead(List<Mayor> userList);
    }

    interface OnEstablishmentListReadListener {
        void onRead(List<Establishment> userList);
    }

}
