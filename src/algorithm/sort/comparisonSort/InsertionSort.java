package algorithm.sort.comparisonSort;

import algorithm.sort.utils.GenerateRandom;

/**
 * 插入排序
 * 
 * 插入排序是一种简单直观的排序算法，它的工作方式是每次从未排序的部分取出一个元素，将其插入到已排序部分的适当位置，直至所有元素都排序完成。
 * 
 * 基本思路
 * - 初始状态：将数组分为两部分，一部分是已排序的部分，另一部分是未排序的部分。
 * 初始时，已排序部分只包含数组的第一个元素，未排序部分包含除第一个元素外的所有元素。
 * - 遍历未排序部分：从第二个元素开始遍历未排序部分。
 * -
 * 插入操作：对于当前遍历到的元素，将其与已排序部分的元素依次比较，直到找到合适的插入位置。插入操作是将当前元素插入到已排序部分的适当位置，同时将已排序部分中大于当前元素的元素都向右移动一个位置。
 * - 重复步骤2和3：重复遍历未排序部分并进行插入操作，直到未排序部分的所有元素都被插入到已排序部分为止。
 * - 排序完成：当所有元素都被插入到已排序部分时，数组就完成了排序。
 * 
 * 时间复杂度
 * 
 * - O(n^2)，其中 n 是数组的长度。
 * 
 * 
 */
public class InsertionSort {

    public static void main(String[] args) {
        // 创建包含大量随机整数的数组
        Integer[] array = GenerateRandom.tailAscOrder(1, 100000, 20000);

        // 测试基本冒泡排序方法的时间
        long startTime = System.currentTimeMillis();
        insertionSortBasicFor(array.clone()); // 为了避免修改原始数组，这里使用了克隆数组
        long endTime = System.currentTimeMillis();
        long basicTime = endTime - startTime;
        System.out.println("基本插入排序耗时: " + basicTime + " 毫秒");

    }

    // 使用 for 循环实现插入排序
    public static Integer[] insertionSortBasicFor(Integer[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i]; // 当前要插入的元素
            int j;
            // 将比 key 大的元素向右移动一个位置
            for (j = i - 1; j >= 0 && array[j] > key; j--) {
                swap(array, j, j + 1); // 使用 swap 方法交换元素
            }
            array[j + 1] = key; // 插入 key 到适当位置
        }
        return array; // 返回排序后的数组
    }

    // 使用 while 循环实现插入排序
    public static Integer[] insertionSortBasicWhile(Integer[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            int key = array[i]; // 当前要插入的元素
            // 使用 while 循环寻找插入位置，并交换元素
            while (j >= 0 && array[j] > key) {
                swap(array, j, j + 1);
                j--;
            }
            array[j + 1] = key; // 插入 key 到适当位置
        }
        return array; // 返回排序后的数组
    }

    // 交换数组中指定两个位置的元素
    private static void swap(Integer[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // 打印数组元素
    private static void printArray(Integer[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

}
