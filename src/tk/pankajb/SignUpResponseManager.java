package tk.pankajb;

import com.google.gson.Gson;
import tk.pankajb.Requests.SignUpRequest;
import tk.pankajb.Responses.ResponseManager;
import tk.pankajb.Responses.SignUpResponse.Response;

import java.io.IOException;

public class SignUpResponseManager implements ResponseManager {

    Response response;
    SignUpRequest request;

    private SignUpResponseManager() {
        // Preventing from creating empty connection object
    }

    private SignUpResponseManager(SignUpRequest request) {
        this.request = request;
    }

    public static SignUpResponseManager getResponseManagerOf(SignUpRequest request) {
        return new SignUpResponseManager(request);
    }

    @Override
    public void processResponse() throws IOException {

        Connection connection = request.getConnection();
        String jsonResponse = connection.getResponseInJSON();
        response = getResponseFromJSON(jsonResponse);
        UI.printNewUserDetails(response.getId(), response.getEmail(), response.getRole());
        UI.printSuccessSignUp();
    }

    private Response getResponseFromJSON(String jsonResponse) {

        Gson gson = new Gson();
        return gson.fromJson(jsonResponse, tk.pankajb.Responses.SignUpResponse.Response.class);
    }


}
