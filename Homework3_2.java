class Homework3_2 {
    List<List<Integer>> ans;
    Set<List<Integer>> set;
    List<Integer> sub;
    boolean[] bool;
    int n;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        sub = new ArrayList<>();//存放每次的子集
        set = new HashSet<>();
        n = nums.length;
        bool = new boolean[n];
        recur(nums, 0);
        for(List<Integer> list : set){
            ans.add(list);
        }
        return ans;
    }
    void recur(int[] nums, int pos){
        if(pos == n){
            set.add(new ArrayList(sub));//将结果每次都存入集合中就可以自动排除重复的子集
            return;
        }
        for(int i = 0; i < n; i++){
            if(!bool[i]){
                sub.add(nums[i]);
                bool[i] = true;//表示当前位置上的元素已被添加了
                recur(nums, pos+1);
                bool[i] = false;//还原现场
                sub.remove(sub.size()-1);
            }
        }
    }
}