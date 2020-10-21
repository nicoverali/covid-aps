package backend;

import Model.*;

//TODO por ahi faltan los metodos para hcer drop...
public interface DataBaseWrite {

    /**
     * @param user
     * @param listener
     */
    void write(User user, OnWriteListener listener);

    /**
     * @param district
     * @param listener
     */
    void write(District district, OnWriteListener listener);

    /**
     * @param establishment
     * @param listener
     */
    void write(Establishment establishment, OnWriteListener listener);

    /**
     * @param state
     * @param listener
     */
    void write(State state, OnWriteListener listener);

    /**
     * @param sanitaryRegion
     * @param listener
     */
    void write(SanitaryRegion sanitaryRegion, OnWriteListener listener);

    interface OnWriteListener {

        /**
         * @param result true si los cambios fueron hechos
         */
        void onWrite(boolean result);

    }

}
