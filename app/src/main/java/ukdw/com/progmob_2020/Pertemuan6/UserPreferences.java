package ukdw.com.progmob_2020.Pertemuan6;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class UserPreferences {
    private static SharedPreferences preferences;

    public static boolean isLogin(Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getBoolean("login", false);
    }

    public static void hasLogin(Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        preferences.edit().putBoolean("login", true).apply();
    }

    public static String getUserId(Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString("userId", "");
    }

    public static void setUserId(Context context, String userId) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        preferences.edit().putString("userId", userId).apply();
    }
}
