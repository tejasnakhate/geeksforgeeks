import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		System.out.println("GfG!");
        String s = "abcdaf";
        String t = "acbcf";
        
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(s.charAt(i-1)==t.charAt(j-1)) dp[i][j] = dp[i-1][j-1]+1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        int i=n, j=m;
        while(i>0 && j>0) {
            if(s.charAt(i-1)==t.charAt(j-1)) {
                sb.append(s.charAt(i-1));
                i--; j--;
            }
            else {
                if(dp[i-1][j] > dp[i][j-1]) i--;
                else j--;
            }
        }
        
        System.out.println(sb.reverse());
	}
}
