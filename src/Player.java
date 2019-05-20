
public class Player extends Element {
    /** Child class of Element class to create a Player instance */

    String player;

    public Player() {

        // Assigns the PLAYER string in blue
        this.player =  "\033[1;34m" + "PLAYER" + "\033[0m";
    }

    public String toString() {

        return player;
    }

}
