import java.util.Scanner;

public class Knapsack1 {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] wts = new int[n];
        
        System.out.println("Enter the weights:");
        
        for(int i = 0; i < wts.length; i++) {
            wts[i] = scan.nextInt();
        }

        int[] vals = new int[n];
        
        System.out.println("Enter the values w.r.t weights:");
        
        for(int i = 0; i < vals.length; i++) {
            vals[i] = scan.nextInt();
        }
        
        System.out.println("Enter the capacity of bag:");
        int cap = scan.nextInt();

        int[][] dp = new int[n+1][cap+1];

        for(int i=1;i < dp.length;i++){
            for(int j=1;j < dp[0].length;j++){
                if( j >= wts[i-1]){
                    if(dp[i-1][j-wts[i-1]] + vals[i-1] > dp[i-1][j]){
                        dp[i][j] = dp[i-1][j-wts[i-1]] + vals[i-1];
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }


        System.out.println("The Result:"+dp[n][cap]);
        scan.close();
    }
    
}