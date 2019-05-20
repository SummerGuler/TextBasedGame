public class Potion extends Element {
    /** Child class of Element class to create a Potion instance */

    String potion;

    public Potion() {

        // Assigns the Potion string in yellow
        this.potion = "\033[1;33m" + "Potion" + "\033[0m";
    }

    public String toString() {

        return potion;
    }
}
