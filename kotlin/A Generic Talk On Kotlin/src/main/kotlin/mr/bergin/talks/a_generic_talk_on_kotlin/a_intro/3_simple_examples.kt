package mr.bergin.talks.a_generic_talk_on_kotlin.a_intro

/**
 * Let's get started with some simple examples, this should hopefully look familiar to generics you've used elsewhere!
 */

/**
 * Generic functions are defined by adding angled brackets after the keyword "fun" as follows:
 */

fun <K> identity(k: K): K = k

fun identityExample() {
    val x: String = ""
    val y: String = identity<String>(x)
}

/**
 * Interfaces and classes come after the type name as follows:
 */
interface GenericInterface<K>
class GenericClass<K>

fun interfaceAndClassExample(x: GenericInterface<Any>, y: GenericClass<String>) {
}