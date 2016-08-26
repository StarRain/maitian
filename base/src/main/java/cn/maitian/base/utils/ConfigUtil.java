package cn.maitian.base.utils;

import java.util.HashMap;

import cn.maitian.base.BaseApplication;
import cn.maitian.secure_pref_manager.SecurePrefUtils;

/**
 * Created by geng on 2016/8/26.
 */
public class ConfigUtil {

    private static final HashMap<String, String> sStringMap = new HashMap<>();
    private static final HashMap<String, Integer> sIntegerMap = new HashMap<>();
    private static final HashMap<String, Boolean> sBooleanMap = new HashMap<>();

    public static void init(String[] strings, String[] integers, String[] booleans) {
        SecurePrefUtils.initialize(BaseApplication.getBaseApplication());
        for (String name : strings) {
            sStringMap.put(name, SecurePrefUtils.getValue(BaseApplication.getBaseApplication(), name, ""));
        }
        for (String name : integers) {
            sIntegerMap.put(name, SecurePrefUtils.getValue(BaseApplication.getBaseApplication(), name, 0));
        }
        for (String name : booleans) {
            sBooleanMap.put(name, SecurePrefUtils.getValue(BaseApplication.getBaseApplication(), name, false));
        }
    }

    public static void setValue(String name, String value) {
        SecurePrefUtils.setValue(BaseApplication.getBaseApplication(), name, value);
        sStringMap.put(name, value);
    }

    public static void setValue(String name, int value) {
        SecurePrefUtils.setValue(BaseApplication.getBaseApplication(), name, value);
        sIntegerMap.put(name, value);
    }

    public static void setValue(String name, boolean value) {
        SecurePrefUtils.setValue(BaseApplication.getBaseApplication(), name, value);
        sBooleanMap.put(name, value);
    }

    public static String getValue(String name, String defaultValue) {
        return sStringMap.containsKey(name) ? sStringMap.get(name) : defaultValue;
    }

    public static int getValue(String name, int defaultValue) {
        return sIntegerMap.containsKey(name) ? sIntegerMap.get(name) : defaultValue;
    }

    public static boolean getValue(String name, boolean defaultValue) {
        return sBooleanMap.containsKey(name) ? sBooleanMap.get(name) : defaultValue;
    }
}
