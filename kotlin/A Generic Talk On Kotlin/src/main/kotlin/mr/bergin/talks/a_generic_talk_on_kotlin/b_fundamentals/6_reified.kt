package mr.bergin.talks.a_generic_talk_on_kotlin.b_fundamentals

import kotlin.reflect.KClass

/**
 * The final fundamental is reified. As you may well know, these generics are implemented using erasure.
 *
 * This means whilst you may know at compile time what your generic times are, no new types are actually created
 * for the runtime and all this information is lost.
 *
 * What this means is you can't do this:
 */

fun <L> storeIfRightType1(destination: MutableList<L>, toCheck: Any?) {
    if (toCheck is L) destination.add(toCheck)
}

/**
 * Of course you could use reflection...
 */
fun <L> storeIfRightType2(destination: MutableList<L>, toCheck: Any?, clazz: KClass<L>) {
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
 * Readable - boilerplate is reduced - in fact the class<> previously passed can even be inferred now.
 * Intent - hints to the reader this function solves a problem doing type checking or casting.
 */