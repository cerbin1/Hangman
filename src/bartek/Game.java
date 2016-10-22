package bartek;

class Game {
    public static void main(String[] args) {
        new Game().run();
    }

    private void run() {

        Player player = new Player("Marian", word.getWordToGuess().length()); //TODO change name to get it from user
        WordRepository word = new WordRepository(player);
        Console console = new Console(player, word);

        while (true) {
            console.displayBlankWord();
            if (word.checkIfCharacterIsInWord(console.getCharacterToCheck())) {
                console.displayPlayerHitCharacter();
            } else {
                player.incrementChances();
                console.displayPlayerNoHitCharacter();
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
