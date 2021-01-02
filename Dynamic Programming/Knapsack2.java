import java.util.Scanner;

public class Knapsack2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int[] wts =new int[n];
        System.out.println("Enter the weights:");
        for(int i = 0; i < wts.length; i++) {
            wts[i] = scan.nextInt();
        }

        int[] vals =new int[n];
        System.out.println("Enter the value w.r.t weights:");
        for(int i = 0; i < vals.length; i++) {
            vals[i] = scan.nextInt();
        }
        System.out.println("Enter the capacity of bag:");
        int cap = scan.nextInt();

        int[] dp = new int[cap+1];

        dp[0] = 0;

        for(int bagc=1; bagc <= cap;bagc++){
            int max = 0;
            for(int j=0; j < n;j++){
                
                if( bagc >= wts[j]){
                    
                    int rbagc = bagc - wts[j];       // Remining bag capacity
                    int rbagv = dp[rbagc];          // Remining bag capacity value
                    int tbagv = rbagv + vals[j];    // total value contain in bag

                    if(tbagv > max){
                        max = tbagv;
                    }
                }
            }
            dp[bagc] = max;
        }
        System.out.println("The Result:"+dp[cap]);
        scan.close();
    }
}
