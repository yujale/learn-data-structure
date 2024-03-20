package algorithm.leetCode.sort;

/**
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 * 
 * 
 * 示例 1：
 * 
 * 输入：nums = [1,2,3,1]
 * 输出：true
 * 示例 2：
 * 
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 示例 3：
 * 
 * 输入：nums = [1,1,1,3,3,4,3,2,4,2]
 * 输出：true
 * 
 * 
 * 提示：
 * 
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */

 import java.util.Arrays;
public class _217_存在重复元素 {

    public boolean containsDuplicate(int[] nums) {

        // 使用插入排序的思想对数组进行排序
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;
            // 将大于 key 的元素后移
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }

        // 不理解上述排序和 sort 排序的区别，遇到较大的数据量时间超时
        Arrays.sort(nums);

        // 检查相邻元素是否相等
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

}