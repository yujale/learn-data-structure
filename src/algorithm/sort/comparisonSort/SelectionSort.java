package algorithm.sort.comparisonSort;

import java.util.Arrays;

import algorithm.sort.utils.GenerateRandom;

/**
 * 
 * 选择排序是一种简单直观的排序算法，其基本思想是每次从待排序的数据元素中选择最小（或最大）的一个元素，放到已排序序列的末尾，
 * 直到全部元素排序完成。
 * 
 * 基本思想：每次从待排序的数据元素中选择最小（或最大）的一个元素，放到已排序序列的末尾，直到全部元素排序完成。
 * 
 * 时间复杂度：
 * 
 * - 最坏情况时间复杂度 O(n^2)，其中 n 是数组的长度。
 * 
 * 
 * 基本流程：
 * 
 * - 初始状态：将整个数组视为两部分，已排序的部分为空，未排序的部分为整个数组。
 * - 每次次选择最小元素：在未排序的部分中，找到最小（或最大）的元素。
 * - 交换位置：将找到的最小元素与未排序部分的第一个元素（或已排序部分的最后一个元素）交换位置。
 * - 更新已排序部分：将交换后的元素视为已排序部分的一部分。
 * - 重复直到完成：重复上述步骤，直到所有元素都排序完成。
 * 
 * 
 */
public class SelectionSort {

    public static void main(String[] args) {
      // 创建包含大量随机整数的数组
      Integer[] array = GenerateRandom.tailAscOrder(1, 100000, 20000);

      // 测试基本冒泡排序方法的时间
      long startTime = System.currentTimeMillis();
      selectionSortBasic(array.clone()); // 为了避免修改原始数组，这里使用了克隆数组
      long endTime = System.currentTimeMillis();
      long basicTime = endTime - startTime;
      System.out.println("基本选择排序耗时: " + basicTime + " 毫秒");

      // 测试优化冒泡排序方法的时间
      startTime = System.currentTimeMillis();
      selectionSortOptimized(array.clone()); // 同样克隆数组以保持原始数据不变
      endTime = System.currentTimeMillis();
      long optimizedTime = endTime - startTime;
      System.out.println("优化选择排序耗时: " + optimizedTime + " 毫秒");
    }

    /**
     * 选择排序算法
     * 
     * @param array 待排序的数组
     * @return 排序后的数组
     */
    public static Integer[] selectionSortBasic(Integer[] array) {
        // 遍历数组
        for (int i = 0; i < array.length - 1; i++) {
            // 假设当前位置是最小元素的索引
            int minIndex = i;
            // 在未排序部分中找到最小元素的索引
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // 将找到的最小元素与当前位置元素交换
            swap(array, i, minIndex);
        }
        return array;
    }

    public static Integer[] selectionSortOptimized(Integer[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i; // 假设当前位置是最小元素的索引
            // 在未排序部分中找到最小元素的索引
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // 将找到的最小元素与当前位置元素交换
            if (minIndex != i) { // 只有当最小元素不在当前位置时才进行交换
                swap(array, i, minIndex);
            }
        }
        return array;
    }

    /**
     * 交换数组中的两个元素
     * 
     * @param array 待交换的数组
     * @param i     第一个元素的索引
     * @param j     第二个元素的索引
     */
    private static void swap(Integer[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 打印数组元素
     * 
     * @param array 待打印的数组
     */
    private static void printArray(Integer[] array) {
        System.out.println(Arrays.toString(array));
    }

}
