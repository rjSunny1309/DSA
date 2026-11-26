package LeetcodeDSA;

import java.util.Scanner;

public class Leetcode3360 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        System.out.println(canAliceWin(n));
    }
    public static boolean canAliceWin(int n) {
        int stones = 10;
        boolean aliceTurn = true;
        while(n >= stones) {
            n -= stones;
            stones--;
            aliceTurn = !aliceTurn;
        }
        return !aliceTurn;
    }
}
