package mr.bergin.talks.a_generic_talk_on_kotlin.b_fundamentals

import kotlin.reflect.KClass

/**
 * The final fundamental is reified.
 *
 * Kotlin's generics are also subject to type-erasure means our program doesn't know about these types are runtime.
 *
 * What this means is you can't do this:
 */

fun <L> storeIfRightType1(destination: MutableList<L>, toCheck: Any?) {
    if (toCheck is L) destination.add(toCheck)
}

/**
 * Of course you could use reflection...
 */
fun <L: Any> storeIfRightType2(destination: MutableList<L>, toCheck: Any?, clazz: KClass<L>) {
    if (clazz.isInstance(toCheck)) destination.add(toCheck as L)
}

/**
 * Then your call site looks like this...
 */
fun uglyCallSite() {
    val strings = mutableListOf<String>()
    storeIfRightType2(strings, Any(), String::class)
}

/**
 * But let's be honest, passing clazz feels bad, that warning about an unchecked cast is a little annoying too!
 * The call site as well... Let's move on quick!
 */

inline fun <reified L> storeIfRightType3(destination: MutableList<L>, toCheck: Any?) {
    if (toCheck is L) destination.add(toCheck)
}

/**
 * Then your call site looks like this...
 */
fun callSiteThatDoesntHurtMyEyes() {
    val strings = mutableListOf<String>()
    storeIfRightType3(strings, Any())
}

/**
 * Readable - boilerplate is reduced - in fact the String::class previously passed can even be inferred now.
 * Intent - hints to the reader this function solves a problem doing type checking or casting.
 */