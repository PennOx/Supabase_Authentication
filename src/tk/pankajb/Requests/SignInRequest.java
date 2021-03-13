package tk.pankajb.Requests;

import tk.pankajb.Connection;
import tk.pankajb.DBHandler;
import tk.pankajb.Responses.ResponseManager;
import tk.pankajb.SignInResponseManager;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class SignInRequest extends Request {

    private Connection connection;
    private SignInResponseManager responseManager;

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

    @Override
    public Connection getConnection() throws IOException {
        if (!hasConnection()) {
            connection = Connection.getNewConnectionOf(this);
        }
        return connection;
    }

    @Override
    public ResponseManager getResponseManager() {
        if (!hasResponseManager()) {
            responseManager = SignInResponseManager.getResponseManagerOf(this);
        }

        return responseManager;
    }

    private boolean hasResponseManager() {
        return responseManager != null;
    }

    private boolean hasConnection() {
        return connection != null;
    }

    private String buildSignInURL() {
        return String.format("%s&apikey=%s",
                DBHandler.getSignInLink(), DBHandler.getAnonKey());
    }

}