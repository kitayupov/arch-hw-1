import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.math.abs

private const val epsilon = 1e-7

class FunctionsKtTest {

    @Test
    fun `should return no roots`() {
        val result = solve(a = 1.0, b = 0.0, c = 1.0, e = epsilon)
        assertEquals(result.size, 0)
    }

    @Test
    fun `should return two different roots`() {
        val result = solve(a = 1.0, b = 0.0, c = -1.0, e = epsilon)
        assertEquals(isRootEquals(result[0], -1.0), true)
        assertEquals(isRootEquals(result[1], 1.0), true)
    }

    @Test
    fun `should return two identical root`() {
        val result = solve(a = 1.0, b = 2.0, c = 1.0, e = epsilon)
        assertEquals(isRootEquals(result[0], -1.0), true)
        assertEquals(isRootEquals(result[1], -1.0), true)
    }
}

private fun isRootEquals(actual: Double, expected: Double): Boolean {
    return abs(actual - expected) < epsilon
}
