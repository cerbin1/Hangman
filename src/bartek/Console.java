package bartek;

import java.util.Scanner;

class Console {
    private static Scanner scanner = new Scanner(System.in);

    Console(Player player) {
        askForName(player.getName());
    }

    private void askForName(String name) { // TODO dobrze że ta funkcja jest wydzielona, ale być może ten parametr mógłby zostać przkazany jako konstruktor?
        System.out.print("Wpisz swoje imie: ");
        System.out.println("Witaj " + name);
    }

    void displayBlankWord(WordToGuess word, Player player) { // TODO paramsy do konstruktora
        System.out.println(player.usersWord.size());
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

    static void displayPlayersLose(String guessedWord) {
        System.out.println("Przegrales :/ \nWylosowane slowo to: " + guessedWord);
    }

    static void displayPlayersWin() {
        System.out.println("\nUdalo Ci sie wygrac!");
    }
}
