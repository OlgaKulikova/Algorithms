package UnionFind.Anansy;

import UnionFind.PathCompressionWeightedQuickUnion;

import java.util.*;

/*
Паутина Ананси

Ограничение времени: 1.0 секунды
Ограничение памяти: 64 МБ

Усатый-Полосатый XIII решил отомстить Ананси за освобождение бабочек, разрушив дом Ананси — его паутину.
Паутина состоит из N узлов, некоторые из которых соединены нитями. Будем говорить, что два узла принадлежат одному
кусочку, если от одного узла до другого можно добраться по нитям паутины. Усатый-Полосатый уже решил, какие нити и
в каком порядке он будет рвать, и теперь хочет узнать, на сколько кусочков будет распадаться паутина после каждого
из его действий.

Исходные данные
В первой строке через пробел записаны числа N и M — количество узлов и нитей в паутине
(2 ? N ? 100000; 1 ? M ? 100000). В каждой из следующих M строк через пробел записаны два различных числа —
номера узлов, которые соединяет очередная нить. Узлы занумерованы числами от 1 до N, нити занумерованы числами
от 1 до M в том порядке, в котором они перечислены. Далее записано число Q — количество нитей, которое собирается
порвать Усатый-Полосатый (1 ? Q ? M). В последней строке записаны номера этих нитей — различные числа, отделяемые
друг от друга пробелом.

Результат
Выведите через пробел Q чисел — число кусочков, из которых будет состоять паутина Ананси после каждого обрыва нити.

Примеры
исходные данные
4 4
1 2
2 3
1 3
3 4
3
2 4 3
результат
1 2 3

исходные данные
3 1
1 2
1
1
результат
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
