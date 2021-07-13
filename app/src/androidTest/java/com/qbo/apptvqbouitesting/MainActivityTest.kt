package com.qbo.apptvqbouitesting

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.core.internal.deps.guava.collect.Iterables
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtraWithKey
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import junit.framework.Assert.assertEquals

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

//@RunWith esta anotación indica que esta clase correra con AndroidJUnit4ClassRunner
@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{

    //Creamos una regla para la actividad a realizar el test
    //Esta regla brinda pruebas a una sola actividad
    //Y a partir de aqui podemos definir nuestras pruebas
    //@get:Rule var activityTestScenarioRule = activityScenarioRule<MainActivity>()

    @get:Rule var intentTestScenarioRule = IntentsTestRule(MainActivity::class.java)

    //Definimos la primera prueba de funcionalidad de nuestra app
    //onView = Para buscar una vista
    //perform = para ejecutar una acción
    //check = verifica las aserciones.
    @Test
    fun ingresoDeDatos(){
        onView(withId(R.id.etnombre))
            .perform(typeText("luis angel"),
                closeSoftKeyboard())

        onView(withId(R.id.etapellido))
            .perform(typeText("salvatierra"),
                closeSoftKeyboard())

        onView(withId(R.id.rbmasculino))
            .perform(click())

        onView(withId(R.id.btnregistrar))
            .perform(click())

        //Con el método intending(), que es similar a Mockito.when(), puedes proporcionar una respuesta de stub para las actividades que se inician con startActivityForResult().
        intending(hasExtraWithKey("nombre"))

        val datosRecibidos : Intent =
            Iterables.getOnlyElement(Intents.getIntents())
        assertEquals(datosRecibidos.extras!!.getString("nombre"), "luis angel")

    }

}