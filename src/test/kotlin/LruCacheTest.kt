import org.junit.jupiter.api.Test
import kotlin.test.assertNull

class LruCacheTest {
    @Test
    fun testGetNonExisting() {
        val cache = LruCache<Int, Int>(1)
        assertNull(cache.get(1))
    }

    @Test
    fun testPutAndGet() {
        val cache = LruCache<Int, Int>(1)
        cache.put(1, 10)
        assert(cache.capacity == 1)
        assert(cache.get(1) == 10)
    }

    @Test
    fun testPutAndGetExceedCapacity() {
        val cache = LruCache<Int, Int>(1)
        cache.put(1, 10)
        cache.put(2, 20)
        assert(cache.capacity == 1)
        assertNull(cache.get(1))
        assert(cache.get(2) == 20)
    }
}