package mr.bergin.talks.a_generic_talk_on_kotlin.c_tangents


/**
 * Extension functions are great, they are a way you can communicate with your compiler that your function
 * acts on a specific Type, but isn't a member of the Type itself.
 *
 * The Kotlin Stdlib is full of amazing examples, so instead of coming up with my own we'll walk through the
 * api they have for manipulating collections.
 */

fun extensionFunctions() {

    //Here's one of my favourites: part of making your code readable is also making it easy to find.
    //An effective way for a programmer to find your code is code completion.
    val numbers = listOf(1, 2, 3, 4)

    //Now obviously the List interface isn't going to have any instance functions for dealing specifically
    //with integers, and even if it did auto-complete would show us the instance function regardless
    //of the generic type...
    //This would have to be defined outside the class, finding it would be a pain normally but...

    numbers.sum()

    //You won't find the sum() method on a List<String> - this is great because it wouldn't make sense, and
    //would also pollute our namespace, causing us to see lots of suggestions in auto-complete we don't care about.
    //With extension functions we can add a whole set of functions to generics with specific types. You can even
    //use out and in to make the auto complete work for super types and sub types!

    //That's not the only way though! You can also use upper bounds, consider the following sorted call:
    val sortedNumbers = numbers.sorted()

    //Just like the .sum() one we'll only see this function show up in our auto-complete when we have a list of
    //things that can be compared - a great way to communicate to other developers what wonderful functions
    //you've prepared for them to use.

}

/**
 * With extension functions we can really give meaning to specific generic types, almost as if we were working
 * with a StringList instead of List<String>. The best part being we never had to introduce a new type just for the
 * sake of better auto-complete!
 */