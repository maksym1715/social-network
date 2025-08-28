package project.social_network.exersices;

public class LicenseKeyFormatting {
    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("5F3Z-2E9W-"
                , 4));
    }

    public static String licenseKeyFormatting(String s, int k) {
        char[] charArray = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = charArray.length - 1; i >= 0; ) {
            int count = k;
            StringBuilder stringBuilder1 = new StringBuilder();
            while (count != 0 && i >= 0) {
                if (charArray[i] == '-') {
                    i--;
                    continue;
                }
                String lowerCase = String.valueOf(charArray[i]).toUpperCase();
                stringBuilder1.append(lowerCase);
                count--;
                i--;
            }

            stringBuilder1.reverse();
            stringBuilder = stringBuilder1.append("-").append(stringBuilder);
        }
        if (stringBuilder.charAt(0)=='-')stringBuilder.deleteCharAt(0);
        if (!stringBuilder.isEmpty() && stringBuilder.charAt(stringBuilder.length()-1)=='-'){
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        return stringBuilder.toString();
    }
}


//
//Input: s = "5F3Z-2e-9-w", k = 4
//Output: "5F3Z-2E9W"
//Explanation: The string s has been split into two parts, each part has 4 characters.
//Note that the two extra dashes are not needed and can be removed.