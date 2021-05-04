package com.example.prctica2

//Todos estos hacen funcionar al proyecto de la imagen

import android.os.Bundle
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.webkit.URLUtil
import com.bumptech.glide.Glide
import com.example.prctica2.databinding.ActivityScrollingBinding
import com.example.prctica2.databinding.ContentScrollingBinding

class ScrollingActivity : AppCompatActivity() {

    //Declaramos el binding
    private lateinit var binding: ActivityScrollingBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)

        //Instanciamos el binding y lo usamos como vista
        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Le damos comportamiento ante los clics al button1
        binding.content.button1.setOnClickListener {

            //Le ponemos la imagen al imageview si se le da clic
            Glide.with(this)
                .load("https://isenacode.com/wp-content/uploads/2021/03/wallpaper-iphone-s1321.jpg")
                .into(binding.content.imageview1)
        }

        //Le damos comportamiento al checkbox
        binding.content.checkbox1.setOnClickListener {

            //Si el checkbox está activo se deshabilita el campo de texto.
            if (!binding.content.checkbox1.isEnabled) {

                binding.content.edittext1.isEnabled = !binding.content.edittext1.isEnabled

            } else {

                binding.content.checkbox1.setOnClickListener {

                    binding.content.edittext1.isEnabled = !binding.content.edittext1.isEnabled
                }
            }


        }

        //Le damos comportamiento al button2
        binding.content.button2.setOnClickListener {

            //Generamos la string nila de error, recuerda que para declarar variables nulas se usa el ?
            var errorStr: String? = null

            //Si está vacío el campo de texto
            if (binding.content.edittext1.getText().isNullOrEmpty()) {

                //Muestra el mensaje de error
                Snackbar.make(
                    binding.content.button2,
                    "Debe llenar el campo de texto",
                    Snackbar.LENGTH_LONG
                )
                    .setAnchorView(binding.content.button2)
                    .show()

            } else {

                //De lo contrario, si tiene el mensaje muestra la imagen en el imageview
                Glide.with(this)
                    .load("https://ichef.bbci.co.uk/news/640/cpsprodpb/8536/production/_103520143_gettyimages-908714708.jpg")
                    .into(binding.content.imageview1)
            }
        }


    }

    //esto no estoy muy seguro que sea jaja pero si hace falta copiarlo
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}