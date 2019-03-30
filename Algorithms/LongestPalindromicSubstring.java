package Algorithms;

/*
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {

        System.out.println(longestPalindrome(""));
    }
    public static String longestPalindrome(String s) {
        if(s.equals(""))
        {
            return s;
        }
        int indexk = 0;
        int indexJ = 0;
        int length = -1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i, k = i; j < s.length() && k >=0 && s.charAt(k) == s.charAt(j); j++, k--) {
                    if(length < j - k)
                    {
                        length = j - k;
                        indexk = k;
                        indexJ = j;
                    }
            }

            for (int j = i + 1, k = i; j < s.length() && k >=0 && s.charAt(k) == s.charAt(j); j++, k--) {

                    if(length < j - k)
                    {
                        length = j - k;
                        indexk = k;
                        indexJ = j;
                    }

            }
        }
        return s.substring(indexk, indexJ + 1);
    }
}
