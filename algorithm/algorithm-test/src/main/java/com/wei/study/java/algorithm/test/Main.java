package com.wei.study.java.algorithm.test;

import java.util.Arrays;

public class Main {
//
//    public ArrayList<Integer>GetLeastNumbers_Solution(int[] input, int k) {
//        ArrayList<Integer> array = new ArrayList<Integer>();
//        if(input==null||input.length==0||k<=0||k>input.length){
//            return array;
//        }
//        for(int i=k/2-1;i>=0;i--){
//            buildMaxHeapSort(input,i,k);
//        }
//        for(int j=k;j<input.length;j++){
//            if(input[j]<input[0]){
//                swap(input,0,j);
//                buildMaxHeapSort(input,0,k);
//            }
//        }
//        for(int i=k-1;i>=0;i--){
//            array.add(input[i]);
//        }
//        return array;
//    }
//
//    public void buildMaxHeapSort(int[] input,int i,int k){
//        int leftchild=2*i;
//        int rightchild=2*i+1;
//        int larget=i;
//        if(leftchild<k&&input[i]<input[leftchild]){
//            larget=leftchild;
//        }
//        if(rightchild<k&&input[larget]<input[rightchild]){
//            larget=rightchild;
//        }
//        if(larget!=i){
//            swap(input,i,larget);
//            buildMaxHeapSort(input,larget,k);
//        }
//    }
//
//    public void swap(int[] input,int a,int b){
//        int temp=input[a];
//        input[a]=input[b];
//        input[b]=temp;
//    }
//
//    public static void main(String[] args) {
//        int[] input = {6, 9, 1, 1, 2, 3, 4, 5};
//        int k = 3;
//        test1(input, k);
//    }
}
