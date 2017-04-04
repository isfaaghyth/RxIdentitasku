package app.isfaaghyth.identitasku.utils;

/**
 * ---------------------------------
 * Created by isfaaghyth with <3
 * Everything in here: @isfaaghyth
 * ---------------------------------
 */

public class URLs {
    private static String URL_MAIN = "http://isfaaghyth.ga";
    private static String URL_DETAIL = "/detail/";

    public static String getUrlMain() {
        return URL_MAIN;
    }

    public static String getUrlDetail(int id) {
        return URL_MAIN + URL_DETAIL + id;
    }
}
