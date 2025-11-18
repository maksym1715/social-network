package project.social_network.exersices.linkdin;

import java.util.Arrays;

public class RecursionTest {

    public static void main(String[] args) {
//        priontNumber(6);
//        System.out.println(factorial(5));
        permutation(new int[]{0, 1, 2},new int[]{0, 1, 2});
    }


    public static void priontNumber(int a) {
        if (a == 0) return;
        priontNumber(a - 1);
        System.out.println(a);
    }

    public static int factorial(int c) {
        if (c == 0) return 1;

        return factorial(c - 1) * c;
    }

    public static void permutation(int[] a, int [] c) {

        if (a.length == 0) return;

        for (int i = 0; i < c.length - 1; i++) {
            permutation(Arrays.copyOfRange(c, i, i+1),c);
        }
        System.out.println(Arrays.toString(a));
    }

}
