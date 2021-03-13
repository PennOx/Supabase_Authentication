package tk.pankajb;

import tk.pankajb.Requests.Request;
import tk.pankajb.Responses.ResponseManager;

import java.io.IOException;

public class RequestsManager {

    static void executeRequest(Request request) {

        try {
            Connection connection = request.getConnection();

            if (isConnectionResponseOK(connection)) {

                ResponseManager responseManager = request.getResponseManager();
                responseManager.processResponse();

            } else {
                throw new IOException(connection.getResponseMessage());

            }

        } catch (IOException e) {

            UI.printError(e.getMessage());
            System.exit(2);
        }

    }

    private static boolean isConnectionResponseOK(Connection connection) throws IOException {
        return connection.getResponseCode() == 200;
    }


}
