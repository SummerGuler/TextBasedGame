public class Sword extends Element {
    /** Child class of Element class to create a Sword instance */

    String sword;

    public Sword() {

        // Assigns the Sword string in green
        this.sword = "\033[1;32m" + "Sword" + "\033[0m";
    }

    public String toString() {

        return sword;
    }
}
