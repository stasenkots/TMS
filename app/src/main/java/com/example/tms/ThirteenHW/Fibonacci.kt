package com.example.tms.ThirteenHW

import java.math.BigInteger


object Fibonacci {
    fun getNumber(index: Int): BigInteger {
        var n1 = BigInteger.valueOf(0)
        var n2 =BigInteger.valueOf(1)
        if (index <= 1) return n1
        if (index == 2) return n2
        for (i in 2 until index) {
            if (n1 < n2) {
                n1 += n2
            } else {
                n2 += n1
            }
        }
        return if (n1 > n2) n1 else n2
    }
}