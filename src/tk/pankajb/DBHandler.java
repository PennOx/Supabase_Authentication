package tk.pankajb;

public class DBHandler {

    //TODO add anon key
    private static String anonKey = "";
    //TODO add database link
    private static String databaseLink = "";

    public static String getSignUpLink() {
        return databaseLink + "/auth/v1/signup";
    }

    public static String getSignInLink() {
        return databaseLink + "/auth/v1/token?grant_type=password";
    }

    public static String getSignOutLink() {
        return databaseLink + "/auth/v1/logout";
    }

    public static String getAnonKey() {
        return anonKey;
    }

}
