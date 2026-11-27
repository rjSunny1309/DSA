package LeetcodeDSA;

import java.util.Scanner;

public class Leetcode3946 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
        int[][] items = new int[n][2];
        for(int i=0; i<n; i++) {
            System.out.print("Enter factor and price: ");
            items[i][0] = sc.nextInt();
            items[i][1] = sc.nextInt();
        }
        System.out.print("Enter budget: ");
        int budget = sc.nextInt();
        System.out.println("Output: "+maximumSaleItems(items, budget));
    }
    public static int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] dp = new int[budget+1];
        for(int i=0; i<n; i++) {
            int factor = items[i][0];
            int price = items[i][1];
            int bonus = 1;
            for(int j=0; j<n; j++) {
                if(i!=j && items[j][0] % factor==0) {
                    bonus++;
                }
            }
            int[] prev = dp.clone();
            for(int b=price; b<=budget; b++) {
                dp[b] = Math.max(prev[b], prev[b - price] + bonus);
                dp[b] = Math.max(dp[b], dp[b - price]+1);
            }
        }
        return dp[budget];
    }
}
