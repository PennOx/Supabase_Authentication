package tk.pankajb;

import com.google.gson.Gson;
import tk.pankajb.Requests.SignInRequest;
import tk.pankajb.Responses.ResponseManager;
import tk.pankajb.Responses.SignInResponse.Response;

import java.io.IOException;

public class SignInResponseManager implements ResponseManager {

    Response response;
    SignInRequest request;

    private SignInResponseManager() {
        // Preventing from creating empty object
    }

    private SignInResponseManager(SignInRequest request) {
        this.request = request;
    }

    public static SignInResponseManager getResponseManagerOf(SignInRequest request) {
        return new SignInResponseManager(request);
    }

    @Override
    public void processResponse() throws IOException {

        Connection connection = request.getConnection();
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
