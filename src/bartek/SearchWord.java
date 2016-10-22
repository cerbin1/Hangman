package bartek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchWord {
    private String word;
    private List<Boolean> userWord = new ArrayList<>();

    public SearchWord(String wordToGuess) {
        this.word = wordToGuess;
        fillUsersWord(wordToGuess.length());
    }

    private void fillUsersWord(int size) {
        userWord.addAll(Arrays.asList(new Boolean[size]));
        Collections.fill(userWord, Boolean.FALSE);
    }

    public boolean guessLetter(char character) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == character) {
                if (userWord.get(i)) {
                    System.out.println("Odkryles juz ta literke!");
                    return false;
                }
                userWord.set(i, Boolean.TRUE);
            }
        }
        return true;
    }

    String getBlankedWord() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (userWord.get(i)) {
                sb.append(word.charAt(i));
                sb.append(" ");
            } else {
                sb.append("_ ");
            }
        }
        return sb.toString();
    }

    boolean isGuessed() {
        return !userWord.contains(Boolean.FALSE);
    }

    public String getWord() {
        return word;
    }
}
