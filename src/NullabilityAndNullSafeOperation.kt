/*
fun main() {
    print("enter any number that you want: ")
    val userInputNumber = readln()

    // User input can be nullable or any numeric value, it ensures that null is allowed and doesn't throw nullable exception
    val inputAsInteger =
        userInputNumber.toIntOrNull() // so if the user enters any string which can't be directly transferable to number, it will give null

    println("user input: $inputAsInteger")

    var isEven = inputAsInteger!! % 2 == 0 // Now it will give nullPointerException in case of null value
    println("isEven: $isEven")

    // So the safest option is to give default value which gets assigned if the incoming value is null
    print("Enter another number greater than 0: ")
    val secondInput = readln().toIntOrNull() ?: 0
    println("second input: $secondInput")

    isEven = secondInput % 2 == 0
    println("isEven: $isEven")

    print("Enter third input number: ")
    val thirdInput = readln().toIntOrNull() ?: 0
    val isEvenThird = thirdInput.rem(2) == 0

    println("isEvenThird: $isEvenThird")
}*/


fun main() {
    println("========== Kotlin Nullability & Null Safety ==========\n")

    // 1. Nullable vs Non-Nullable Variables

    // Non-nullable variable (default)
    // This variable can NEVER hold null.
    val name: String = "Aayush"
    // name = null
    // Nullable variable
    // The ? indicates that this variable CAN hold null.
    val middleName: String? = null

    println("Name: $name")
    println("Middle Name: $middleName")


    // 2. Reading User Input
    print("\nEnter a number: ")

    // readln() always returns String
    val input = readln()

    // Convert safely
    // If conversion fails, returns null instead of throwing NumberFormatException.
    val number: Int? = input.toIntOrNull()

    println("Converted Number: $number")


    // 3. Safe Call Operator (?.)
    println("\n========== Safe Call Operator ?. ==========")

    // Safe call executes ONLY if the object is not null.
    // Otherwise, it simply returns null.

    val length = middleName?.length

    println("Length of middle name: $length")

    // Equivalent traditional code:

    /*
    if (middleName != null) {
        println(middleName.length)
    } else {
        println(null)
    }
    */


    // 4. Elvis Operator (?:)
    println("\n========== Elvis Operator ?: ==========")

    // Provides a default value if the left side is null.

    val finalNumber = number ?: 0

    println("Final Number = $finalNumber")

    // Equivalent:

    /*
    val finalNumber =
        if(number != null)
            number
        else
            0
     */

    // 5. Not Null Assertion (!!)
    println("\n========== Not Null Assertion !! ==========")

    // !! tells Kotlin:
    // "I guarantee this value is NOT null."

    // If it IS null,
    // Kotlin throws NullPointerException.

    try {
        val even = number!! % 2 == 0
        println("Even: $even")
    } catch (e: NullPointerException) {
        println("Oops! number was null.")
    }


    // 6. Safe Call with let {}
    println("\n========== let {} ==========")
    // let executes ONLY if object isn't null.
    number?.let {
        println("Inside let")
        println("Value = $it")
        println("Square = ${it * it}")
    }

    // If number == null
    // this block never executes.


    // 7. Using run with Safe Call

    println("\n========== run ==========")

    number?.run {
        println("Inside run")
        println("Cube = ${this * this * this}")
    }

    // 8. Safe Casting (as?)
    println("\n========== Safe Casting ==========")
    val value: Any = "123"

    // Safe cast
    val converted: String? = value as? String
    println(converted)

    // Wrong type
    val wrong: Int? = value as? Int
    println(wrong)

    // Returns null instead of throwing exception.


    // 9. Traditional Unsafe Cast (as)
    println("\n========== Unsafe Cast ==========")

    try {
        val wrongCast = value as Int
        println(wrongCast)
    } catch (e: Exception) {
        println("Unsafe cast failed.")
    }

    // 10. if with Nullable
    println("\n========== if ==========")
    if (number != null) {
        println(number * 2)
    } else {
        println("Number is null")
    }


    // 11. Chaining Safe Calls
    println("\n========== Chaining ==========")
    val username: String? = "Kotlin"
    val firstCharacter = username
        ?.uppercase()
        ?.first()

    println(firstCharacter)

    // 12. Nullable Collections
    println("\n========== Nullable Collections ==========")
    val list: List<String>? =
        listOf("Apple", "Banana", "Orange")
    println(list?.size)
    val emptyList: List<String>? = null
    println(emptyList?.size)


    // 13. Nullable Elements inside Collection
    println("\n========== Nullable Elements ==========")
    val names: List<String?> =
        listOf("Ram", null, "Hari", null)

    for (person in names) {
        println(person?.uppercase())
    }

    // 14. filterNotNull()


    println("\n========== filterNotNull ==========")
    val filtered =
        names.filterNotNull()
    println(filtered)


    // 15. takeIf()
    println("\n========== takeIf ==========")

    val age = 20
    val adult = age.takeIf {
        it >= 18
    }

    println(adult)


    // 16. takeUnless()


    println("\n========== takeUnless ==========")
    val child = age.takeUnless {
        it >= 18
    }

    println(child)


    // 17. requireNotNull()
    println("\n========== requireNotNull ==========")

    try {
        val value1 = requireNotNull(number) {
            "Number cannot be null."
        }
        println(value1)
    } catch (e: IllegalArgumentException) {
        println(e.message)

    }


    // 18. checkNotNull()
    println("\n========== checkNotNull ==========")

    try {
        val value2 = checkNotNull(number) {
            "Unexpected null."
        }
        println(value2)
    } catch (e: IllegalStateException) {
        println(e.message)
    }


    // 19. Summary
    println("\n========== Summary ==========")

    println("String      -> Non Nullable")
    println("String?     -> Nullable")
    println("?.          -> Safe Call")
    println("?:          -> Elvis Operator")
    println("!!          -> Not Null Assertion")
    println("let{}       -> Execute if not null")
    println("run{}       -> Execute with receiver if not null")
    println("as?         -> Safe Cast")
    println("as          -> Unsafe Cast")
    println("filterNotNull() -> Remove null values")
    println("takeIf()    -> Return value if condition is true")
    println("takeUnless()-> Return value if condition is false")
    println("requireNotNull() -> Throws IllegalArgumentException")
    println("checkNotNull()   -> Throws IllegalStateException")
}