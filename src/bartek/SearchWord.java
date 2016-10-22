package bartek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchWord {
    private String word;
    private List<Boolean> blankedLetters = new ArrayList<>();

    public SearchWord(String wordToGuess) {
        this.word = wordToGuess;
        fillUsersWord(wordToGuess.length());
    }

    private void fillUsersWord(int size) {
        blankedLetters.addAll(Arrays.asList(new Boolean[size]));
        Collections.fill(blankedLetters, Boolean.FALSE);
    }

    public boolean guessLetter(char letter) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter && isLetterBlank(i)) {
                revealLetter(i);
                return true;
            }
        }
        return false;
    }

    private boolean isLetterBlank(int i) {
        return !blankedLetters.get(i);
    }

    private Boolean revealLetter(int i) {
        return blankedLetters.set(i, Boolean.TRUE);
    }

    String getBlankedWord() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (blankedLetters.get(i)) {
                sb.append(word.charAt(i));
                sb.append(" ");
            } else {
                sb.append("_ ");
            }
        }
        return sb.toString();
    }

    boolean isGuessed() {
        return !blankedLetters.contains(Boolean.FALSE);
    }

    public String getWord() {
        return word;
    }
}
