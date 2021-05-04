package com.example.ejercicio1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Button
import android.widget.TextView
import java.util.*

//IMPORTANTE: Implementa la interfaz TextToSpeech y el método OnInitListener
class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

	//IMPORTANTE: Se define sin instanciar, por eso necesita el ? si no no deja declarar nulos.
    var textToSpeech : TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //IMPORTANTE: lo que se va a mostrar en pantalla es R que es todas las vistas de la app, se va a mostrar el xml (layout) activity_main.xml
        setContentView(R.layout.activity_main)

        //IMPORTANTE: Aquí ya instanciamos el texto a voz
        textToSpeech = TextToSpeech(this, this)

        //IMPORTANTE: Al crear la actividad va a ejecutar la funcion speakMessage que está en esta clase
        findViewById<Button>(R.id.buttonPlayText).setOnClickListener{
            speakMessage()
        }
    }


	//IMPORTANTE: Esta es la función que hace que hable
    fun speakMessage () {

    	//IMPORTANTE: con R.id.editTextMessage busca en toda la app un componente con el id "editTextMessage" está en activity_main.xml
        var message = findViewById<TextView>(R.id.editTextMessage).text.toString()
        if (message.isEmpty()) {
            findViewById<TextView>(R.id.textViewMessage).text = "Introduce algo"
            message = "Introduce algo"
        }
        textToSpeech!!.speak(message, TextToSpeech.QUEUE_FLUSH, null, "")
    }

    //IMPORTANTE:Este es el metodo de la interfaz, con control i lo podemos agregar si ya está en la linea de "class MainActivity..."
    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            findViewById<TextView>(R.id.textViewMessage).text = "Si estoy"
            textToSpeech!!.setLanguage(Locale("ES"))
        }
        else {
            findViewById<TextView>(R.id.textViewMessage).text = "No estoy"
        }
    }

	//IMPORTANTE: se deben parar los servicios como text to speech si no se siguen ejecutando de fondo y usa ram
    override fun onDestroy() {
        if (textToSpeech != null) {
            textToSpeech!!.stop()
            textToSpeech!!.shutdown()
        }
        super.onDestroy()
    }
}