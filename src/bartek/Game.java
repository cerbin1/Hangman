package bartek;

class Game {
    public static void main(String[] args) {
        new Game().run();
    }

    private void run() {

        WordToGuess word = new WordToGuess();
        Player player = new Player("Marian", word.getWordToGuess().length()); //TODO change name to get it from user
        Console console = new Console(player, word);

        while (true) {
            console.displayBlankWord();
            if (word.checkIfCharacterIsInWord(console.getCharacterToCheck(), player)) {
                Console.displayPlayerHitCharacter();
            } else {
                player.incrementChances();
                Console.displayPlayerNoHitCharacter(player.getFails());
            }

            if (player.checkIfPlayerLose()) {
                Console.displayPlayersLose(word.getWordToGuess());
                break;
            }

            if (player.checkIfWordIsGuessed()) {
                console.displayBlankWord();
                Console.displayPlayersWin();
                break;
            }
        }
    }
}
