package bartek;

import java.util.Scanner;

class Game {
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Game().run();
    }

    private WordRepository wordRepository = new WordRepository();
    private WordToGuess wordToGuess;
    private int fails = 0;

    private void run() {
        wordToGuess = wordRepository.getRandomWord();

        while (true) {
            System.out.print(wordToGuess.getBlankedWord());
            Character character = readCharacter();

            if (wordToGuess.guessLetter(character)) {
                notifySuccessGuess();
            } else {
                notifyFailedGuess();
            }
            HangmanPrinter.print(fails);

            if (playerLose()) {
                notifyPlayerLose();
                return;
            }

            if (wordToGuess.checkIfWordIsGuessed()) {
                notifyPlayerWin();
                return;
            }
        }
    }

    Character readCharacter() {
        System.out.print("\nPodaj literke: ");
        return scanner.next().charAt(0);
    }

    private void notifySuccessGuess() {
        System.out.println("Odgadles litere!");
    }

    private void notifyFailedGuess() {
        fails++;
        System.out.println("Nie udalo ci sie odgadnac literki. Mozesz sie jeszcze pomylic " + (9 - fails) + " razy.");
    }

    boolean playerLose() {
        return fails >= 9;
    }

    private void notifyPlayerWin() {
        System.out.print(wordToGuess.getBlankedWord());
        System.out.println("\nUdalo Ci sie wygrac!");
    }

    private void notifyPlayerLose() {
        System.out.println("Przegrales :/");
        System.out.println("Wylosowane slowo to: " + wordToGuess.getWord());
    }
}
