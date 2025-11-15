package project.social_network.exersices.linkdin;

public class ShortestWordDisrtanceV1 {


    public static void main(String[] args) {
        shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"},
                "coding", "practise");
    }

    public static int shortestDistance(String[] wordsDict, String word1, String word2) {
        int iWord1 = -1;
        int iWord2 = -1;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                iWord1 = i;
            } else if (wordsDict[i].equals(word2)) {
                iWord2 = i;
            }

            if ((iWord1 != -1 && iWord2 != -1) && (iWord1 == i || iWord2 == i)) {
                result = Math.min(result, Math.abs(iWord1 - iWord2));
            }
        }

        return result;
    }

}
