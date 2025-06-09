
/*==================================================================================
  
Given two integers n and k, return the kth lexicographically smallest integer in 
the range [1, n]. 

Example 1:

Input: n = 13, k = 2
Output: 10
Explanation: The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9],
so the second smallest number is 10.
======================================================================================*/

class KthSmallestLexicographicalOrder {
    public static int countSkipNum(long curr, long next, int n) {
        int cntNum = 0;
        while (curr <= n) {
            cntNum += (next - curr);
            curr *= 10;
            next *= 10;
            next = Math.min(next, n + 1);
        }
        return cntNum;
    }

    public static int findKthNumber(int n, int k) {
        long curr = 1;
        k -= 1;
        while (k > 0) {
            int skipNum = countSkipNum(curr, curr + 1, n);
            if (skipNum <= k) {
                curr++;
                k -= skipNum;
            } else {
                curr *= 10;
                k -= 1;
            }
        }
        return (int) curr;
    }
    public static void main(String[] args) {
        System.out.println(findKthNumber(22, 14));
    }
}