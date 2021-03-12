package tk.pankajb;

import tk.pankajb.Requests.Request;
import tk.pankajb.Requests.SignInRequest;
import tk.pankajb.Requests.SignUpRequest;
import tk.pankajb.Responses.ResponseManager;

import java.io.IOException;

public class RequestsManager {

    static void executeRequest(Request request) {

        try {
            // Main request connection
            Connection connection = Connection.getNewConnectionOf(request);
            // Putting auth data in connection
            connection.writeAuthData();

            boolean isResponseOK = connection.getResponseCode() == 200;
            if (isResponseOK) {

                if (request instanceof SignInRequest) {
                    ResponseManager responseManager = SignInResponseManager.getResponseManagerOf(connection);
                    responseManager.processResponse();

                } else if (request instanceof SignUpRequest) {
                    ResponseManager responseManager = SignUpResponseManager.getResponseManagerOf(connection);
                    responseManager.processResponse();

                } else {
                    UI.printError("Something went wrong");
                    System.exit(4);
                }

            } else {
                UI.printError(connection);

            }

        } catch (IOException e) {

            UI.printError(e.getMessage());
            System.exit(2);
        }

    }


}
