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
     * @param user
     * @param listener
     * @throws IllegalArgumentException if the given entity does not have an ID assigned
     */
    void drop(User user, OnDropListener listener) throws IllegalArgumentException;

    /**
     * @param district
     * @param listener
     * @throws IllegalArgumentException if the given entity does not have an ID assigned
     */
    void drop(District district, OnDropListener listener) throws IllegalArgumentException;

    /**
     * @param establishment
     * @param listener
     * @throws IllegalArgumentException if the given entity does not have an ID assigned
     */
    void drop(Establishment establishment, OnDropListener listener) throws IllegalArgumentException;

    /**
     * @param state
     * @param listener
     * @throws IllegalArgumentException if the given entity does not have an ID assigned
     */
    void drop(State state, OnDropListener listener) throws IllegalArgumentException;

    /**
     * @param sanitaryRegion
     * @param listener
     * @throws IllegalArgumentException if the given entity does not have an ID assigned
     */
    void drop(SanitaryRegion sanitaryRegion, OnDropListener listener) throws IllegalArgumentException;


    interface OnDropListener {
        /**
         * @param result true si los cambios fueron hechos
         */
        void onDrop(boolean result);
    }

    interface OnWriteListener {

        /**
         * @param result true si los cambios fueron hechos
         */
        void onWrite(boolean result);

    }

}
