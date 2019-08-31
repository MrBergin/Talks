package mr.bergin.talks.a_generic_talk_on_kotlin.b_fundamentals

import java.io.Closeable
import java.lang.Appendable


/**
 * Upper bounds enable you to use generic type parameters, but also have access to members beyond Any?
 *
 * Below you will see the "greater than" operator, that is only available to us if our Type is Comparable!
 */
fun <K: Comparable<K>> max(a: K, b: K): K {
    return if (a > b) a else b
}

/**
 * NB this one is stolen from the Kotlin stdlib.
 */
fun <T : Appendable> T.append(vararg value: CharSequence?): T {
    for (item in value)
        append(item)
    return this
}

/**
 * If you want to specify many upper bounds, you use the "where" syntax.
 */
fun <K> runEnsuringClosed(k: K) where K: Runnable, K: Closeable {
    k.run()
    k.close()
}

/**
 * So what do we get with this?
 *
 * Clearer intent - the generic itself is helping to document what this function is for (K: Comparable<K> shows me
 * the intent for this function is perform comparisons in some way).
 *
 * Flexibility - we restrict the caller from using irrelevant types * in exchange for being able to do more within the function.
 *
 * Easy to navigate - we'll see in the extension functions section later on how this works :)
 */