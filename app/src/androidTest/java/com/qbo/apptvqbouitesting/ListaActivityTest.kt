package com.qbo.apptvqbouitesting

import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.hamcrest.CoreMatchers.*


import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class ListaActivityTest{

    @get:Rule var activityTestScenarioRule = activityScenarioRule<ListaActivity>()

    //onData = Verifica la coincidencia de un elemento.
    @Test
    fun testAdapterSpinner(){
        onView(withId(R.id.spcursos)).perform(click())

        onData(allOf(`is`(instanceOf(String::class.java)), `is`("Kotlin"))).perform(click())

        onView(withId(R.id.tvcurso))
            .check(matches(withText(containsString("Kotlin"))))

    }

}