package tk.pankajb.Exceptions;

public class UserNotFoundException extends Exception {

    public String getMessage() {
        return "User not found";
    }
}
