package LeetcodeDSA;

import java.util.Scanner;

public class Leetcode3411 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.print("Output: "+maxLength(nums));
    }
    public static int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i=0; i<n; i++) {
            long product = 1;
            long gcd = 0;
            long lcm = 1;
            for(int j=i; j<n; j++) {
                product *= nums[j];
                gcd = gcd(gcd, nums[j]);
                lcm = lcm(lcm, nums[j]);
                if(product == gcd * lcm) {
                    ans = Math.max(ans, j-i+1);
                }
            }
        }
        return ans;
    }
    private static long gcd(long a, long b) {
        while(b!=0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    private static long lcm(long a, long b) {
        return (a/gcd(a,b))*b;
    }
}
