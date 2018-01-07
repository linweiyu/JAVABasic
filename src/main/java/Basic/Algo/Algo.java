package Basic.Algo;

import java.util.*;

public class Algo {
    public static void main(String[] args) {
//        System.out.println(removeElement(new int[]{1,2,3,4}, 2));
        moveZeroes(new int[]{1,0,1});
    }


    public static boolean isPalindrome(int x) {
        List<Integer> storeNumber = new ArrayList<Integer>();
        boolean isPositive = x >= 0 ? true : false;
        while (x != 0) {
            storeNumber.add(x % 10);
            x /= 10;
        }
        int size = storeNumber.size();
        int k = 0;
        if (!isPositive) {
            return false;
        }
        for (int i = size - 1; i >= (size - 1) / 2; i--) {
            if (!storeNumber.get(k).equals(storeNumber.get(i))) {
                return false;
            }
            k++;
        }
        return true;
    }

    public static int reverse(int x) {
        int result = 0, k = 0;
        Stack<Integer> stack = new Stack<Integer>();
        while (x != 0) {
            stack.push(x % 10);
            x /= 10;
        }
        while (!stack.empty()) {
            int temp = result, adder = (int) (stack.pop() * Math.pow(10, k));
            result += adder;
            // HD 2-12 Overflow iff both arguments have the opposite sign of the result
            if (((temp ^ result) & (adder ^ result)) < 0) {
                return 0;
            }
            k++;
        }
        return result;
    }

    public static String longestCommonPrefix(String[] strs) {
        String prefix = new String();
        if (strs.length == 0) {
            return prefix;
        }
        int largestSize = strs[0].length();
        for (String str : strs) {
            largestSize = str.length() <= largestSize ? str.length() : largestSize;
        }
        for (int i = 0; i < largestSize; i++) {
            char temp = strs[0].charAt(i);
            for (String str : strs) {
                if (str.charAt(i) != temp) {
                    return prefix;
                }
            }
            prefix = prefix.concat(String.valueOf(temp));
        }
        return prefix;
    }

    public static boolean isValid(String s) {
        int judge = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        Stack<Integer> key = new Stack<Integer>();
        map.put('(', 1);
        map.put(')', -1);
        map.put('[', 2);
        map.put(']', -2);
        map.put('{', 3);
        map.put('}', -3);
        if (s.length() == 0)
            return true;
        char[] input = s.toCharArray();
        for (char item : input) {
            int weight = map.get(item);
            if (weight < 0) {
                if (key.empty() || key.peek() != Math.abs(weight))
                    return false;
                else {
                    key.pop();
                    judge += weight;
                }
            } else {
                judge += weight;
                key.push(weight);
            }
        }
        if (judge == 0)
            return true;
        else
            return false;
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode resultHead = new ListNode(0), temp = resultHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1 != null && l2 == null)
            temp.next = l1;
        if (l2 != null && l1 == null)
            temp.next = l2;
        return resultHead.next;
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int duplicateNumber = 0, temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (temp == nums[i]) {
                duplicateNumber++;

            } else {
                temp = nums[i];
            }
            nums[i - duplicateNumber] = nums[i];
        }
        return nums.length - duplicateNumber;
    }

    public static int removeDuplicatesBetter(int[] nums) {
        int dupNum = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                dupNum++;
            }
            nums[i - dupNum] = nums[i];
        }
        return nums.length - dupNum;
    }

    //1 2 2 3          3 2 2 3   3  2 2 2 3    4 5 6   6   1 2 3 4   2
    public static int removeElement(int[] nums, int val) {
        Queue<Integer> sameIndexs = new LinkedList<Integer>();
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == val){
                sameIndexs.offer(i);
                count++;
            }else{
                if(!sameIndexs.isEmpty()){
                    int sameIndex = sameIndexs.poll();
                    int temp = nums[sameIndex];
                    nums[sameIndex] = nums[i];
                    nums[i] = sameIndex;
                    sameIndexs.offer(i);
                }
            }
        }
        return nums.length - count;
    }
    public static void moveZeroes(int[] nums) {
        int numsOf0 = 0;
        Queue<Integer> sameIndexs = new LinkedList<Integer>();
        for(int item : nums){
            if((item ^ 0) == 0){
                numsOf0++;
            }
        }
        if(numsOf0 == 0)
            return;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                if(!sameIndexs.isEmpty()){
                    int zeroIndex = sameIndexs.poll();
                    int temp = nums[zeroIndex];
                    nums[zeroIndex] = nums[i];
                    nums[i] = temp;
                    sameIndexs.offer(i);
                }
            }else{
                sameIndexs.offer(i);
            }
        }
        for(int k = nums.length; k < numsOf0; k--){
            nums[k] = 0;
        }
    }
}
