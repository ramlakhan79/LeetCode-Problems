
/*==================================================================================
  
You are given a string s consisting of lowercase English letters.

Your task is to find the maximum difference diff = freq(a1) - freq(a2) between the 
frequency of characters a1 and a2 in the string such that:
a1 has an odd frequency in the string.
a2 has an even frequency in the string.
Return this maximum difference.

Example 1:
Input: s = "aaaaabbc"

Output: 3

Explanation:
The character 'a' has an odd frequency of 5, and 'b' has an even frequency of 2.
The maximum difference is 5 - 2 = 3

======================================================================================*/


public class MaximumDifferenceBetweenEvenandOddFrequency {
    public static int maxDifference(String s) {
        int freq[] = new int[26];
        int max = 0, min = Integer.MAX_VALUE;
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                if (freq[i] % 2 == 0) {
                    min = Math.min(min, freq[i]);
                } else {
                    max = Math.max(max, freq[i]);
                }
            }
        }
        return (max - min);

    }
    public static void main(String[] args) {
        System.out.println(maxDifference("aaaaabbc"));
    }
}
