package mr.bergin.talks.a_generic_talk_on_kotlin.b_fundamentals
import kotlin.text.isEmpty

/**
 * As you may know kotlin uses nullable types for null safety.
 *
 * When it comes to generics
 *
 * By using "?" we can allow our generics to accept nullable types, even when the generic itself isn't nullable.
 */

/**
 * You can painlessly toggle whether or not the parameter is nullable, for example this function
 * takes in an instance of K? and returns K, where K? could be null.
 */

fun <K> noNullsPlease(nullables: List<K?>): List<K> {
    val mutableList = mutableListOf<K>()
    nullables.forEach {
        if (it != null) mutableList.add(it)
    }
    return mutableList.toList()
}

fun usage() {
    val nullableStrings: List<String?> = listOf("Hello", null)
    val strings: List<String> = noNullsPlease(nullableStrings)

    val x: Any? = null
}


/**
 * This one ticks all the boxes really!
 *
 * Flexibility - you can invoke a function for a non-nullable generic type, but you can still pass in a nullable one.
 * Readability - you can abstract away null check duplication by passing a K? and returning a K (like above).
 * Intent - hints your function in some way helps facilitate between nullable and non-nullable types.
 * Navigable - we'll see some useful code-completion features later on!
 */