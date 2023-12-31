import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException
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
    fun `should return two identical roots`() {
        val result = solve(a = 1.0, b = 2.0, c = 1.0, e = epsilon)
        assertEquals(isRootEquals(result[0], -1.0), true)
        assertEquals(isRootEquals(result[1], -1.0), true)
    }

    @Test
    fun `should throw exception when a is zero`() {
        assertThrows<IllegalArgumentException> {
            solve(a = 0.0, b = 2.0, c = 1.0, e = epsilon)
        }
    }

    @Test
    fun `should return two identical roots with epsilon`() {
        val result = solve(a = 1.0, b = 2.0 + 1e-8, c = 1.0, e = epsilon)
        assertEquals(isRootEquals(result[0], result[1]), true)
    }

    @Test
    fun `should throw exception when a is NaN`() {
        assertThrows<IllegalArgumentException> {
            solve(a = Double.NaN, b = 1.0, c = 1.0, e = epsilon)
        }
    }

    @Test
    fun `should throw exception when b is NaN`() {
        assertThrows<IllegalArgumentException> {
            solve(a = 1.0, b = Double.NaN, c = 1.0, e = epsilon)
        }
    }

    @Test
    fun `should throw exception when c is NaN`() {
        assertThrows<IllegalArgumentException> {
            solve(a = 1.0, b = 1.0, c = Double.NaN, e = epsilon)
        }
    }

    @Test
    fun `should throw exception when a is negative infinity`() {
        assertThrows<IllegalArgumentException> {
            solve(a = Double.NEGATIVE_INFINITY, b = 1.0, c = 1.0, e = epsilon)
        }
    }

    @Test
    fun `should throw exception when a is positive infinity`() {
        assertThrows<IllegalArgumentException> {
            solve(a = Double.POSITIVE_INFINITY, b = 1.0, c = 1.0, e = epsilon)
        }
    }

    @Test
    fun `should throw exception when b is negative infinity`() {
        assertThrows<IllegalArgumentException> {
            solve(a = 1.0, b = Double.NEGATIVE_INFINITY, c = 1.0, e = epsilon)
        }
    }

    @Test
    fun `should throw exception when b is positive infinity`() {
        assertThrows<IllegalArgumentException> {
            solve(a = 1.0, b = Double.POSITIVE_INFINITY, c = 1.0, e = epsilon)
        }
    }

    @Test
    fun `should throw exception when c is negative infinity`() {
        assertThrows<IllegalArgumentException> {
            solve(a = 1.0, b = 1.0, c = Double.NEGATIVE_INFINITY, e = epsilon)
        }
    }

    @Test
    fun `should throw exception when c is positive infinity`() {
        assertThrows<IllegalArgumentException> {
            solve(a = 1.0, b = 1.0, c = Double.POSITIVE_INFINITY, e = epsilon)
        }
    }
}

private fun isRootEquals(actual: Double, expected: Double): Boolean {
    return abs(actual - expected) < epsilon
}
