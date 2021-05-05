package com.example.proyectodevida

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    //Instanciamos el MediaPlayer
    private var mediaPlayer : MediaPlayer = null
    private var posicion : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //biblioteca para ocupar el log
        Log.i("Ciclo de vida", "onCreate")

    }

    //Inicio del ciclo de vida
    override fun onStart() {
        super.onStart()
        Log.i("Ciclo de vida", "onStart")
        mediaPlayer = MediaPlayer.create(this, R.raw.electronicaandroid)//Paso2
        //mediaPlayer?.start() //Paso 7
    }

    //vida intermedia
    override fun onResume() {
        super.onResume()
        Log.i("Ciclo de vida", "onResume")
        mediaPlayer?.seekTo(posicion)
        mediaPlayer?.start()
    }

    //Estado de pausa
    override fun onPause() {
        super.onPause()
        Log.i("Ciclo de vida", "onPause")
        //Paso 2
        mediaPlayer?.pause()

        if (mediaPlayer != null) posicion = mediaPlayer!!.currentPosition
    }

    //Al momento de parar la actividad
    override fun onStop() {
        super.onStop()
        Log.i("Ciclo de vida", "onStop")
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer =  null
    }

    //Al reiniciar la actividad
    override fun onRestart() {
        super.onRestart()
        Log.i("Ciclo de vida", "onRestart")
    }

    //Al acabar con la actividad
    override fun onDestroy() {
        super.onDestroy()
        Log.i("Ciclo de vida", "onDestroy" )
    }
}