import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[] { -1, 0, 3, 5, 9, 12 };
        System.out.println(search(nums, 9));
        System.out.println(search(nums, 2));
    }

    public static int defaultBinarySearch(int[] nums, int target) {
        return Arrays.binarySearch(nums, target);
    }

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}