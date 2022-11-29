package ipleiria.taes.fastugadriver.preferences;

import android.content.Context;
import android.preference.PreferenceManager;

public class SharedPreferences {
    private static final String LOGGED_EMAIL= "";
    private static final String IS_NEW_LOGIN = "no";

    static android.content.SharedPreferences getSharedPreferences(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    public static void setUserName(Context ctx, String userName)
    {
        android.content.SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(LOGGED_EMAIL, userName);
        editor.commit();
    }

    public static void setIsNewLogin(Context ctx, String checkbox)
    {
        android.content.SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(IS_NEW_LOGIN, checkbox);
        editor.commit();
    }

    public static String getKeepMeSignedInCheckbox(Context ctx)
    {
        return getSharedPreferences(ctx).getString(IS_NEW_LOGIN,"no");
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
