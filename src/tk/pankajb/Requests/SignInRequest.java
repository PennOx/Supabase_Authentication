package tk.pankajb.Requests;

import tk.pankajb.DBHandler;

import java.net.MalformedURLException;
import java.net.URL;

public class SignInRequest extends Request {

    public SignInRequest(AuthBody auth) {
        super(auth);
    }

    @Override
    public URL getURL() {
        try {

            return new URL(buildSignInURL());

        } catch (MalformedURLException e) {

            e.printStackTrace();
            System.exit(1);
            return null;
        }
    }

    @Override
    public String getRequestMethod() {
        return "POST";
    }

    private String buildSignInURL() {
        return String.format("%s&apikey=%s",
                DBHandler.getSignInLink(), DBHandler.getAnonKey());
    }

}