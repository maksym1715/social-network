package project.social_network.exersices.linkdin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShortestWordDistance {
    public static void main(String[] args) {

    }

    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int fistIndex = 0, secondIndex = 0;
        int bestlength = Integer.MAX_VALUE;
        while (secondIndex < wordsDict.length) {
            if (Objects.equals(wordsDict[secondIndex], word1)) {
                fistIndex = findTheSecondsWord(fistIndex+1, wordsDict, word2);
                if (fistIndex != -1) {
                    bestlength = Math.min(secondIndex - fistIndex, bestlength);
                }
            }
            if (Objects.equals(wordsDict[secondIndex], word2)) {
                fistIndex = findTheFirstWord(fistIndex=1, wordsDict, word1);
                if (fistIndex != -1) {
                    bestlength = Math.min(fistIndex - secondIndex, bestlength);
                }
            }
            secondIndex++;
        }
        return bestlength;
    }

    private int findTheSecondsWord(int secondIndex, String[] wordsDict, String word) {
        while (secondIndex < wordsDict.length) {
            secondIndex++;
            if (Objects.equals(wordsDict[secondIndex], word)) return secondIndex;
        }
        return -1;
    }


    private int findTheFirstWord(int secondIndex, String[] wordsDict, String word) {
        while (secondIndex < wordsDict.length) {
            secondIndex++;
            if (Objects.equals(wordsDict[secondIndex], word)) return secondIndex;
        }
        return -1;
    }

}
