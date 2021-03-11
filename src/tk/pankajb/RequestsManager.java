package tk.pankajb;

import com.google.gson.Gson;
import tk.pankajb.Requests.Request;
import tk.pankajb.Requests.SignInRequest;
import tk.pankajb.Requests.SignUpRequest;
import tk.pankajb.Responses.SignUpResponse.Response;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class RequestsManager {

    static void executeRequest(Request request) {

        try {
            Gson gson = new Gson();

            // Main request connection
            HttpURLConnection connection = (HttpURLConnection) request.getURL().openConnection();
            setupConnection(connection);

            // Putting auth data in connection
            putAuthDataInConnection(connection, request.getAuthJSON());


            if (connection.getResponseCode() != 200) {
                System.err.print("Error code = " + connection.getResponseCode());
                System.err.print("Error Msg = " + connection.getResponseMessage());
            } else {

                String res = getConnectionResponseJSON(connection);

                if (request instanceof SignInRequest) {
                    tk.pankajb.Responses.SignInResponse.Response response = gson.fromJson(res, tk.pankajb.Responses.SignInResponse.Response.class);
                    AccountsManager.setCurrentUser(response.getUser(), response.getAccessToken());
                    UI.successSignIn();

                } else if (request instanceof SignUpRequest) {
                    Response response = gson.fromJson(res, Response.class);
                    UI.printNewUserDetails(response.getId(), response.getEmail(), response.getRole());
                    UI.successSignUp();
                } else {
                    UI.printError("Something went wrong");
                    System.exit(4);
                }
            }

        } catch (IOException e) {

            UI.printError(e.getMessage());
            System.exit(2);
        }

    }

    private static void putAuthDataInConnection(HttpURLConnection connection, String authJSON) throws IOException {
        OutputStream os = connection.getOutputStream();
        byte[] input = authJSON.getBytes(StandardCharsets.UTF_8);
        os.write(input, 0, input.length);
    }

    private static String getConnectionResponseJSON(HttpURLConnection connection) throws IOException {
        StringBuilder res = new StringBuilder();
        Scanner scan = new Scanner(connection.getInputStream());
        while (scan.hasNextLine()) {
            res.append(scan.nextLine());
        }
        return res.toString();
    }

    private static void setupConnection(HttpURLConnection connection) {
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        try {

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setDoOutput(true);

        } catch (ProtocolException e) {
            e.printStackTrace();
        }
    }
}
