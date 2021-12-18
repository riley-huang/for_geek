class Homework10_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length < 2) return nums;
        LinkedList<Integer> queue = new LinkedList();//使用双向队列，保存当前窗口最大值下标，保证队列中数组位置的数值从大到小排序
        int[] result = new int[nums.length-k+1];
        for(int i = 0;i < nums.length;i++){
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){//维持从大到小，如果前面数小则需要依次弹出，直到满足要求
                queue.pollLast();
            }
            //添加当前值对应的数组下标
            queue.addLast(i);
            //判断当前队列中队首的值是否有效
            if(queue.peek() <= i-k){
                queue.poll();   
            } 
            //当窗口长度为k时，保存当前窗口中最大值
            if(i+1 >= k){
                result[i+1-k] = nums[queue.peek()];
            }
        }
        return result;
    }
}
