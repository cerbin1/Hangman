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
        String name = askForName();

        wordToGuess = wordRepository.getRandomWord();

        while (true) {
            displayBlankWord();
            if (wordToGuess.guessLetter(getCharacterToCheck())) {
                notifyPlayerSuccess();
            } else {
                incrementChances();
                notifyPlayerFailure();
            }

            if (checkIfPlayerLose()) {
                displayPlayersLose(wordToGuess.getWord());
                break;
            }

            if (wordToGuess.checkIfWordIsGuessed()) {
                displayBlankWord();
                displayPlayersWin();
                break;
            }
        }
    }

    void incrementChances() {
        fails++;
    }

    boolean checkIfPlayerLose() {
        return fails == 11;
    }


    private String askForName() {
        System.out.print("Wpisz swoje imie: ");
        return scanner.nextLine();
    }

    void displayBlankWord() {
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (usersWord.get(i)) {
                System.out.print(wordToGuess.charAt(i) + " ");
            } else {
                System.out.print("_ ");
            }
        }
    }

    Character getCharacterToCheck() {
        System.out.print("\nPodaj literke: ");
        return scanner.next().charAt(0);
    }

    void notifyPlayerSuccess() {
        System.out.println("Odgadles litere!");
        HangmanPrinter.print(fails);
    }

    void notifyPlayerFailure() {
        System.out.println("Nie udalo ci sie odgadnac literki. Mozesz sie jeszcze pomylic " + (11 - fails) + " razy.");
        HangmanPrinter.print(fails);
    }

    static void displayPlayersLose(String searchWord) {
        System.out.println("Przegrales :/");
        System.out.println("Wylosowane slowo to: " + searchWord);
    }

    static void displayPlayersWin() {
        System.out.println("\nUdalo Ci sie wygrac!");
    }
}
