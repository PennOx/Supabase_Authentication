package tk.pankajb;

import tk.pankajb.Requests.Request;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Connection {

    private HttpURLConnection connection;
    private Request request;

    private Connection() {
        // Preventing from creating empty connection object
    }

    private Connection(Request request) throws IOException {
        this.request = request;
        setupConnection();
    }

    public static Connection getNewConnectionOf(Request request) throws IOException {
        Connection connection = new Connection(request);
        connection.writeAuthData();
        return connection;
    }

    private void setupConnection() throws IOException {
        connection = (HttpURLConnection) request.getURL().openConnection();
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
        connection.setRequestMethod(request.getRequestMethod());
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setDoOutput(true);
    }

    public void writeAuthData() throws IOException {
        OutputStream os = connection.getOutputStream();
        byte[] input = request.getAuthJSON().getBytes(StandardCharsets.UTF_8);
        os.write(input, 0, input.length);
    }

    public String getResponseInJSON() throws IOException {
        StringBuilder res = new StringBuilder();
        Scanner scan = new Scanner(connection.getInputStream());
        while (scan.hasNextLine()) {
            res.append(scan.nextLine());
        }
        return res.toString();
    }

    public int getResponseCode() throws IOException {
        return connection.getResponseCode();
    }

    public String getResponseMessage() throws IOException {
        return connection.getResponseMessage();
    }
}
