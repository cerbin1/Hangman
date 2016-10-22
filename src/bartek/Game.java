package bartek;

import java.util.Scanner;

class Game {
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Game().run();
    }

    private WordRepository wordRepository = new WordRepository();
    private int fails = 0;

    private void run() {
        String name = askForName();

        WordToGuess wordToGuess = wordRepository.getRandomWord();

        while (true) {
            System.out.print(wordToGuess.getBlankedWord());
            if (wordToGuess.guessLetter(getCharacterToCheck())) {
                notifyPlayerSuccess();
            } else {
                fails++;
                System.out.println("Nie udalo ci sie odgadnac literki. Mozesz sie jeszcze pomylic " + (11 - fails) + " razy.");
                HangmanPrinter.print(fails);
            }

            if (checkIfPlayerLose()) {
                System.out.println("Przegrales :/");
                System.out.println("Wylosowane slowo to: " + wordToGuess.getWord());
                break;
            }

            if (wordToGuess.checkIfWordIsGuessed()) {
                System.out.print(wordToGuess.getBlankedWord());
                System.out.println("\nUdalo Ci sie wygrac!");
                break;
            }
        }
    }

    boolean checkIfPlayerLose() {
        return fails == 11;
    }

    private String askForName() {
        System.out.print("Wpisz swoje imie: ");
        return scanner.nextLine();
    }

    Character getCharacterToCheck() {
        System.out.print("\nPodaj literke: ");
        return scanner.next().charAt(0);
    }

    void notifyPlayerSuccess() {
        System.out.println("Odgadles litere!");
        HangmanPrinter.print(fails);
    }
}
