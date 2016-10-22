package bartek;

class WordRepository {
    private String[] wordsArray = {"zubr", "kot", "pies", "szczur", "hipopotam", "chomik", "zyrafa", "slon", "polacy", "kon"};
    private String wordToGuess;
    private Player player;

    WordRepository(Player player) {
        int randomNumber = (int) (Math.round(Math.random() * 10));
        wordToGuess = getWordToGuess(randomNumber);
        this.player = player;
    }

    private String getWordToGuess(int indexNumber) {
        return wordsArray[indexNumber];
    }

    String getWordToGuess() {
        return wordToGuess;
    }

    boolean checkIfCharacterIsInWord(char character) {
        boolean isCharacterInWord = false;
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == character) {
                if (player.usersWord.get(i)) {
                    System.out.println("Odkryles juz ta literke!");
                    return isCharacterInWord;
                } else {
                    player.usersWord.set(i, Boolean.TRUE);
                    isCharacterInWord = true;
                }
            }
        }
        return isCharacterInWord;
    }
}
