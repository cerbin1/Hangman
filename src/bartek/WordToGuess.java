package bartek;

class WordToGuess { // TODO rename to WordsRepository czy coś.
    private String[] wordsArray = {"zubr", "kot", "pies", "szczur", "hipopotam", "chomik", "zyrafa", "slon", "polacy", "kon"};
    private String wordToGuess;

    WordToGuess() {
        int randomNumber = (int) (Math.round(Math.random() * 10));
        wordToGuess = getWordToGuess(randomNumber);
        System.out.println(wordToGuess);
    }

    private String getWordToGuess(int indexNumber) {
        return wordsArray[indexNumber];
    }

    String getWordToGuess() {
        return wordToGuess;
    }

    boolean checkIfCharacterIsInWord(char character, Player player) {
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
