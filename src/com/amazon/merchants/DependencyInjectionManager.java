package com.amazon.merchants;

import java.util.HashMap;
import java.util.Map;


/**
 * @author Daniel Czerwonk
 *
 */
public class DependencyInjectionManager {

    private static Map map = new HashMap();
    
    
    public static Object getInstance(Class classObject) {
        if (!map.containsKey(classObject)) {
            throw new IllegalArgumentException("No instance to this key");
        }
        
        return map.get(classObject);
    }
    
    public static void registerInstance(Class classObject, Object instance) {
        map.put(classObject, instance);
    }
}
