package com.example.project.WordScramble;
import java.util.ArrayList;
import java.util.Arrays;
public class WordScramble {
  /** Scrambles a given word.
   *
   *  @param word  the word to be scrambled
   *  @return  the scrambled word (possibly equal to word)
   *
   *  Precondition: word is either an empty string or contains only uppercase letters.
   *  Postcondition: the string returned was created from word as follows:
   *  - the word was scrambled, beginning at the first letter and continuing from left to right
   *  - two consecutive letters consisting of "A" followed by a letter that was not "A" were swapped
   *  - letters were swapped at most once
   */
  public static String scrambleWord(String word) {
      /* to be implemented in part (a) */
      ArrayList<String> letterList = new ArrayList<String>();
      for (int i = 0; i < word.length(); i++) { //turns each letter in word into an element in a arraylist
        letterList.add(word.substring(i, i + 1));
      }
      int highestIndex = -1; //makes sure that letters are swapped at most once
      for (int j = 0; j < letterList.size() - 1; j++) { //look through the letter list
        if ((letterList.get(j).equals("A") && !letterList.get(j + 1).equals("A")) && j > highestIndex) {
          letterList.set(j, letterList.get(j + 1));
          letterList.set((j + 1), "A");
          highestIndex = j + 1;
        }
      }
        String finalword = "";
        for (int k = 0; k < letterList.size(); k++) {
          finalword += letterList.get(k);
        }
        return finalword;
    }
      
  

  /** Modifies wordList by replacing each word with its scrambled
   *  version, removing any words that are unchanged as a result of scrambling.
   *
   *  @param wordList the list of words
   *
   *  Precondition: wordList contains only non-null objects
   *  Postcondition:
   *  - all words unchanged by scrambling have been removed from wordList
   *  - each of the remaining words has been replaced by its scrambled version
   *  - the relative ordering of the entries in wordList is the same as it was
   *    before the method was called
   */
  public static ArrayList<String> scrambleOrRemove(ArrayList<String> wordList) {
      /* to be implemented in part (b) */
      ArrayList<String> newarr = new ArrayList<String>();
      for (int i = 0; i < wordList.size(); i++) {
        newarr.add(wordList.get(i));
        newarr.set(i, scrambleWord(newarr.get(i)));
      }

      ArrayList<String> finalnewarr = new ArrayList<String>();
      for (int j = 0; j < newarr.size(); j++) {
        if (!newarr.get(j).equals(wordList.get(j))) {
          finalnewarr.add(newarr.get(j));
        }
      }

      return finalnewarr;
  }

  public static void main(String[] args) {
    ArrayList<String> testWordList = new ArrayList<String>(Arrays.asList("TAN", "ABRACADABRA", "WHOA", "APPLE", "EGGS"));
    testWordList = scrambleOrRemove(testWordList);
    System.out.println(testWordList);
  }
}
