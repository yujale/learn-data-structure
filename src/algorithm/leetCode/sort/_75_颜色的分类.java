package algorithm.leetCode.sort;

/**
 * 颜色分类
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，
 * 原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 * 
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * 
 * 
 * 提示：
 * 
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 * 
 */
public class _75_颜色的分类 {

    public static void main(String[] args) {
        // 测试示例
        int[] nums = { 2, 0, 2, 1, 1, 0 };
        sortColors(nums);
        // 打印排序后的数组
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * 颜色分类方法
     * 
     * @param nums 待排序的数组
     */
    public static void sortColors(int[] nums) {
        // 外层循环，遍历整个数组
        for (int i = 0; i < nums.length; i++) {
            // 内层循环，从当前元素的下一个元素开始遍历
            for (int j = i + 1; j < nums.length; j++) {
                // 如果当前元素大于下一个元素，交换它们的位置，将较小的元素放在前面
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

}
