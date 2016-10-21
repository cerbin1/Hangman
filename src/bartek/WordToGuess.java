package bartek;

class WordToGuess {
    private String[] wordsArray = {"zubr", "kot",  "pies",  "szczur",  "hipopotam",  "chomik",  "zyrafa",  "slon",  "polacy",  "kon"};
    private String wordToGuess;

    WordToGuess() {
        int randomNumber = (int) (Math.round(Math.random() * 10));
        wordToGuess = getWordToGuess(randomNumber);
    }

    private String getWordToGuess(int indexNumber) {
        return wordsArray[indexNumber];
    }

    String getWordToGuess() {
        return wordToGuess;
    }
}
