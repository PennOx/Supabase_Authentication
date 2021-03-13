package tk.pankajb;

public class Main {

    public static void main(String[] args) {

        if (DBHandler.hasAnonKeyAndDbLink()) {
            UI.startUI();
        } else {
            UI.printKeyOrLinkNotFound();
        }

    }
}
