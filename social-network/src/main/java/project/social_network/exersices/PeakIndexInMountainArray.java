package project.social_network.exersices;

public class PeakIndexInMountainArray {

    public static void main(String[] args) {

    }


    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int mid = left +(right - left) / 2;
        while (left < right) {
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid ;
            }
            mid =left + (right - left) / 2;
        }
        return arr[right] > arr[left] ? right : left;
    }


}

//You are given an integer mountain array arr of length n where the values increase to a peak element and then decrease.
//
//Return the index of the peak element.
//
//Your task is to solve it in O(log(n)) time complexity.
//
//
//
//Example 1:
//
//Input: arr = [0,1,0]
//
//Output: 1
//
//Example 2:
//
//Input: arr = [0,2,1,0]
//
//Output: 1
//
//Example 3:
//
//Input: arr = [0,10,5,2]
//
//Output: 1

