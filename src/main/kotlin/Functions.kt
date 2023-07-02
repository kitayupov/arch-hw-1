import kotlin.math.abs
import kotlin.math.sqrt

/**
 * Returns the solution of the quadratic equation
 * a * x^2 + b * x  + c = 0
 */
fun solve(a: Double, b: Double, c: Double, e: Double): Array<Double> {
    if (listOf(a, b, c).any { it.isFinite().not() }) {
        throw IllegalArgumentException("One of parameters is not a valid number")
    }
    if (abs(a) < e) {
        throw IllegalArgumentException("Parameter `a` is equal to zero")
    }
    val d = b * b - 4 * a * c
    if (d + e < 0) return emptyArray<Double>()
    if (d > e) {
        val x0 = (-b - sqrt(d)) / (2 * a)
        val x1 = (-b + sqrt(d)) / (2 * a)
        return arrayOf(x0, x1)
    }
    if (abs(d) < e) {
        val x0 = (-b - sqrt(d)) / (2 * a)
        return arrayOf(x0, x0)
    }
    return emptyArray<Double>()
}