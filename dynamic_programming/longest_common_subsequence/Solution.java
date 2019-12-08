package hackerrank.dynamic_programming.longest_common_subsequence;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args){
        int[] c = {3, 9, 8, 3, 9, 7, 9, 7, 0};
        int[] d = {3, 3, 9, 9, 9, 1, 7, 2, 0, 6};
        System.out.println(Arrays.toString(longestCommonSubsequence(c, d)));
        // Result: [3, 9, 9, 9, 7, 0]
    }

    // Complete the longestCommonSubsequence function below.
    static int[] longestCommonSubsequence(int[] a, int[] b) {
        int[][] c = new int[a.length+1][b.length+1];
        char[][] d = new char[a.length][b.length];

        for(int i=1; i<c.length; i++){
            for(int j=1; j<c[0].length; j++){
                if(a[i-1] == b[j-1]) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    d[i-1][j-1] = 'd';
                }
                else if(c[i-1][j] >= c[i][j-1]) {
                    c[i][j] = c[i - 1][j];
                    d[i-1][j-1] = 'u';
                }
                else {
                    c[i][j] = c[i][j - 1];
                    d[i-1][j-1] = 'l';
                }
            }
        }
        int[] lcs = new int[c[c.length-1][c[0].length-1]];
        return getLCS(d, a, d.length-1, d[0].length-1, lcs, lcs.length);
    }

    static int[] getLCS(char[][] d, int[] x, int i, int j, int[] lcs, int index){
        if(i==-1 || j==-1)
            return lcs;

        if(d[i][j] == 'd') {
            index--;
            getLCS(d, x, i - 1, j - 1, lcs, index);
            lcs[index] = x[i];
        } else if(d[i][j] == 'u')
            getLCS(d, x, i-1, j, lcs, index);
        else
            getLCS(d, x, i, j-1, lcs, index);

        return lcs;
    }

}
