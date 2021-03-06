package UnionFind;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuickFindTest {

    @Test
    public void testOnePair() {
        QuickFind quickFind = new QuickFind(10);
        assertFalse(quickFind.connected(3, 6));
        quickFind.union(3, 6);
        assertTrue(quickFind.connected(3, 6));
    }

    @Test
    public void testAllPairs() {
        QuickFind quickFind = new QuickFind(10);
        assertFalse(quickFind.connected(3, 4));
        quickFind.union(3, 4);
        assertFalse(quickFind.connected(4, 9));
        quickFind.union(4, 9);
        assertFalse(quickFind.connected(8, 0));
        quickFind.union(8, 0);
        assertFalse(quickFind.connected(2, 3));
        quickFind.union(2, 3);
        assertFalse(quickFind.connected(5, 6));
        quickFind.union(5, 6);
        assertFalse(quickFind.connected(5, 9));
        quickFind.union(5, 9);
        assertFalse(quickFind.connected(7, 3));
        quickFind.union(7, 3);
        assertFalse(quickFind.connected(4, 8));
        quickFind.union(4, 8);
        assertFalse(quickFind.connected(6, 1));
        quickFind.union(6, 1);

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 10; j++) {
                assertTrue(quickFind.connected(i, j));
            }
        }
    }
}