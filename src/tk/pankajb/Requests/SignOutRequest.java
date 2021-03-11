package tk.pankajb.Requests;

import tk.pankajb.AccountsManager;
import tk.pankajb.DBHandler;

import java.net.MalformedURLException;
import java.net.URL;

public class SignOutRequest extends Request {

    public SignOutRequest() {
        super(null);
    }

    @Override
    public URL getURL() {
        try {

            return new URL(buildSignOutURL());

        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.exit(1);
            return null;
        }
    }

    private String buildSignOutURL() {
        return String.format("%s?apikey=%s&Content-Type=application/json&Authorization=%s",
                DBHandler.getSignOutLink(), DBHandler.getAnonKey(), AccountsManager.getAccessToken());
    }
}
