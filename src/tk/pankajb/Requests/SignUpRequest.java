package tk.pankajb.Requests;

import tk.pankajb.DBHandler;

import java.net.MalformedURLException;
import java.net.URL;

public class SignUpRequest extends Request {

    public SignUpRequest(AuthBody auth) {
        super(auth);
    }

    @Override
    public URL getURL() {
        try {

            return new URL(buildSignUpURL());

        } catch (MalformedURLException e) {

            e.printStackTrace();
            System.exit(1);
            return null;

        }
    }

    private String buildSignUpURL() {
        return String.format("%s?apikey=%s",
                DBHandler.getSignUpLink(), DBHandler.getAnonKey());
    }
}
