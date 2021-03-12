package tk.pankajb;

import com.google.gson.Gson;
import tk.pankajb.Responses.ResponseManager;
import tk.pankajb.Responses.SignInResponse.Response;

import java.io.IOException;

public class SignInResponseManager implements ResponseManager {

    Response response;
    Connection connection;

    private SignInResponseManager() {
        // Preventing from creating empty object
    }

    private SignInResponseManager(Connection connection) {
        this.connection = connection;
    }

    public static ResponseManager getResponseManagerOf(Connection connection) {
        return new SignInResponseManager(connection);
    }

    @Override
    public void processResponse() throws IOException {

        String jsonResponse = connection.getResponseInJSON();
        response = getResponseFromJSON(jsonResponse);
        signInUser();
        UI.printSuccessSignIn();

    }

    private Response getResponseFromJSON(String jsonResponse) {

        Gson gson = new Gson();
        return gson.fromJson(jsonResponse, tk.pankajb.Responses.SignInResponse.Response.class);
    }

    private void signInUser() {
        AccountsManager.signInUserFromToken(response.getUser(), response.getAccessToken());
    }
}
