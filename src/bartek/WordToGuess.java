package bartek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WordToGuess {
    private String wordToGuess;
    private List<Boolean> userWord = new ArrayList<>();

    public WordToGuess(String wordToGuess) {
        this.wordToGuess = wordToGuess;
        fillUsersWord(wordToGuess.length());
    }

    private void fillUsersWord(int size) {
        userWord.addAll(Arrays.asList(new Boolean[size]));
        Collections.fill(userWord, Boolean.FALSE);
    }

    public boolean guessLetter(char letter) {

    }

    boolean checkIfWordIsGuessed() {
        return !userWord.contains(Boolean.FALSE);
    }

    public String getWord() {
        return wordToGuess;
    }
}
