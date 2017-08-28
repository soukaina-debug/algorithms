// https://leetcode.com/problems/remove-k-digits
//
// Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
//
// Note:
// The length of num is less than 10002 and will be ≥ k.
// The given num does not contain any leading zero.
// Example 1:
//
// Input: num = "1432219", k = 3
// Output: "1219"
// Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
// Example 2:
//
// Input: num = "10200", k = 1
// Output: "200"
// Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
// Example 3:
//
// Input: num = "10", k = 2
// Output: "0"
// Explanation: Remove all the digits from the number and it is left with nothing which is 0.
class Solution {
    public String removeKdigits(String num, int k) {
        if (k == 0 || num.length() == 0) return num;
        Deque<Character> deque = new LinkedList<>();
        for (char c : num.toCharArray()) {
            while (!deque.isEmpty() && deque.peek() > c && k-- > 0) {
                deque.pop();
            }
            if (deque.isEmpty() && c == '0') continue;
            deque.push(c);
        }
        while (k-- > 0 && !deque.isEmpty()) {
            deque.pop();
        }
        if (deque.isEmpty()) return "0";
        int cursor = deque.size();
        char[] result = new char[deque.size()];
        while (--cursor >= 0) {
            result[cursor] = deque.pop();
        }
        return new String(result);
    }
}
