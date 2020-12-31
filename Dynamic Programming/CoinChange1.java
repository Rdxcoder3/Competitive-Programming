/*  
    Coin Change Combination
*/

import java.util.Scanner;

public class CoinChange1 {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter Coin change Size:");
        int n = scan.nextInt();

        System.out.println("Enter coin change:");
        int[] coin = new int[n];
        
        for(int i=0;i<n;i++){
            coin[i] = scan.nextInt();
        }

        System.out.println("Enter the Target Amount:");
        int amt = scan.nextInt();

        int[] dp = new int[amt+1];

        dp[0] = 1;

        for(int i=0;i<coin.length;i++){
            
            for(int j=coin[i];j<=amt;j++){
                
                dp[j] += dp[j - coin[i]];
            }
        }
        
        System.out.println("The Result:"+dp[amt]);

        scan.close();
    }
}