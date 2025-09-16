package project.social_network.exersices;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {

    }

    public int[] plusOne(int[] digits) {
        int left = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int i1 = digits[i] + left;
            if (i1 > 9) {
                digits[i] = i1 % 10;
            } else {
                digits[i] = i1;
                left = 0;
            }
        }
        if (left > 0) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            System.arraycopy(digits, 0, res, 1, digits.length);
            return res;
        } else return digits;
    }
}

//}
//
//You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
//
//Increment the large integer by one and return the resulting array of digits.