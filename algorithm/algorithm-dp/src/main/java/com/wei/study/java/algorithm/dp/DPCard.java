package com.wei.study.java.algorithm.dp;

import java.util.Arrays;
import java.util.Random;

/**
 * 清空购物车动态规划实现
 */
public class DPCard {

    public static int[] create(int n, int totol) {
        int[] data = new int[n];

        Random random = new Random(System.currentTimeMillis());

        for (int i = 0; i < n; i++) {
            data[i] = random.nextInt(totol);
        }

        return data;
    }

    public static void main(String[] args) {

        int total = 5005;
        int n = 10;

        int[] items = create(n, total);

        System.out.println(Arrays.toString(items));

        int[][] dp = new int[n + 1][total + 1];

        for (int i = 1; i <= n; i++) {
            for (int money = 1; money <= total; money++) {
                if (items[i - 1] <= money) {
                    dp[i][money] = Math.max(items[i - 1] + dp[i - 1][money - items[i - 1]], dp[i - 1][money]);
                } else {
                    dp[i][money] = dp[i - 1][money];
                }
            }
        }

        System.out.println(dp[n][total]);

        int p1 = n;
        int p2 = total;

        while (p1 >= 1 && p2 >= 1) {
            p1--;
            if (dp[p1 + 1][p2] > dp[p1][p2]) {
                System.out.println(items[p1]);
                p2 = p2 - items[p1];
            }
        }
    }
}
