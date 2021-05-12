package br.vini.flightticket

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.runner.RunWith
import org.koin.test.KoinTest


@RunWith(AndroidJUnit4::class)
abstract class BaseTest : KoinTest {

    @After
    fun tearDown() {
        //Nothing Here
    }
}