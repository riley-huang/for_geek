class Homework5_1 {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for(int weight : weights){
            left = Math.max(weight, left);//最低运载能力起码要大于等于最大的包裹重量
            right += weight;//运载能力最大不超过全部包裹之和
        }
        while(left < right){
            int mid = (left + right) / 2;//先取一个中间值做当前轮的运载能力
            int need = 1;//最快一天就可以搬完
            int cur = 0;//初始装载的包裹为0
            for (int weight : weights) {//遍历所有包裹的重量
                if (cur + weight > mid) {//当当前装的重量超过运载能力时
                    need++;//说明得把当前的包裹放到下一天来装
                    cur = 0;//当更新完需要运送的天数后就可以把重量清零了
                }
                cur += weight;//新一天的运载重量
            }
            if(need <= days){//如果比预期时间运的快
                right = mid;//就把运载能力向下调整
            }else{
                left = mid + 1;//不然就把运载能力提升
            }
        }
        return right;
    }
}