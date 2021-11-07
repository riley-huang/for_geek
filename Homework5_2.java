class Homework5_2 {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1_000_000_000;//题目提示：1 <= piles[i] <= 10^9
        while (left < right) {
            int mid = (left + right) / 2;
            if (!ifFinished(piles, h, mid))//判断用这个速度吃能不能吃完全部香蕉
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
    public boolean ifFinished(int[] piles, int h, int K) {
        int hour = 0;
        for (int p : piles){
            hour += (p-1) / K + 1;//累加每次吃掉香蕉的时间
        }
        return hour <= h;
    }
}