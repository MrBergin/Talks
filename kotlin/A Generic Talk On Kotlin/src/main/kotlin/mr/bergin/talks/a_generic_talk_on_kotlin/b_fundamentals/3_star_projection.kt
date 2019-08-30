package mr.bergin.talks.a_generic_talk_on_kotlin.b_fundamentals

/**
 * Sometimes you want to communicate that you don't need to know anything about the generic parameter
 *
 * This function doesn't look at what's in the array, it only reads a property that's nothing to do with the
 * parameter type.
 */
fun sizeOf(array: Array<*>) = array.size

//Clearer intent