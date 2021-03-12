package tk.pankajb;

import com.google.gson.Gson;
import tk.pankajb.Responses.ResponseManager;
import tk.pankajb.Responses.SignUpResponse.Response;

import java.io.IOException;

public class SignUpResponseManager implements ResponseManager {

    Response response;
    Connection connection;

    private SignUpResponseManager() {
        // Preventing from creating empty connection object
    }

    private SignUpResponseManager(Connection connection) {
        this.connection = connection;
    }

    public static ResponseManager getResponseManagerOf(Connection connection) {
        return new SignUpResponseManager(connection);
    }

    private Response getResponseFromJSON(String jsonResponse) {

        Gson gson = new Gson();
        return gson.fromJson(jsonResponse, tk.pankajb.Responses.SignUpResponse.Response.class);
    }

    @Override
    public void processResponse() throws IOException {

        String jsonResponse = connection.getResponseInJSON();
        response = getResponseFromJSON(jsonResponse);
        UI.printNewUserDetails(response.getId(), response.getEmail(), response.getRole());
        UI.printSuccessSignUp();
    }
}
