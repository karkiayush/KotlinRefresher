fun main() {
    println("Testing the environment")

    /*console input*/
    print("enter the numeric value: ")
    val userInput = readln().toInt()
    println("user input $userInput")

    val isEven = userInput % 2 == 0

    if (isEven) {
        println("It is an even number")
    } else {
        println("It is an odd number")
    }
}