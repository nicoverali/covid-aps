package backend;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Bundle {

    private Map<String, String> stringMap;
    private Map<String, Integer> intMap;

    public void putString(String key, String value) {
        if (stringMap == null) {
            stringMap = new HashMap<>();
        }
        stringMap.put(key, value);
    }

    public void putInt(String key, int value) {
        if (intMap == null) {
            intMap = new HashMap<>();
        }
        intMap.put(key, value);
    }

    public String getString(String key, String defaultValue) {
        if (stringMap == null) {
            return defaultValue;
        }
        if (stringMap.containsKey(key)) {
            return stringMap.get(key);
        }
        return defaultValue;
    }

    public int getInt(String key, int defaultValue) {
        if (intMap == null) {
            return defaultValue;
        }
        if (intMap.containsKey(key)) {
            return intMap.get(key);
        }
        return defaultValue;
    }

    public Set<String> getStringKeySet() {
        return stringMap.keySet();
    }

    public Set<String> getIntKeySet() {
        return intMap.keySet();
    }


}
