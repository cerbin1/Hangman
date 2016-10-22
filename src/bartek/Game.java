package bartek;

class Game {
    public static void main(String[] args) {
        new Game().run();
    }

    private void run() {
        WordToGuess word = new WordToGuess();
        Player player = new Player("Marian", word.getWordToGuess().length()); //TODO change name to get it from user
        Console console = new Console(player);

        while (true) {
            console.displayBlankWord(word, player);
            if (word.checkIfCharacterIsInWord(console.getCharacterToCheck(), player)) {
                Console.displayPlayerHitCharacter();
            } else {
                Console.displayPlayerNoHitCharacter();
                player.incrementChances();
            }

            if (player.checkIfPlayerLose()) {
                Console.displayPlayersLose();
                break;
            }

            if (player.checkIfWordIsGuessed()) {
                Console.displayPlayersWin(word.getWordToGuess());
                break;
            }
        }
    }
}
