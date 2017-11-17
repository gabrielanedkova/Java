package bg.uni.sofia.fmi.mjt.cache;

import static org.junit.Assert.*;
import java.time.LocalDateTime;
import org.junit.Test;

public class MemCacheTest {

    @Test
    public void addElementWhenCacheIsFull() {
        MemCache<Integer, String> test = new MemCache<Integer, String>(0);
        try {
            test.set(1, "test", null);
            fail();
        } catch (CapacityExceededException e) {
            assertEquals(e.getMessage(), "The cache is full!!!");
        }
    }

  

    @Test
    public void addsAndRemovesCache() throws CapacityExceededException {
        MemCache<Integer, String> test = new MemCache<Integer, String>();
        final int key = 12;
        test.set(key, "test", null);
        test.remove(key);
        assertNull(test.get(key));

    }

    @Test
    public void updatesExistingCahce() throws CapacityExceededException {
        MemCache<Integer, String> test = new MemCache<Integer, String>();
        final int key = 12;
        test.set(key, "test", null);
        String expectedOUtput = "updatedTest";
        test.set(key, expectedOUtput, null);
        assertEquals(test.get(key), expectedOUtput);

    }

    @Test
    public void getShouldReturnNullWhenCalledWithExpiredElement()
        throws CapacityExceededException {
        MemCache<Integer, String> test = new MemCache<Integer, String>();
        test.set(1, "test", LocalDateTime.now().minusNanos(1));
        assertNull(test.get(1));

    }

    @Test
    public void hitRatioWithNoHits() {
        MemCache<Integer, String> test = new MemCache<Integer, String>();
        double zeroHitRate = 0.0;
        assertEquals(test.getHitRate(), zeroHitRate, 0);
    }
    
    @Test
    public void sizeAndHitRateShouldBeZeroAfterClear() throws CapacityExceededException {
        MemCache<Integer, String> test = new MemCache<Integer, String>();
        test.set(1, "test1", LocalDateTime.now());
        test.set(2, "test2", LocalDateTime.now());
        test.clear();
        final long actualSize = test.size();
        final long expectedSize = 0;
        final double expectedRatio = 0.0;
        final double actualRatio = test.getHitRate();
        assertEquals(actualSize, expectedSize);
        assertEquals(actualRatio, expectedRatio, 0);
        
    }
    
    @Test
    public void removeTest() throws CapacityExceededException
    {
        MemCache<Integer, String> test = new MemCache<Integer, String>();
        test.set(1, "test1", LocalDateTime.now());
        assertFalse(test.remove(2));
        assertTrue(test.remove(1));
    }
    
    @Test
    public void getExpirationTest() throws CapacityExceededException
    {
        MemCache<Integer, String> test = new MemCache<Integer, String>();
        LocalDateTime expectedDate = LocalDateTime.now();
        test.set(1, "test1", expectedDate);
        test.set(2, "test1", null);
        LocalDateTime actualDate = test.getExpiration(1);
        assertEquals(expectedDate, actualDate);
        assertNull(test.getExpiration(2));
    }
    
    @Test
    public void getRateTest() throws CapacityExceededException
    {
        MemCache<Integer, String> test = new MemCache<Integer, String>();
        LocalDateTime expectedDate = LocalDateTime.now();
        test.set(1, "test1", expectedDate);
        test.set(2, "test1", expectedDate);
        final int hitsExpected = 2;
        final int allAttempts = 3;
        final double expectedRate = hitsExpected / allAttempts;
        test.get(1);
        test.get(2);
        final int notInCache = 3;
        test.get(notInCache);
        final double actualRate = test.getHitRate();
        assertEquals(expectedRate, actualRate, 0);
    }
    
    @Test
    public void setTest() throws CapacityExceededException {
        MemCache<Integer, String> test = new MemCache<Integer, String>(1);
        test.set(1, "test1", LocalDateTime.now().minusMinutes(1));
        test.set(2, "test2", LocalDateTime.now());
        final int shouldBeSet = 2;
        assertEquals("test2", test.get(shouldBeSet));
    }
}
