class Homework2_2 {
    public int findShortestSubArray(int[] nums) {
        int most = 1;
        Map<Integer, int[]> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new int[]{1, i, i});
            }else{
                map.get(nums[i])[2] = i;
                if(++map.get(nums[i])[0] > most){
                    most = map.get(nums[i])[0];
                }
            }
        }
        int ans = nums.length;
        for(Map.Entry<Integer, int[]> entry : map.entrySet()){
            if(entry.getValue()[0] == most){
                ans = Math.min(ans, entry.getValue()[2] - entry.getValue()[1]);
            }
        }
        return ans + 1;
    }
}