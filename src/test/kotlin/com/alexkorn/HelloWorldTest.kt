package com.alexkorn

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class HelloWorldTest {
    @Test
    internal fun foo() {
        assertEquals(4, HelloWorld().doAThing(2))
    }
}