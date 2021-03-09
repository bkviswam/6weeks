package com.facebook;

/**
 * Given a string num which represents an integer, return true if num is a strobogrammatic number.
 * <p>
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: num = "69"
 * Output: true
 * Example 2:
 * <p>
 * Input: num = "88"
 * Output: true
 * Example 3:
 * <p>
 * Input: num = "962"
 * Output: false
 * Example 4:
 * <p>
 * Input: num = "1"
 * Output: true
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= num.length <= 50
 * num consists of only digits.
 * num does not contain any leading zeros except for zero itself.
 */
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        int start = 0;
        int end = num.length() - 1;
        while (start <= end) {
            char i = num.charAt(start);
            char j = num.charAt(end);
            if ((i == '0' && j == '0') ||
                    (i == '1' && j == '1') ||
                    (i == '6' && j == '9') ||
                    (i == '9' && j == '6') ||
                    (i == '8' && j == '8')) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        StrobogrammaticNumber s = new StrobogrammaticNumber();
        String num = "1001";
        System.out.println(s.isStrobogrammatic(num));
    }
}
