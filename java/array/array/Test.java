package array;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        MajorityElement ans = new MajorityElement();
        int nums[] = {3,2,3};
        System.out.print(ans.majorityElement(nums));
    }
}

class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap myMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (myMap.containsKey(nums[i])) {
                int value = (Integer)myMap.get(nums[i]);
                myMap.replace(nums[i],++value); //++value not value++!!
            } else {
                myMap.put(nums[i], 1);
            }
        }
        int max = 0;
        int result = 0;
        for (Object key : myMap.keySet()) {
            int a = (Integer)key;
            if ((Integer)myMap.get(a) > max) {
                max = (Integer)myMap.get(a);
                result = a;
            }
        }
        return result;
    }
}