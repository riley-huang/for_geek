class Homework6_1 {
    public int climbStairs(int n) {
        int dp0 = 0;
        int dp1 = 0;
        int dp2 = 1;//初始状态设置
        for(int i = 1; i < n+1; i++){
            dp0 = dp1;
            dp1 = dp2;
            //因为每次只能爬一级或两级，所以状态方程为f(x) = f(x-1) + f(x-2)
            dp2 = dp0 + dp1;//因为每级的方案只跟前两级的方案和有关，
                            //所以可以用滚动数组更新来降低空间复杂度
        }
        return dp2;
    }
}