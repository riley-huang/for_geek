class Homework2_2 {
    public int findShortestSubArray(int[] nums) {
        int most = 1;//度最小值为1
        Map<Integer, int[]> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                //第一个i是第一次出现该元素的index，第二个i是最后一次出现该元素的index（后续在else语句中会更新）
                map.put(nums[i], new int[]{1, i, i});
            }else{
                map.get(nums[i])[2] = i;
                if(++map.get(nums[i])[0] > most){
                    most = map.get(nums[i])[0];//更新度的最大值
                }
            }
        }
        int ans = nums.length;//最终答案不会超过总的数组的长度（ans初始值的原因），后续判断时取最小的值返回结果
        for(int[] value : map.values()){
            if(value[0] == most){
                ans = Math.min(ans, value[2] - value[1]);
            }
        }
        return ans + 1;
    }
}