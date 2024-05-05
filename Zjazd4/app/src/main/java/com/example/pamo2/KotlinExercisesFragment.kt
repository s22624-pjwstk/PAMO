package com.example.pamo2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlin.math.PI

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class KotlinExercisesFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        runAllExercises()
        return inflater.inflate(R.layout.fragment_kotlin_exercises, container, false)
    }

    private fun runAllExercises() {
        exercise1()
        exercise2()
        exercise3()
        exercise4()
        exercise5()
        exercise6()
        exercise7()
        exercise8()
        println("Circle Area: ${circleArea(5)}")
        println("Circle Area 2: ${circleArea2(5)}")
    }

    /**
     * Exercise
     * Complete the code to make the program print "Mary is 20 years old" to standard output:
     */
    private fun exercise1() {
        val name = "Mary"
        val age = 20

        println("$name is $age years old")
    }

    /**
     * Exercise
     * Explicitly declare the correct type for each variable:
     */
    private fun exercise2() {
        val a: Int = 1000
        val b: String = "log message"
        val c: Double = 3.14
        val d: Long = 100_000_000_000
        val e: Boolean = false
        val f: Char = '\n'
    }

    /**
     * Exercise 1
     * You have a list of “green” numbers and a list of “red” numbers. Complete the code to print how many numbers there are in total.
     */
    private fun exercise3() {
        val greenNumbers = listOf(1, 4, 23)
        val redNumbers = listOf(17, 2)
        val totalCount = greenNumbers.count() + redNumbers.count()
        println(totalCount)
    }

    /**
     * Exercise 2
     * You have a set of protocols supported by your server. A user requests to use a particular protocol. Complete the program to check whether the requested protocol
     * is supported or not (isSupported must be a Boolean value).
     */
    private fun exercise4() {
        val supported = setOf("HTTP", "HTTPS", "FTP")
        val requested = "smtp"
        val isSupported = requested.uppercase() in supported
        println("Support for $requested: $isSupported")
    }

    /**
     * Exercise 1
     * Using a when expression, update the following program so that when you input the names of GameBoy buttons, the actions are printed to output.
     */
    private fun exercise5() {
        val button = "A"
        println( when (button) { "A" -> "Yes" "B" -> "No" "X" -> "Menu" "Y" -> "Nothing" else -> "There is no such button" } )
    }

    /**
    Exercise 2
    You have a program that counts pizza slices until there’s a whole pizza with 8 slices. Refactor this program in two ways:
     */
    private fun exercise6() {
        var pizzaSlices1 = 0
        while ( pizzaSlices1 < 7 ) {
            pizzaSlices1++
            println("There's only $pizzaSlices1 slice/s of pizza :(")
        }
        pizzaSlices1++
        println("There are $pizzaSlices1 slices of pizza. Hooray! We have a whole pizza! :D")

        var pizzaSlices2 = 0
        pizzaSlices2++
        do {
            println("There's only $pizzaSlices2 slice/s of pizza :(")
            pizzaSlices2++
        } while ( pizzaSlices2 < 8)
        println("There are $pizzaSlices2 slices of pizza. Hooray! We have a whole pizza! :D")
    }

    /**
    * Exercise 3
     * Write a program that simulates the Fizz buzz game. Your task is to print numbers from 1 to 100 incrementally,
     * replacing any number divisible by three with the word "fizz", and any number divisible by five with the word "buzz".
     * Any number divisible by both 3 and 5 must be replaced with the word "fizzbuzz"
     */
    private fun exercise7() {
        for (number in 1..100) {
            println(
                when { number % 15 == 0 -> "fizzbuzz"
                number % 3 == 0 -> "fizz"
                number % 5 == 0 -> "buzz"
                else -> number.toString()
                }
            )
        }
    }

    /**
     * Exercise 4
     * You have a list of words. Use for and if to print only the words that start with the letter l.
     */
    private fun exercise8() {
        val words = listOf("dinosaur", "limousine", "magazine", "language")
        for (w in words) {
            if (w.startsWith("l"))
                println(w)
        }
    }

    /**
     * Exercise 1
     * Write a function called circleArea that takes the radius of a circle in integer format as a parameter and outputs the area of that circle.
     */
    private fun circleArea(radius: Int): Double {
        return PI * radius * radius
    }

    /**
     * Exercise 2
     * Rewrite the circleArea function from the previous exercise as a single-expression function.
     */
    private fun circleArea2(radius: Int): Double = PI * radius * radius

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                KotlinExercisesFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}