package mr.bergin.talks.a_generic_talk_on_kotlin.d_patterns

fun fluentApi() {
    //But it doesn't stop there, no no no. Fluent APIs, ohhh oh oh yes! Kotlin's Stdlib is a beautiful
//example of how to write a fluent api, consider the following:

    numbers.asSequence().filter { it > 1 }.map { it + 1 }.sorted().toList()

//The above is only possible by
}