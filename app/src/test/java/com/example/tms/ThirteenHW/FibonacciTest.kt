package com.example.tms.ThirteenHW


import com.google.common.truth.Truth.assertThat
import org.junit.Test
import java.math.BigInteger

class FibonacciTest{


    @Test
    fun firstFibonacciNumber_return0() {
        val result=Fibonacci.getNumber(1)
        assertThat(result).isEqualTo(BigInteger.valueOf(0))
    }
    @Test
    fun secondFibonacciNumber_return1() {
        val result=Fibonacci.getNumber(2)
        assertThat(result).isEqualTo(BigInteger.valueOf(1))
    }
    @Test
    fun thirdFibonacciNumber_return1() {
        val result=Fibonacci.getNumber(3)
        assertThat(result).isEqualTo(BigInteger.valueOf(1))
    }
    @Test
    fun fifthFibonacciNumber_return3() {
        val result=Fibonacci.getNumber(5)
        assertThat(result).isEqualTo(BigInteger.valueOf(3))
    }
    @Test
    fun fiftiethFibonacciNumber_return7778742049() {
        val result=Fibonacci.getNumber(50)
        assertThat(result).isEqualTo(BigInteger.valueOf(7778742049L))
    }
    @Test
    fun negativeFibonacciNumber_return0() {
        val result=Fibonacci.getNumber(-2)
        assertThat(result).isEqualTo(BigInteger.valueOf(0))
    }
    @Test
    fun zeroFibonacciNumber_return0() {
        val result=Fibonacci.getNumber(0)
        assertThat(result).isEqualTo(BigInteger.valueOf(0))
    }
}