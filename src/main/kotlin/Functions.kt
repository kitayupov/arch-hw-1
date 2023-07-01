import kotlin.math.sqrt

/**
 * Returns the solution of the quadratic equation
 * a * x^2 + b * x  + c = 0
 */
fun solve(a: Double, b: Double, c: Double, e: Double): Array<Double> {
    val d = b * b - 4 * a * c
    if (d + e < 0) return emptyArray<Double>()
    if (d > e) {
        val x1 = (-b - sqrt(d)) / (2 * a)
        val x2 = (-b + sqrt(d)) / (2 * a)
        return arrayOf(x1, x2)
    }
    return emptyArray<Double>()
}