package com.robfed.petcare

import javax.inject.Inject
import kotlin.random.Random

class MainRepository @Inject constructor() {

    fun getStringTest() : String {
        return when(Random.nextInt(0, 3)) {
            1 -> "A"
            2 -> "B"
            else -> "C"
        }
    }
}