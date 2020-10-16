package backend;

import java.util.HashMap;
import java.util.Map;

public class Bundle {

    private Map<String, String> stringMap;
    private Map<String, Integer> intMap;

    void putString(String key, String value) {
        if (stringMap == null) {
            stringMap = new HashMap<>();
        }
        stringMap.put(key, value);
    }

    void putInt(String key, int value) {
        if (intMap == null) {
            intMap = new HashMap<>();
        }
        intMap.put(key, value);
    }

    String getString(String key, String defaultValue) {
        if (stringMap == null) {
            return defaultValue;
        }
        if (stringMap.containsKey(key)) {
            return stringMap.get(key);
        }
        return defaultValue;
    }

    int getInt(String key, int defaultValue) {
        if (intMap == null) {
            return defaultValue;
        }
        if (intMap.containsKey(key)) {
            return intMap.get(key);
        }
        return defaultValue;
    }


}
