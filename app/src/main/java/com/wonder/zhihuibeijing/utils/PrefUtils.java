package com.wonder.zhihuibeijing.utils;

import android.content.Context;

/**
 * Created by 13036 on 2016/6/6.
 */
public class PrefUtils {

    public static boolean getBoolean(Context context, String key, boolean def) {
        return context.getSharedPreferences("config",
                Context.MODE_PRIVATE).getBoolean(key, def);
    }

    public static void setBoolean(Context context, String key, boolean def) {
        context.getSharedPreferences("config", Context.MODE_PRIVATE)
                .edit().putBoolean(key, def).commit();
    }

    public static String getString(Context context, String key, String def) {
        return context.getSharedPreferences("config",
                Context.MODE_PRIVATE).getString(key, def);
    }

    public static void setString(Context context, String key, String def) {
        context.getSharedPreferences("config", Context.MODE_PRIVATE)
                .edit().putString(key, def).commit();
    }
}
