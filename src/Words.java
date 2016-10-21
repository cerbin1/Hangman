public class Words {
    private String[] wordsArray = {"zubr", "kot",  "pies",  "szczur",  "hipopotam",  "chomik",  "zyrafa",  "slon",  "polacy",  "kon"};
    private String wordToGuess;
    private int randomNumber;

    public Words() {
        randomNumber = (int)(Math.round(Math.random() * 10));
    }

    public String getWordToGuess(int indexNumber) {
        return wordsArray[indexNumber];
    }
}
