import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.math.abs

private const val epsilon = 1e-7

class FunctionsKtTest {

    @Test
    fun `should return no roots`() {
        val result = solve(1.0, 0.0, 1.0, epsilon)
        assertEquals(result.size, 0)
    }

    @Test
    fun `should return two different roots`() {
        val result = solve(1.0, 0.0, -1.0, epsilon)
        assertEquals(abs(result[0] + 1) < epsilon, true)
        assertEquals(abs(result[1] - 1) < epsilon, true)
    }
}