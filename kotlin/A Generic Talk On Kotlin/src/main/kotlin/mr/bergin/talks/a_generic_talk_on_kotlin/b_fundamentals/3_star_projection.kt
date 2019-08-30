package mr.bergin.talks.a_generic_talk_on_kotlin.b_fundamentals

/**
 * Sometimes you want to communicate that you don't need to know anything about the generic parameter
 *
 * This function doesn't look at what's in the array, it only reads a property that's nothing to do with the
 * parameter type.
 *
 * NB you can actually still read Any? out of this array.
 */
fun sizeOf(list: MutableList<in Nothing>) = list.size

/**
 * So how do we really benefit here?
 *
 * Readability benefit - we could actually use <out Any?>, or <in Nothing> instead of <*> and it would be equivalent.
 * <*> is simply easier to read and leaves no room for error (like mistaking <out Any> with <out Any?>).
 *
 * Clearer intent - <*> is instantly recognisable as "hey, i really don't care about the type you're using", using
 * <out Any?> or <in Nothing> require you to make that connection when reading.
 */