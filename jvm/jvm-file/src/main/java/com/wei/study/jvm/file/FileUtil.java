package com.wei.study.jvm.file;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author WEI
 * @Time: 2020-11-13 16:24:46
 */
public class FileUtil {

    public static void createFile() {

        long size = 200000000L;

        try (FileOutputStream fileOutputStream = new FileOutputStream("d:\\3.txt");
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
             BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)
        ) {
            Random random = new Random(System.currentTimeMillis());
            for (long i = 0; i < size; i++) {

//                long l = (long) (size * random.nextDouble());
                String num = Long.toString(i);
                bufferedWriter.write(num);
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 统计出最大的100个数字
     */
    public static void printMax100() {

        final int n = N;
        // TreeSet 会对数字进行从小到大排序，且数字不重复
        TreeSet<Long> data = new TreeSet<>();

        try (
                // JDK 1.8 特性，会自动 close 文件流
                FileInputStream fis = new FileInputStream(FILE_NAME);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader reader = new BufferedReader(isr);) {

            // 一行一行读取文件
            String line;
            while ((line = reader.readLine()) != null) {
                Long value = Long.parseLong(line);
                // 如果value 大于TreeSet的第一个数字（最小的数字），则把数字插入到TreeSet中
                if (data.size() < n || value > data.first()) {
                    // 把数字插入到TreeSet中
                    data.add(value);

                    if (data.size() > n) { //如果TreeSet中的数字超过了100，则把第一个数字（最小的数字）去掉
                        data.pollFirst();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 结果输出
        for (Long num : data) {
            System.out.println(num);
        }
    }

    /**
     * 统计出最大的100个数字
     */
    public static void printMax100_2() {

        final int n = N;
        long[] data = new long[n];

        try (
                // JDK 1.8 特性，会自动 close 文件流
                FileInputStream fis = new FileInputStream(FILE_NAME);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader reader = new BufferedReader(isr);) {

            // 一行一行读取文件
            String line;
            while ((line = reader.readLine()) != null) {
                Long value = Long.parseLong(line);

                if (value > data[0]) {
                    int i = 1;
                    for (; i < n; i++) {
                        if (value < data[i]) {
                            break;
                        }
                        data[i - 1] = data[i];
                    }
                    data[i - 1] = value;
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 结果输出
        for (Long num : data) {
            System.out.println(num);
        }
    }

    /**
     * 统计出最大的100个数字
     */
    public static void printMax100_3() {

        final int n = N;
        long[] data = new long[n];

        try (
                // JDK 1.8 特性，会自动 close 文件流
                FileInputStream fis = new FileInputStream(FILE_NAME);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader reader = new BufferedReader(isr);) {

            // 一行一行读取文件
            String line = null;
            while ((line = reader.readLine()) != null) {
                Long value = Long.parseLong(line);

                if (value > data[0]) {
                    int left = 0;
                    int right = n;
                    int mid = (left + right) / 2;
                    while (left < right && left < mid) {
                        if (value == data[mid]) {
                            break;
                        } else if (value > data[mid]) {
                            left = mid;
                        } else {
                            right = mid;
                        }
                        mid = (left + right) / 2;
                    }

                    if (value != data[mid]) {
                        for (int i = 0; i < mid; i++) {
                            data[i] = data[i + 1];
                        }
                        data[mid] = value;
                    }
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 结果输出
        for (Long num : data) {
            System.out.println(num);
        }
    }


    public static Long[] add(Long num) {
        Long[] data = new Long[N];
        data[0] = num;
        return data;
    }

    /**
     * 统计出最大的100个数字
     */
    public static void printMax100_4() {

        final int n = N;
//        TreeSet<Long> data = new TreeSet<>();

        try (
                // JDK 1.8 特性，会自动 close 文件流
                FileInputStream fis = new FileInputStream(FILE_NAME);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader reader = new BufferedReader(isr);) {

            // 一行一行读取文件
            String line = null;
            Stream<String> lines = reader.lines();

            Optional<Long[]> reduce = lines.map(str -> Long.parseLong(str)).map(num -> add(num)).reduce((a, b) -> {
                Long[] data = new Long[N];

                int aCur = 0;
                int bCur = 0;
                int cur = 0;

                while (aCur < N && bCur < N && cur < N && a[aCur] != null && b[bCur] != null) {
                    if (a[aCur] == b[bCur]) {
                        data[cur++] = a[aCur++];
                        bCur++;
                    } else if (a[aCur] > b[bCur]) {
                        data[cur++] = a[aCur++];
                    } else {
                        data[cur++] = b[bCur++];
                    }
                }

                while (aCur < N && cur < N && a[aCur] != null) {
                    data[cur++] = a[aCur++];
                }

                while (bCur < N && cur < N && b[bCur] != null) {
                    data[cur++] = b[bCur++];
                }

                return data;
            });

            Long[] res = reduce.get();

            // 结果输出
            for (Long num : res) {
                System.out.println(num);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 统计出最大的100个数字
     */
    public static void printMax100_5() {

        final int n = N;
        TreeSet<Long> data = new TreeSet<>();

        try (
                // JDK 1.8 特性，会自动 close 文件流
                FileInputStream fis = new FileInputStream(FILE_NAME);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader reader = new BufferedReader(isr);) {

            // 一行一行读取文件
            String line = null;
            Stream<String> lines = reader.lines();

            lines.map(str -> Long.parseLong(str)).forEach(num -> {
                data.add(num);
                if (data.size() > n) { //如果TreeSet中的数字超过了100，则把第一个数字（最小的数字）去掉
                    data.pollFirst();
                }
            });



            // 结果输出
            for (Long num : data) {
                System.out.println(num);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public final static int N = 100;
    public final static String FILE_NAME = "d:\\2.txt";

    public static void main(String[] args) {
        final long start = System.currentTimeMillis();
        printMax100_5();
        System.out.println(System.currentTimeMillis() - start);
    }
}
