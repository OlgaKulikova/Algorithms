package UnionFind;

import java.util.HashSet;
import java.util.Set;

public class PathCompressionWeightedQuickUnion {
    private int[] id;
    private int[] size;
    Set<Integer> roots = new HashSet<>();


    public PathCompressionWeightedQuickUnion(int N) {
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    //var.1 with loop while
    private int root (int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    //var.2 with recursion
   /* private int root(int i) {
        if (i != id[i]) {
            id[i] = root(id[i]);
        }
        return id[i];
    }*/

    public boolean find(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (size[i] < size[j]) {
            id[i] = j;
            size[j] += size[i];
        } else  {
            id[j] = i;
            size[i] += size[j];
        }
    }

    public int countRoot() {
        for (int i : id) {
            roots.add(root(i));
        }
        return roots.size();
    }
}
