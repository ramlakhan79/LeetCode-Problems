
/*======================================================

You are given a string s and an integer k. Your task is to find the maximum difference between
the frequency of two characters, freq[a] - freq[b], in a substring subs of s, such that:

subs has a size of at least k.
Character a has an odd frequency in subs.
Character b has an even frequency in subs.
Return the maximum difference.

Note that subs can contain more than 2 distinct characters.

 

Example 1:

Input: s = "12233", k = 4

Output: -1

====================================================== */

import java.util.Arrays;

public class MaximumDifferenceBetweenEvenandOddFrequencyII {
    public static int getStatus(int countFreqA, int countFreqB){
        return ((countFreqA&1)<<1) | (countFreqB&1);
    }
    public static int maxDifference(String s, int k) {
        int n=s.length();
        int ans=Integer.MIN_VALUE;
        for(char a='0';a<='4';a++){
            for(char b='0';b<='4';b++){
                if(a==b){
                    continue;
                }
                int best[]=new int[4];
                Arrays.fill(best, Integer.MAX_VALUE);
                int countFreqA=0, countFreqB=0;
                int prevFreqA=0, prevFreqB=0;
                int left=-1;
                for(int right=0;right<n;right++){
                    countFreqA+=(s.charAt(right)==a)?1:0;
                    countFreqB+= (s.charAt(right)==b)?1:0;
                    while(right-left>=k && countFreqB-prevFreqB>=2){
                        int leftStatus=getStatus(prevFreqA, prevFreqB);
                        best[leftStatus]=Math.min(best[leftStatus], prevFreqA-prevFreqB);
                        left++;
                        prevFreqA+=(s.charAt(left)==a)?1:0;
                        prevFreqB+=(s.charAt(left)==b)?1:0;
                    }
                    int rightStatus=getStatus(countFreqA, countFreqB);
                    if(best[rightStatus^0b10]!=Integer.MAX_VALUE){
                        ans=Math.max(ans, countFreqA-countFreqB-best[rightStatus^0b10]);
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(maxDifference("12233", 4));
    }
}
