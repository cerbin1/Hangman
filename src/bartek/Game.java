package bartek;

import java.util.Scanner;

class Game {
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Game().run();
    }

    private WordRepository wordRepository = new WordRepository();
    private SearchWord searchWord;
    private int fails = 0;

    private void run() {
        searchWord = wordRepository.getRandomWord();

        while (true) {
            System.out.print(searchWord.getBlankedWord());
            Character character = readCharacter();

            if (searchWord.guessLetter(character)) {
                notifySuccessGuess();
            } else {
                notifyFailedGuess();
            }
            HangmanPrinter.print(fails);

            if (playerLose()) {
                notifyPlayerLose();
                return;
            }

            if (searchWord.isGuessed()) {
                notifyPlayerWin();
                return;
            }
        }
    }

    private Character readCharacter() {
        System.out.print("\nPodaj literke: ");
        return scanner.next().charAt(0);
    }

    private void notifySuccessGuess() {
        System.out.println("Odgadles litere!");
    }

    private void notifyFailedGuess() {
        System.out.println(fails);
        fails++;
        System.out.println("Nie udalo ci sie odgadnac literki. Mozesz sie jeszcze pomylic " + (11 - fails) + " razy.");
    }

    private boolean playerLose() {
        return fails == 11;
    }

    private void notifyPlayerWin() {
        System.out.println(searchWord.getBlankedWord());
        System.out.println("Udalo Ci sie wygrac!");
    }

    private void notifyPlayerLose() {
        System.out.println("Przegrales :/");
        System.out.println("Wylosowane slowo to: " + searchWord.getWord());
    }
}
