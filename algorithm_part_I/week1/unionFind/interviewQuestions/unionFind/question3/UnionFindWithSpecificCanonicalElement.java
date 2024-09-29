package algorithm_part_I.week1.unionFind.interviewQuestions.unionFind.question3;

public class UnionFindWithSpecificCanonicalElement {
    private int[] id;
    private int[] size;
    private int n;
    private int[] maximum;

    public UnionFindWithSpecificCanonicalElement(int[] id, int n) {
        this.id = id;
        this.n = n;
        this.size = new int[n];
        this.maximum = new int[n];

        for(int i = 0; i < n; this.maximum[i] = i++) {
            id[i] = i;
            this.size[i] = 1;
        }

    }

    public int root(int i) {
        while(i != this.id[i]) {
            this.id[i] = this.id[this.id[i]];
            i = this.id[i];
        }

        return i;
    }

    public boolean connected(int p, int q) {
        return this.root(p) == this.root(q);
    }

    public void union(int p, int q) {
        int i = this.root(p);
        int j = this.root(q);
        if (i != j) {
            int[] var10000;
            if (this.size[i] < this.size[j]) {
                this.id[i] = j;
                var10000 = this.size;
                var10000[j] += this.size[i];
                if (this.maximum[i] > this.maximum[j]) {
                    this.maximum[j] = this.maximum[i];
                }
            } else {
                this.id[j] = i;
                var10000 = this.size;
                var10000[i] += this.size[j];
                if (this.maximum[j] > this.maximum[i]) {
                    this.maximum[i] = this.maximum[j];
                }
            }

        }
    }

    public int find(int x) {
        x = this.root(x);
        return this.maximum[x];
    }

    public static void main(String[] args) {
        int n = 10;
        int[] id = new int[n];
        UnionFindWithSpecificCanonicalElement uf = new UnionFindWithSpecificCanonicalElement(id, 10);
        uf.union(2, 1);
        uf.union(2, 0);
        uf.union(5, 0);
        uf.union(1, 8);
        uf.union(9, 1);
        uf.union(7, 3);
        uf.union(7, 4);
        uf.union(6, 4);
        System.out.println(uf.find(0));
    }
}