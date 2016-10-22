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

    public boolean guessLetter(char character) {
        boolean isCharacterInWord = false;
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == character) {
                if (userWord.get(i)) {
                    System.out.println("Odkryles juz ta literke!");
                    return isCharacterInWord;
                } else {
                    userWord.set(i, Boolean.TRUE);
                    isCharacterInWord = true;
                }
            }
        }
        return isCharacterInWord;
    }

    boolean checkIfWordIsGuessed() {
        return !userWord.contains(Boolean.FALSE);
    }

    public String getWord() {
        return wordToGuess;
    }
}
