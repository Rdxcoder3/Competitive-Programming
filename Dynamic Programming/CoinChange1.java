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
        int[] arr = new int[n];
        
        for(int i=0;i<n;i++){
            arr[i] = scan.nextInt();
        }

        System.out.println("Enter the Amount:");
        int amt = scan.nextInt();

        int[] dp = new int[amt+1];

        dp[0] = 1;

        for(int i=0;i<arr.length;i++){
            for(int j=arr[i];j<=amt;j++){
                dp[j] += dp[j - arr[i]];
            }
        }
        
        System.out.println("The Result:"+dp[amt]);

        scan.close();
    }
}