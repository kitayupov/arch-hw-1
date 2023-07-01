import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FunctionsKtTest {

    @Test
    fun `should return empty roots`() {
        val result = solve(1.0, 0.0, 1.0, 1e-7)
        assertEquals(result.size, 0)
    }
}