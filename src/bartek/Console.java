package bartek;

import java.util.Scanner;

class Console {
    private Scanner scanner = new Scanner(System.in);

    String getName() {
        askForName();
        return scanner.nextLine();
    }

    private void askForName() {
        System.out.print("Wpisz swoje imie: ");
    }
}
