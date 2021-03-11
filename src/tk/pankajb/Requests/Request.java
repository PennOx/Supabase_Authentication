package tk.pankajb.Requests;

import com.google.gson.Gson;

import java.net.URL;

public abstract class Request {

    private AuthBody auth;

    Request(AuthBody auth) {
        this.auth = auth;
    }

    public String getAuthJSON() {
        Gson gson = new Gson();
        return gson.toJson(auth);
    }

    public abstract URL getURL();
}
