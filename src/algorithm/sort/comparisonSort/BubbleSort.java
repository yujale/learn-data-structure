package algorithm.sort.comparisonSort;

import algorithm.sort.utils.GenerateRandom;

/**
 * 冒泡排序
 * <p>
 * 基本思想：
 * <p>
 * - 冒泡排序是重复地待排序的元素序列，比较相邻的元素，并依次交换顺序，使得每一轮遍历都能将最大或者最小的元素移动到正确的位置上
 * - 每次遍历都会使得未排序部分的最大（或最小）元素“冒泡”到最末端。
 * <p>
 * 时间复杂度：
 * <p>
 * - 最坏情况时间复杂度 O(n^2)，其中 n 是数组的长度。
 * - 最好情况下的时间复杂度为 O(n)，当数组已经是有序的时候。
 * <p>
 * 空间复杂度：
 * <p>
 * - 冒泡排序是一种原地排序算法，它只需要常数级别的额外空间，空间复杂度为 O(1)。
 */
public class BubbleSort {

    public static void main(String[] args) {
        // 创建包含大量随机整数的数组
        Integer[] array = GenerateRandom.random(100000, 1, 9999);

        // 测试基本冒泡排序方法的时间
        long startTime = System.currentTimeMillis();
        bubbleSortBasic(array.clone()); // 为了避免修改原始数组，这里使用了克隆数组
        long endTime = System.currentTimeMillis();
        long basicTime = endTime - startTime;
        System.out.println("基本冒泡排序耗时: " + basicTime + " 毫秒");

        // 测试优化冒泡排序方法的时间
        startTime = System.currentTimeMillis();
        bubbleSortOptimized(array.clone()); // 同样克隆数组以保持原始数据不变
        endTime = System.currentTimeMillis();
        long optimizedTime = endTime - startTime;
        System.out.println("优化冒泡排序耗时: " + optimizedTime + " 毫秒");

        // 测试优化部分冒泡排序方法的时间
        startTime = System.currentTimeMillis();
        bubbleSortOptimizedPart(array.clone());
        endTime = System.currentTimeMillis();
        long optimizedPartTime = endTime - startTime;
        System.out.println("优化部分冒泡排序耗时: " + optimizedPartTime + " 毫秒");
    }

    // 基本冒泡排序方法
    public static Integer[] bubbleSortBasic(Integer[] array) {
        for (int end = array.length - 1; end > 0; end--) {
            for (int begin = 1; begin <= end; begin++) {
                // 如果当前元素小于前一个元素，则交换它们的位置
                if (array[begin] < array[begin - 1]) {
                    swap(array, begin, begin - 1);
                }
            }
        }
        return array;
    }

    // 优化版冒泡排序方法
    public static Integer[] bubbleSortOptimized(Integer[] array) {
        for (int end = array.length - 1; end > 0; end--) {
            boolean sorted = true; // 标志位，用于记录是否发生了交换操作
            for (int begin = 1; begin <= end; begin++) {
                if (array[begin] < array[begin - 1]) {
                    // 如果当前元素小于前一个元素，则交换它们的位置
                    swap(array, begin, begin - 1);
                    sorted = false; // 发生了交换，将标志位置为 false
                }
            }
            if (sorted) {
                break; // 如果本轮遍历没有发生交换，则数组已经有序，直接退出循环
            }
        }
        return array;
    }

    // 局部有序优化
    public static Integer[] bubbleSortOptimizedPart(Integer[] array) {
        int n = array.length;

        // 外层循环控制已排序部分的边界
        for (int end = n - 1; end > 0; ) {
            int lastSortedIndex = 0; // 用于记录上一轮已排序部分的边界位置

            // 内层循环遍历未排序部分的元素
            for (int current = 1; current <= end; current++) {
                // 如果当前元素小于前一个元素，则交换它们的位置
                if (array[current] < array[current - 1]) {
                    swap(array, current, current - 1); // 执行元素交换
                    lastSortedIndex = current; // 更新已排序部分的边界位置
                }
            }
            end = lastSortedIndex - 1; // 更新外层循环的结束位置
        }

        return array;
    }

    // 交换数组中指定两个位置的元素
    private static void swap(Integer[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // 打印数组元素
    private static void printArray(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
