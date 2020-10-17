package backend;

import Model.*;

import java.sql.SQLException;

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

    /**
     * @param mayor
     * @param listener
     */
    void write(Mayor mayor, OnWriteListener listener);

    interface OnWriteListener {

        /**
         * @param result true si los cambios fueron hechos
         */
        void onWrite(boolean result);

    }

}
