package UnionFind;

import org.junit.Test;

import static org.junit.Assert.*;

public class PathCompressionWeightedQuickUnionTest {

    @Test
    public void testOnePair() {
        PathCompressionWeightedQuickUnion pathComWQU = new PathCompressionWeightedQuickUnion(10);
        assertFalse(pathComWQU.find(3, 6));
        pathComWQU.union(3, 6);
        assertTrue(pathComWQU.find(3, 6));
    }

    @Test
    public void testAllPairs() {
        PathCompressionWeightedQuickUnion pathComWQU = new PathCompressionWeightedQuickUnion(10);
        assertFalse(pathComWQU.find(3, 4));
        pathComWQU.union(3, 4);
        assertFalse(pathComWQU.find(4, 9));
        pathComWQU.union(4, 9);
        assertFalse(pathComWQU.find(8, 0));
        pathComWQU.union(8, 0);
        assertFalse(pathComWQU.find(2, 3));
        pathComWQU.union(2, 3);
        assertFalse(pathComWQU.find(5, 6));
        pathComWQU.union(5, 6);
        assertFalse(pathComWQU.find(5, 9));
        pathComWQU.union(5, 9);
        assertFalse(pathComWQU.find(7, 3));
        pathComWQU.union(7, 3);
        assertFalse(pathComWQU.find(4, 8));
        pathComWQU.union(4, 8);
        assertFalse(pathComWQU.find(6, 1));
        pathComWQU.union(6, 1);

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 10; j++) {
                assertTrue(pathComWQU.find(i, j));
            }
        }

        assertEquals(1, pathComWQU.countRoot());
    }

    @Test
    public void testCountRoot() {
        PathCompressionWeightedQuickUnion pathComWQU = new PathCompressionWeightedQuickUnion(10);
        assertFalse(pathComWQU.find(3, 4));
        pathComWQU.union(3, 4);
        assertFalse(pathComWQU.find(4, 9));
        pathComWQU.union(4, 9);
        assertFalse(pathComWQU.find(8, 0));
        pathComWQU.union(8, 0);
        assertFalse(pathComWQU.find(2, 3));
        pathComWQU.union(2, 3);
        assertFalse(pathComWQU.find(5, 6));
        pathComWQU.union(5, 6);
        assertFalse(pathComWQU.find(5, 9));
        pathComWQU.union(5, 9);
        assertFalse(pathComWQU.find(7, 3));
        pathComWQU.union(7, 3);

        assertEquals(3, pathComWQU.countRoot());
    }
}