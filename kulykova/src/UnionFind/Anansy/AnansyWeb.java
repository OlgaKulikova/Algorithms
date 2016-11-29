package UnionFind.Anansy;

import UnionFind.PathCompressionWeightedQuickUnion;

import java.util.*;

/*
������� ������

����������� �������: 1.0 �������
����������� ������: 64 ��

������-��������� XIII ����� ��������� ������ �� ������������ �������, �������� ��� ������ � ��� �������.
������� ������� �� N �����, ��������� �� ������� ��������� ������. ����� ��������, ��� ��� ���� ����������� ������
�������, ���� �� ������ ���� �� ������� ����� ��������� �� ����� �������. ������-��������� ��� �����, ����� ���� �
� ����� ������� �� ����� �����, � ������ ����� ������, �� ������� �������� ����� ����������� ������� ����� �������
�� ��� ��������.

�������� ������
� ������ ������ ����� ������ �������� ����� N � M � ���������� ����� � ����� � �������
(2 ? N ? 100000; 1 ? M ? 100000). � ������ �� ��������� M ����� ����� ������ �������� ��� ��������� ����� �
������ �����, ������� ��������� ��������� ����. ���� ������������ ������� �� 1 �� N, ���� ������������ �������
�� 1 �� M � ��� �������, � ������� ��� �����������. ����� �������� ����� Q � ���������� �����, ������� ����������
������� ������-��������� (1 ? Q ? M). � ��������� ������ �������� ������ ���� ����� � ��������� �����, ����������
���� �� ����� ��������.

���������
�������� ����� ������ Q ����� � ����� ��������, �� ������� ����� �������� ������� ������ ����� ������� ������ ����.

�������
�������� ������
4 4
1 2
2 3
1 3
3 4
3
2 4 3
���������
1 2 3

�������� ������
3 1
1 2
1
1
���������
3
 */

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
                if (!quickUnion.connected(p, q)) {
                    quickUnion.union(p, q);
                }
            }
        }

        System.out.print(quickUnion.countRoot() + " ");
    }
}
