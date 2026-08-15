import java.util.*;
class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        Arrays.sort(arr);
        int i =arr.length-1;
       while(i>0 && arr[i] == arr[i-1]) {
           i--;
       }
       if(i == 0) return -1;
       return arr[i-1];
    }
}