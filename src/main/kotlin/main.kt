import java.util.*

fun main () {


    val questions = listOf(
        Question("What is the capital of France?", listOf("Berlin", "Paris", "Madrid", "Rome"), 2),
        Question("Which programming language is Kotlin interoperable with?", listOf("Java", "C++", "Python", "Swift"), 0),
        Question("What is the the easiest  language ?", listOf("C++", "Haskell ", "Kotlin ", "Rust"), 2)
    )

    var score = 0

    for (question in questions) {
        askQuestion(question)
        val userAnswer = readUserAnswer()
        if (userAnswer == question.correctAnswer) {
            println("Correct!\n")
            score++
        } else {
            println("Incorrect. The correct answer is: ${question.options[question.correctAnswer]}\n")
        }
    }

    println("Quiz completed! Your final score is: $score out of ${questions.size}")
}

fun askQuestion(question: Question) {
    println(question.text)
    for ((index, option) in question.options.withIndex()) {
        println("${index + 1}. $option")
    }
}

fun readUserAnswer(): Int {
    val scanner = Scanner(System.`in`)
    var input: Int
    do {
        print("Your answer: ")
        while (!scanner.hasNextInt()) {
            println("Invalid input. Please enter a number.")
            print("Your answer: ")
            scanner.next()
        }
        input = scanner.nextInt()
    } while (input < 1 || input > 4)

    return input - 1
}


