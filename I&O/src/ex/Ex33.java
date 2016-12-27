package ex;

import java.util.prefs.Preferences;

/**
 * Created by belows on 2016/12/27.
 */
public class Ex33 {
    public static void main(String[] args) {
//        Preferences preferences = Preferences.userNodeForPackage(Ex33.class);
//        preferences.put("name","liukui");
//        preferences.putInt("age",29);
//        preferences.putBoolean("married",false);

        Preferences preferences = Preferences.userNodeForPackage(Ex33.class);
        System.out.println(preferences.get("name",null));
        System.out.println(preferences.getInt("age",0));
        System.out.println(preferences.getBoolean("married",true));
    }
}
