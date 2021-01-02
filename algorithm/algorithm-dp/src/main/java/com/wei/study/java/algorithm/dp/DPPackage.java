package com.wei.study.java.algorithm.dp;

import java.util.Arrays;
import java.util.Random;

/**
 * 背包问题
 */
public class DPPackage {

    // 背包总容量
    final static int TW = 50;
    // 物品个数
    final static int N = 30;
    // 物品价值
    final static int[] ITEMS_MONEY = new int[N];
//    final static int[] ITEMS_MONEY = {60, 100, 120};
    // 物品肿瘤
    final static int[] ITEMS_WEIGHT = new int[N];
//    final static int[] ITEMS_WEIGHT = {1, 2, 4};

    /**
     * 创建
     *
     * @return
     */
    public static void create() {

        Random random = new Random(System.currentTimeMillis());

        for (int i = 0; i < N; i++) {
            ITEMS_MONEY[i] = random.nextInt(300);
        }

        for (int i = 0; i < N; i++) {
            ITEMS_WEIGHT[i] = 1 + random.nextInt(TW);
        }

    }

    public static void main(String[] args) {
        create();

        System.out.println("重量：" + Arrays.toString(ITEMS_WEIGHT));
        System.out.println("价值：" + Arrays.toString(ITEMS_MONEY));

        int[][] dp = new int[N + 1][TW + 1];

        for (int i = 1; i <= N; i++) {
            for (int wg = 1; wg <= TW; wg++) {
                if (ITEMS_WEIGHT[i - 1] <= wg) {
                    dp[i][wg] = Math.max(
                            ITEMS_MONEY[i - 1] + dp[i - 1][wg - ITEMS_WEIGHT[i - 1]],
                            dp[i - 1][wg]
                    );
                } else {
                    dp[i][wg] = dp[i - 1][wg];
                }
            }
        }

        System.out.println(dp[N][TW]);

        int p1 = N;
        int p2 = TW;

        while (p1 >= 1 && p2 >= 1) {
            p1--;
            if (dp[p1 + 1][p2] > dp[p1][p2]) {
                System.out.println(ITEMS_WEIGHT[p1] + "\t\t" + ITEMS_MONEY[p1]);
                p2 = p2 - ITEMS_WEIGHT[p1];
            }
        }
    }
}
