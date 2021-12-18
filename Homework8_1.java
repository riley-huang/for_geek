class Homework8_1 {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] res = new int[2];
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n);
        for (int[] edge: edges){
            if (uf.connected(edge[0], edge[1])) res = edge;
            else uf.union(edge[0], edge[1]);
        }
        return res;
    }

    public class WeightedQuickUnionUF {
        private int[] id; // 父链接数组
        private int[] sz; // （由触点索引的）各个根节点所对应的分量的大小

        public WeightedQuickUnionUF(int N) {
            // 初始化分量id数组
            id = new int[N + 1];
            for (int i = 0; i < N; i++) id[i] = i;
            sz = new int[N + 1];
            Arrays.fill(sz, 1);
        }

        public boolean connected(int p, int q){
            return find(p) == find(q);
        }

        public int find(int p) {
            // 跟随链接找到根节点
            while (p != id[p]) {
                id[p] = id[id[p]]; // 加上这一行就变为带权路径压缩快速合并并查集，路径上的所有节点指向根节点
                p = id[p];
            }
            return p;
        }

        public void union(int p, int q){
            // 将p和q的根节点统一
            int i = find(p);
            int j = find(q);
            // 如果p和q已经再相同的分量之中则不需要采取任何行动
            if (i == j) return;
            // 将效数的根节点链接到大树的根节点
            if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
            else               { id[j] = i; sz[i] += sz[j]; }
        }
    }
}