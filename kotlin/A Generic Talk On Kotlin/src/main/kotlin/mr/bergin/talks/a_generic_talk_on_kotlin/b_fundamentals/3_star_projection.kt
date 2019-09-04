package mr.bergin.talks.a_generic_talk_on_kotlin.b_fundamentals

/**
 * Sometimes you want to communicate that you don't need to know anything about the generic parameter.
 *
 * Here we use whats called Star Projection.
 *
 * This "sizeOf" function doesn't look at what's in the array, it only reads a property that's nothing to do with the
 * parameter type.
 *
 * NB you can actually still read Any? out of this array.
 */
fun sizeOf(list: MutableList<*>) = list.size

/**
 * So how do we really benefit here?
 *
 * Readability benefit - we could actually use <out Any?>, or <in Nothing> instead of <*> and it would be equivalent.
 * <*> is simply shorter to read.
 *
 * Clearer intent - Given the above, it leaves no ambiguity for the reader of your function, it is entirely reasonable
 * that <out Any> could be read as <out Any?> or vice versa, <*> does not have this problem.
 */