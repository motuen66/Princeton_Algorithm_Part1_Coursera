package algorithm_part_I.week1.unionFind.interviewQuestions.unionFind.question1;

public class SocialNetworkConnectivity {
    private static int n;
    private int[] id;
    private int[] size;
    private Log[] logs;
    private int numOfTrees;

    public SocialNetworkConnectivity(int n, Log[] logs) {
        SocialNetworkConnectivity.n = n;
        this.logs = logs;
        this.id = new int[n];
        this.size = new int[n];
        this.numOfTrees = n;

        for(int i = 0; i < n; ++i) {
            this.id[i] = i;
            this.size[i] = 1;
        }

    }

    public boolean connected(int p, int q) {
        return this.root(p) == this.root(q);
    }

    public int root(int i) {
        while(i != this.id[i]) {
            this.id[i] = this.id[this.id[i]];
            i = this.id[i];
        }

        return i;
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
            } else {
                this.id[j] = i;
                var10000 = this.size;
                var10000[i] += this.size[j];
            }

        }
    }

    public int theEarliestTime() {
        Log[] var1 = this.logs;
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            Log log = var1[var3];
            if (!this.connected(log.p, log.q)) {
                this.union(log.p, log.q);
                --this.numOfTrees;
            }

            if (this.numOfTrees == 1) {
                return log.timestamp;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Log[] logs = new Log[]{new Log(0, 1, 1), new Log(2, 3, 2), new Log(4, 5, 3), new Log(6, 7, 4), new Log(8, 9, 5), new Log(10, 11, 6), new Log(12, 13, 7), new Log(1, 2, 8), new Log(3, 4, 10), new Log(5, 6, 12), new Log(7, 8, 14), new Log(9, 10, 16), new Log(11, 12, 18), new Log(0, 14, 20), new Log(13, 14, 22), new Log(2, 14, 25), new Log(7, 10, 26), new Log(4, 9, 28), new Log(8, 11, 30), new Log(3, 13, 32)};
        SocialNetworkConnectivity sncTest = new SocialNetworkConnectivity(15, logs);
        System.out.println("The earliest time that all user been connected: " + sncTest.theEarliestTime());
    }
}