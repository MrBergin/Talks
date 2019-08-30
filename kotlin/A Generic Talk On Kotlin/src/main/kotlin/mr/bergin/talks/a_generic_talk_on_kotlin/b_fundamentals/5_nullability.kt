package mr.bergin.talks.a_generic_talk_on_kotlin.b_fundamentals

/**
 * You can also painlessly toggle whether or not the parameter is nullable, for example this function
 * takes in an instance of K? and returns K, where K? could be null.
 */

fun <K> ensureNotNull(k: K?, default: () -> K): K {
    return k ?: default()
}

//API Flexibility - makes moving between nullable and non-nullable types easier