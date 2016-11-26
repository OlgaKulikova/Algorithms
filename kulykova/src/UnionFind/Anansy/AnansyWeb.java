package UnionFind.Anansy;

import UnionFind.PathCompressionWeightedQuickUnion;

import java.util.*;

public class AnansyWeb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        List<Pair> pairs = new ArrayList<>();
        int p;
        int q;
        for (int i = 0; i < M; i++) {
            p = (scanner.nextInt() - 1);
            q = (scanner.nextInt() - 1);
            Pair pair = new Pair(p, q);
            pairs.add(pair);
        }

        int Q = scanner.nextInt();
        Set<Integer> threads = new HashSet<>();
        int thread;
        for (int i = 0; i < Q; i++) {
            thread = (scanner.nextInt() - 1);
            threads.add(thread);
            createWeb(N, pairs, threads);
        }
    }

    private static void createWeb(int N, List<Pair> pairs, Set<Integer> threads) {
        PathCompressionWeightedQuickUnion quickUnion = new PathCompressionWeightedQuickUnion(N);
        int p;
        int q;

        for (int j = 0; j < pairs.size(); j++) {
            if (!threads.contains(j)) {
                Pair pair = pairs.get(j);
                p = pair.getP();
                q = pair.getQ();
                if (!quickUnion.find(p, q)) {
                    quickUnion.union(p, q);
                }
            }
        }

        System.out.println(quickUnion.countRoot());
    }
}
