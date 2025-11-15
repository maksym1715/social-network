package project.social_network.exersices;

import java.util.ArrayList;
import java.util.List;

public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] c = {1, 3};
        int[] d = {2};
        System.out.println(findMedianSortedArrays(c,d));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lengthNums1 = nums1.length;
        int lengthNums2 = nums2.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0, c = 0; ; ) {
            if (i == lengthNums1) {
                while (c < lengthNums2) {
                    list.add(nums2[c]);
                    c++;
                }
                break;
            } else if (c == lengthNums2) {
                while (i < lengthNums1) {
                    list.add(nums1[i]);
                    i++;
                }
                break;
            }
            if (nums1[i] <= nums2[c]) {
                list.add(nums1[i]);
                i++;
            } else {
                list.add(nums2[c]);
                c++;
            }
        }
        if (list.size() % 2 > 0) {
            return list.get(list.size() / 2);
        } else {
            int i = list.size() / 2;
            Integer i1 = list.get(i);
            Integer i2 = list.get(i - 1);
            return (double) (i1 + i2) / 2;

        }
    }
}
