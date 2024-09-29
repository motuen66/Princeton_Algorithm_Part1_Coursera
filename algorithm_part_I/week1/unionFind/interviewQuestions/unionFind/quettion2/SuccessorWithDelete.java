package algorithm_part_I.week1.unionFind.interviewQuestions.unionFind.quettion2;

public class SuccessorWithDelete {
    private int[] id;
    private int[] size;
    private int n;
    private int[] maximum;

    public SuccessorWithDelete(int[] id, int n) {
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

    public int union(int p, int q) {
        int i = this.root(p);
        int j = this.root(q);
        int[] var10000;
        if (this.size[i] < this.size[j]) {
            this.id[i] = j;
            var10000 = this.size;
            var10000[j] += this.size[i];
            if (this.maximum[i] > this.maximum[j]) {
                this.maximum[j] = this.maximum[i];
            }

            return this.maximum[j];
        } else {
            this.id[j] = i;
            var10000 = this.size;
            var10000[i] += this.size[j];
            if (this.maximum[j] > this.maximum[i]) {
                this.maximum[i] = this.maximum[j];
            }

            return this.maximum[i];
        }
    }

    public int delete(int p) {
        return p == this.id.length - 1 ? 9 : this.union(p, p + 1);
    }

    public static void main(String[] args) {
        int n = 10;
        int[] id = new int[n];
        SuccessorWithDelete swd = new SuccessorWithDelete(id, n);
        int i = swd.delete(3);
        System.out.println(i);
        i = swd.delete(7);
        System.out.println(i);
        i = swd.delete(6);
        System.out.println(i);
        i = swd.delete(9);
        System.out.println(i);
    }
}
