package virtual.camera.camera;

import android.content.Context;
import android.content.SharedPreferences;
import virtual.camera.app.app.App;

public class MultiPreferences {
    
    private static final String PREF_NAME = "vcamera_prefs";
    private static MultiPreferences instance;
    private final SharedPreferences preferences;
    
    private MultiPreferences() {
        preferences = App.getContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }
    
    public static synchronized MultiPreferences getInstance() {
        if (instance == null) {
            instance = new MultiPreferences();
        }
        return instance;
    }
    
    public void setInt(String key, int value) {
        preferences.edit().putInt(key, value).apply();
    }
    
    public int getInt(String key, int defaultValue) {
        return preferences.getInt(key, defaultValue);
    }
    
    public void setString(String key, String value) {
        preferences.edit().putString(key, value).apply();
    }
    
    public String getString(String key, String defaultValue) {
        return preferences.getString(key, defaultValue);
    }
    
    public void setBoolean(String key, boolean value) {
        preferences.edit().putBoolean(key, value).apply();
    }
    
    public boolean getBoolean(String key, boolean defaultValue) {
        return preferences.getBoolean(key, defaultValue);
    }
    
    public void remove(String key) {
        preferences.edit().remove(key).apply();
    }
    
    public void clear() {
        preferences.edit().clear().apply();
    }
}
