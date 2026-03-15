class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];

            int tempMax = Math.max(cur, Math.max(max * cur, min * cur));
            int tempMin = Math.min(cur, Math.min(max * cur, min * cur));

            max = tempMax;
            min = tempMin;

            ans = Math.max(ans, max);
        }

        return ans;
    }
}
