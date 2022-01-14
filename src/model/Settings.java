package model;

public class Settings {

    public static String db_host;
    public static String db_name;
    public static String db_user;
    public static String db_password;

    /*public Settings(String db_host, String db_name, String db_user, String db_password) {
        this.db_host = db_host;
        this.db_name = db_name;
        this.db_user = db_user;
        this.db_password = db_password;
    }*/

    public static String getDb_host() {
        return db_host;
    }

    public static void setDb_host(String db_host) {
        Settings.db_host = db_host;
    }

    public static String getDb_name() {
        return db_name;
    }

    public static void setDb_name(String db_name) {
        Settings.db_name = db_name;
    }

    public static String getDb_user() {
        return db_user;
    }

    public static void setDb_user(String db_user) {
        Settings.db_user = db_user;
    }

    public static String getDb_password() {
        return db_password;
    }

    public static void setDb_password(String db_password) {
        Settings.db_password = db_password;
    }
}
