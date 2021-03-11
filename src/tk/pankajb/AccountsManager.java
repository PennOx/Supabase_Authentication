package tk.pankajb;

import tk.pankajb.Exceptions.UserNotFoundException;
import tk.pankajb.Requests.AuthBody;
import tk.pankajb.Requests.Request;
import tk.pankajb.Requests.SignInRequest;
import tk.pankajb.Requests.SignUpRequest;
import tk.pankajb.Responses.User;

public class AccountsManager {

    private static User currentUser = null;
    private static String accessToken = null;

    public static boolean isSignedIn() {
        return currentUser != null;
    }

    public static User getCurrentUser() throws UserNotFoundException {
        if (isSignedIn()) {
            return currentUser;
        } else {
            throw new UserNotFoundException();
        }
    }

    public static void setCurrentUser(User currentUser, String accessToken) {
        AccountsManager.currentUser = currentUser;
        AccountsManager.accessToken = accessToken;
    }

    public static String getAccessToken() {
        if (isSignedIn()) {
            return accessToken;
        }
        return null;
    }


    public static void signUpAccount() {
        AuthBody auth = UI.requestCredentials();
        Request request = new SignUpRequest(auth);
        RequestsManager.executeRequest(request);
    }

    public static void signInAccount() {
        AuthBody auth = UI.requestCredentials();
        Request request = new SignInRequest(auth);
        RequestsManager.executeRequest(request);
    }

    public static void signOutAccount() {
        setCurrentUser(null, null);
        UI.successSignOut();
    }

}
