package mr.bergin.talks.a_generic_talk_on_kotlin.c_tangents

/**
 * Generics are fully compatible with data classes, pair and triple are great examples of this.
 *
 * Looking at the example below we can combine a data class with generics, destructuring and type inference
 * to cleanly extract a name (String) and an age (Int), without ever seeing generics mentioned.
 */
fun dataClasses() {
    val nameToAge = "Jordan Bergin" to 29
    val (name, age) = nameToAge //name
}

/**
 * Readability - so much boilerplate is done for us!
 */