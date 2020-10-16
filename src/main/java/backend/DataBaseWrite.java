package backend;

import Model.*;

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
         * @param result
         */
        void onWrite(boolean result);

    }

}
