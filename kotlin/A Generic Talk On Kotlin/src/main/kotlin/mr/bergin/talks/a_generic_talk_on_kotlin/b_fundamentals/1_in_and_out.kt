package mr.bergin.talks.a_generic_talk_on_kotlin.b_fundamentals


/**
 * Let's check the following OUT and get stuck IN.
 */

/**
 * in and out allow you to place restrictions on a types members, in exchange for being allowed to
 * assign different types to it.
 */
fun inAndOut() {

    run {
        // <Number> alone leaves listOfNumbers with no restrictions.
        var listOfNumbers : MutableList<Number> = mutableListOf()

        //putting numbers in is fine.
        listOfNumbers.add(42)
        listOfNumbers.add(42.0)

        //taking numbers out is fine too!
        val result: Number = listOfNumbers.first()

        //this all seems good, but we cannot do anything like this:
        listOfNumbers = mutableListOf<Any>()
        listOfNumbers = mutableListOf<Int>()
    }


    run {
        // <in Number> places restrictions on any functions that return Numbers from the generic type:
        var canPutNumbersIn : MutableList<in Number> = mutableListOf()

        canPutNumbersIn.add(42)

        //we can't take anything out here, all we know is this collection can take in numbers.
        //Of course everything in kotlin is a descendent of Any? So calling it as Any? is still allowed.
        val result: Any? = canPutNumbersIn.first()

        //but here's what you get in return:
        canPutNumbersIn = mutableListOf<Any>() //a list of anything, can of course accommodate numbers!
        canPutNumbersIn = mutableListOf<Int>()
    }



    run {
        // <out Number> places restrictions on any functions that consume Numbers into the generic type:
        var canTakeNumbersOut : MutableList<out Number> = mutableListOf()

        //we can't add anything in here, all we know is the collection produces numbers.
        canTakeNumbersOut.add(42)

        //This is fine!
        val result: Number = canTakeNumbersOut.first()

        //but here's what you get in return:
        canTakeNumbersOut = mutableListOf<Any>()
        canTakeNumbersOut = mutableListOf<Int>() // A List of Ints, can of course produce you a number.
    }
}

/**
 * As we can see above, if we can afford the restriction, in and out allow us to be flexible about what types
 * can be assigned, including types that are parameters on functions:
 */
fun <K> toMutableList(source: Array<out K>): MutableList<K> {
    return mutableListOf(*source)
}

val arrayOfStrings = arrayOf<String>()
val listOfAnother: MutableList<Any> = toMutableList(arrayOfStrings) //this only works because we used "out"!!

//Benefits: API Flexibility.