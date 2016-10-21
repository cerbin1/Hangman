package bartek;

import java.util.Scanner;

class Console {
    private static Scanner scanner = new Scanner(System.in);

    String getName() {
        askForName();
        return scanner.nextLine();
    }

    private void askForName() { // TODO tą trzeba zinlinować
        System.out.print("Wpisz swoje imie: ");
    }

    void displayHelloMessage(String name) { // TODO dobrze że ta funkcja jest wydzielona, ale być może ten parametr mógłby zostać przkazany jako konstruktor?
        System.out.println("Witaj " + name);
    }

    void displayBlankWord(WordToGuess word, Player player) { // TODO paramsy do konstruktora
        for (int i = 0; i < word.getWordToGuess().length(); i++) {
            if (player.usersWord.get(i)) {
                System.out.print(word.getWordToGuess().charAt(i) + " ");
            } else {
                System.out.print("_ ");
            }
        }
    }

    Character getCharacterToCheck() {
        askForCharacter();
        return scanner.next().charAt(0);
    }

    private void askForCharacter() {
        System.out.println("Podaj literke");
    }

    static void displayPlayerHitCharacter() {
        System.out.println("Jest!");
    }

    static void displayPlayerNoHitCharacter() {
        System.out.println("Nie udalo ci sie odgadnac literki.");
    }

    static void displayPlayersLose() {
        System.out.println("Przegrales");
    }
}
