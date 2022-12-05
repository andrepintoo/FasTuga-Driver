package ipleiria.taes.fastugadriver.preferences;

import android.content.Context;
import android.preference.PreferenceManager;

public class SharedPreferences {
    private static final String LOGGED_EMAIL= "";

    static android.content.SharedPreferences getSharedPreferences(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    public static void setUserName(Context ctx, String userName)
    {
        android.content.SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(LOGGED_EMAIL, userName);
        editor.commit();
    }

    public static String getUserEmail(Context ctx)
    {
        return getSharedPreferences(ctx).getString(LOGGED_EMAIL, ""); //either returns LOGGED_USERNAME or empty string
    }

    public static void clearPreferences(Context ctx){
        android.content.SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.clear();
        editor.commit();
    }
}
