package UnionFind;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WeightedQuickUnionTest {

    @Test
    public void testOnePair() {
        WeightedQuickUnion weightedQuickUnion = new WeightedQuickUnion(10);
        assertFalse(weightedQuickUnion.find(3, 6));
        weightedQuickUnion.union(3, 6);
        assertTrue(weightedQuickUnion.find(3, 6));
    }

    @Test
    public void testAllPairs() {
        WeightedQuickUnion weightedQuickUnion = new WeightedQuickUnion(10);
        assertFalse(weightedQuickUnion.find(3, 4));
        weightedQuickUnion.union(3, 4);
        assertFalse(weightedQuickUnion.find(4, 9));
        weightedQuickUnion.union(4, 9);
        assertFalse(weightedQuickUnion.find(8, 0));
        weightedQuickUnion.union(8, 0);
        assertFalse(weightedQuickUnion.find(2, 3));
        weightedQuickUnion.union(2, 3);
        assertFalse(weightedQuickUnion.find(5, 6));
        weightedQuickUnion.union(5, 6);
        assertFalse(weightedQuickUnion.find(5, 9));
        weightedQuickUnion.union(5, 9);
        assertFalse(weightedQuickUnion.find(7, 3));
        weightedQuickUnion.union(7, 3);
        assertFalse(weightedQuickUnion.find(4, 8));
        weightedQuickUnion.union(4, 8);
        assertFalse(weightedQuickUnion.find(6, 1));
        weightedQuickUnion.union(6, 1);

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 10; j++) {
                assertTrue(weightedQuickUnion.find(i, j));
            }
        }
    }
}