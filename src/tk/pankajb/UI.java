package tk.pankajb;

import tk.pankajb.Exceptions.UserNotFoundException;
import tk.pankajb.Requests.AuthBody;
import tk.pankajb.Responses.User;

import java.util.Scanner;

public class UI {

    public static void startUI() {

        if (AccountsManager.isSignedIn()) {
            printSignedUserOptions();
            getSignedUserInput();

        } else {
            printUnSignedUserOption();
            getUnSignedUserInput();

        }

        startUI();
    }

    private static void getUnSignedUserInput() {
        Scanner scan = new Scanner(System.in);
        switch (Integer.parseInt(scan.nextLine())) {
            case 0:
                System.exit(0);
                break;
            case 1:
                AccountsManager.signUpAccount();
                break;
            case 2:
                AccountsManager.signInAccount();
                break;
            default:
                System.out.println("\nChoose valid option\n");
        }
    }

    private static void getSignedUserInput() {
        Scanner scan = new Scanner(System.in);
        switch (Integer.parseInt(scan.nextLine())) {
            case 0:
                System.exit(0);
                break;
            case 1:
                try {
                    printCurrentUserDetails();
                } catch (UserNotFoundException e) {
                    printError(e.getMessage());
                }
                break;
            case 2:
                AccountsManager.signOutAccount();
                break;
            default:
                System.out.println("\nChoose valid option\n");
        }
    }

    private static void printUnSignedUserOption() {
        printLine();
        System.out.println("0:- Exit");
        System.out.println("1:- Create Account");
        System.out.println("2:- Access Account");
        printLine();
    }

    private static void printSignedUserOptions() {
        printLine();
        System.out.println("0:- Exit");
        System.out.println("1:- User details");
        System.out.println("2:- Sign out");
        printLine();
    }

    private static void printCurrentUserDetails() throws UserNotFoundException {
        User currentUser = AccountsManager.getCurrentUser();
        printLine();
        System.out.println("---------User Session----------");
        System.out.println("User id = " + currentUser.getId());
        System.out.println("User mail = " + currentUser.getEmail());
        System.out.println("User role = " + currentUser.getRole());
        printLine();
    }

    public static void printError(String message) {
        printLine();
        System.out.println(message);
        printLine();
    }

    public static void printNewUserDetails(String id, String email, String role) {
        printLine();
        System.out.println("-------User Created-------");
        System.out.println("Created User id = " + id);
        System.out.println("User mail = " + email);
        System.out.println("User role = " + role);
        printLine();
    }

    public static AuthBody requestCredentials() {
        Scanner scan = new Scanner(System.in);
        UI.printLine();
        System.out.print("Enter email:- ");
        String mail = scan.nextLine();
        System.out.print("Enter pass:- ");
        String pass = scan.nextLine();
        UI.printLine();
        return new AuthBody(mail, pass);
    }

    public static void printLine() {
        System.out.println("------------------------------------------");
    }

    public static void printSuccessSignIn() {
        printLine();
        System.out.println("Sign in success");
        printLine();
    }

    public static void printSuccessSignUp() {
        printLine();
        System.out.println("Sign up success");
        System.out.println("Verification link sent to your mail.");
        System.out.println("Verify your email and sign in.");
        printLine();
    }

    public static void successSignOut() {
        printLine();
        System.out.println("Sign out success");
        printLine();
    }

    public static void printKeyOrLinkNotFound() {
        printLine();
        System.out.println("Anon key or Database link not found.");
        printLine();
    }
}
