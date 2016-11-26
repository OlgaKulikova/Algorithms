package UnionFind;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QuickUnionTest {

    @Test
    public void testOnePair() {
        QuickUnion quickUnion = new QuickUnion(10);
        assertFalse(quickUnion.find(3, 6));
        quickUnion.union(3, 6);
        assertTrue(quickUnion.find(3, 6));
    }

    @Test
    public void testAllPairs() {
        QuickUnion quickUnion = new QuickUnion(10);
        assertFalse(quickUnion.find(3, 4));
        quickUnion.union(3, 4);
        assertFalse(quickUnion.find(4, 9));
        quickUnion.union(4, 9);
        assertFalse(quickUnion.find(8, 0));
        quickUnion.union(8, 0);
        assertFalse(quickUnion.find(2, 3));
        quickUnion.union(2, 3);
        assertFalse(quickUnion.find(5, 6));
        quickUnion.union(5, 6);
        assertFalse(quickUnion.find(5, 9));
        quickUnion.union(5, 9);
        assertFalse(quickUnion.find(7, 3));
        quickUnion.union(7, 3);
        assertFalse(quickUnion.find(4, 8));
        quickUnion.union(4, 8);
        assertFalse(quickUnion.find(6, 1));
        quickUnion.union(6, 1);

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 10; j++) {
                assertTrue(quickUnion.find(i, j));
            }
        }
    }
}