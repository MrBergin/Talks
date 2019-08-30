package mr.bergin.talks.a_generic_talk_on_kotlin.b_fundamentals

/**
 * What you've seen so far is known as "use-site" variance, i.e. we set the variance (in or out) as we
 * use the type:
 */

val useSite : MutableList<out Number> = mutableListOf<Int>()

/**
 * Kotlin also offers something called "declaration-site" variance. We set the variance on the generic class itself.
 *
 * This is a handy way of communicating that the type itself doesn't provide a way to "take out" or "put in" the
 * generic type parameter. This allows the compiler now infer "in" or "out" wherever the type is used!
 *
 * (more on inference later!).
 */
interface DeclarationSite<in K> {
    fun consume(k: K)

    fun produce(): K
}

/**
 * The List interface is a great example of this, it only provides functions to read so it is set to "out".
 */

fun listIsGreat() {
    val numberList = listOf<Number>()
    val anythingList: List<Any> = numberList // perfectly fine, because List<Any> is actually a List<out Any>!
}

//Reduced boilerplate, the types intent is clearer.