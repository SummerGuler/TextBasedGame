public class Monster extends Element {
    /** Child class of Element class to create a Monster instance */

    String monster;

    public Monster() {

        // Assigns the Monster string in red
        this.monster = "\033[1;31m" + "Monster" + "\033[0m";

    }

    public String toString() {

        return monster;
    }
}
