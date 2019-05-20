import java.util.Scanner;

public class GameInput {
    public char askPlayer() {
        /**
         * Asks the player which direction to go to */

        char answer = ' ';
        Scanner scan = new Scanner(System.in);

        System.out.println();
        System.out.print("Where do you want to move (n/s/e/w): ");
        answer = scan.next().toLowerCase().charAt(0);

        return answer;
    } // end of askPlayer()
}
