package tk.pankajb.Requests;

import tk.pankajb.Connection;
import tk.pankajb.DBHandler;
import tk.pankajb.Responses.ResponseManager;
import tk.pankajb.SignUpResponseManager;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class SignUpRequest extends Request {

    private Connection connection;
    private SignUpResponseManager responseManager;

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
            responseManager = SignUpResponseManager.getResponseManagerOf(this);
        }

        return responseManager;
    }

    private boolean hasResponseManager() {
        return responseManager != null;
    }

    private boolean hasConnection() {
        return connection != null;
    }

    private String buildSignUpURL() {
        return String.format("%s?apikey=%s",
                DBHandler.getSignUpLink(), DBHandler.getAnonKey());
    }
}
