package com.example.randomimages

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : ViewModel() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    val imagePhoto : ImageView = findViewById(R.id.imagePhoto)
    val imagePhoto2 : ImageView = findViewById(R.id.imagePhoto2)
    val btnGetImage : Button =  findViewById(R.id.btnGetImage)

//    val model : MainActivityViewModel = MainActivityViewModel()

    var model = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
    var urlImage : MutableLiveData<String?>? = model.callUrlImage()

    urlImage?.observe(this, Observer {
        print("Se ejecuta si la url sufre un cambio")

        Picasso.get().load(it).into(imagePhoto)
        Picasso.get().load(it).into(imagePhoto)
    })

    btnGetUrlImage.setOnClickListener {
        model.randomNumbersUrl()
    }


}