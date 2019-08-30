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

//Clearer intent, enhanced API flexibility (especially when used with extension functions - see later).