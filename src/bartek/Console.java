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

    void displayHelloMessage(String name) {
        System.out.println("Witaj " + name);
    }

    void displayBlankWord(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print("_ ");
        }
    }
}