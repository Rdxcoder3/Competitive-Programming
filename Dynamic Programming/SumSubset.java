import java.util.Scanner;

class SumSubset{
    public static void main(String[] args) {
        
        Scanner scan =new Scanner(System.in);
        System.out.println("Size of array:");
        int size = scan.nextInt();
        int[] arr =new int[size];

        for(int k=0;k<size;k++){
            arr[k] = scan.nextInt();
        }
        System.out.println("Target:");
        int tar = scan.nextInt();
        boolean[][] dp = new boolean[size+1][tar+1];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i == 0 && j == 0){
                    dp[i][j] = true;
                }
                else if(i == 0){
                    dp[i][j] = false;
                }
                else if(j == 0){
                    dp[i][j] = true;
                }
                else{
                    if(dp[i-1][j] == true){
                        dp[i][j] = true;
                    }
                    else{
                        int value = arr[i-1];
                        if(j >= value){
                            if(dp[i-1][j-value] == true){
                                dp[i][j] = true;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Result:"+dp[arr.length][tar]);
        scan.close();
    }
}