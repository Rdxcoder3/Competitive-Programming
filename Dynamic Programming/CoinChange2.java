/*  
    Coin Change Permutation
*/
import java.util.Scanner;

public class CoinChange2 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter Total No. of Coin change:");
        int n = scan.nextInt();

        System.out.println("Enter Coin change:");
        int[] coin = new int[n];
        
        for(int i=0;i<n;i++){
            coin[i] = scan.nextInt();
        }

        System.out.println("Enter the Target Amount:");
        int tar = scan.nextInt();

        int[] dp = new int[tar+1];

        dp[0] = 1;

        for(int i = 1;i <= tar;i++){
            for(int j = 0;j < coin.length;j++){

                if(coin[j] <= i){
                    dp[i] = dp[i] + dp[i - coin[j]];
                }
            }
        }
        
        System.out.println("The Result:"+dp[tar]);

        scan.close();
    }
}
