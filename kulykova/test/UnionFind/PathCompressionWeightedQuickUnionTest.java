package UnionFind;

import org.junit.Test;

import static org.junit.Assert.*;

public class PathCompressionWeightedQuickUnionTest {

    @Test
    public void testOnePair() {
        PathCompressionWeightedQuickUnion pathComWQU = new PathCompressionWeightedQuickUnion(10);
        assertFalse(pathComWQU.connected(3, 6));
        pathComWQU.union(3, 6);
        assertTrue(pathComWQU.connected(3, 6));
    }

    @Test
    public void testAllPairs() {
        PathCompressionWeightedQuickUnion pathComWQU = new PathCompressionWeightedQuickUnion(10);
        assertFalse(pathComWQU.connected(3, 4));
        pathComWQU.union(3, 4);
        assertFalse(pathComWQU.connected(4, 9));
        pathComWQU.union(4, 9);
        assertFalse(pathComWQU.connected(8, 0));
        pathComWQU.union(8, 0);
        assertFalse(pathComWQU.connected(2, 3));
        pathComWQU.union(2, 3);
        assertFalse(pathComWQU.connected(5, 6));
        pathComWQU.union(5, 6);
        assertFalse(pathComWQU.connected(5, 9));
        pathComWQU.union(5, 9);
        assertFalse(pathComWQU.connected(7, 3));
        pathComWQU.union(7, 3);
        assertFalse(pathComWQU.connected(4, 8));
        pathComWQU.union(4, 8);
        assertFalse(pathComWQU.connected(6, 1));
        pathComWQU.union(6, 1);

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 10; j++) {
                assertTrue(pathComWQU.connected(i, j));
            }
        }

        assertEquals(1, pathComWQU.countRoot());
    }

    @Test
    public void testCountRoot() {
        PathCompressionWeightedQuickUnion pathComWQU = new PathCompressionWeightedQuickUnion(10);
        assertFalse(pathComWQU.connected(3, 4));
        pathComWQU.union(3, 4);
        assertFalse(pathComWQU.connected(4, 9));
        pathComWQU.union(4, 9);
        assertFalse(pathComWQU.connected(8, 0));
        pathComWQU.union(8, 0);
        assertFalse(pathComWQU.connected(2, 3));
        pathComWQU.union(2, 3);
        assertFalse(pathComWQU.connected(5, 6));
        pathComWQU.union(5, 6);
        assertFalse(pathComWQU.connected(5, 9));
        pathComWQU.union(5, 9);
        assertFalse(pathComWQU.connected(7, 3));
        pathComWQU.union(7, 3);

        assertEquals(3, pathComWQU.countRoot());
    }
}