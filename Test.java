import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Test {
    public static int findLargestSum(int[] array) {
        int sum = Integer.MIN_VALUE;
        int start = -1, end = -1;
        for (int i = 0; i < array.length; i++) {
            int val = 0;
            for (int j = i; j < array.length; j++) {
                val = val + array[j];
                if (val > sum) {
                    sum = val;
                    start = i;
                    end = j;
                }
            }
        }
        int[] sub = new int[end-start+1];
        for (int i = 0, j = start; j <= end; i++, j++) {
            sub[i] = array[j];
        }
        System.out.println("sum is " + sum + ", sub is " + Arrays.toString(sub));
        return sum;
    }

    public static boolean validation(String input) {
        Map<Character, Character> maps = new HashMap<>();
        maps.put(')','(');
        maps.put('}','{');
        maps.put(']','[');
        char[] array = input.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : array) {
            if (!stack.isEmpty()) {
                if (maps.containsKey(c)) {
                    if (maps.get(c) != stack.pop()) {
                        return false;
                    }
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
//        int[] array = new int[] {5,4,-1,7,8};
//        findLargestSum(array);
        System.out.println(validation("([)]"));
    }
}

