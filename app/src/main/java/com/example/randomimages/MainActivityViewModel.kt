package com.example.randomimages

import androidx.lifecycle.MutableLiveData

class MainActivityViewModel {
    private var urlImage : MutableLiveData<String?>? = null

    fun callUrlImage() : MutableLiveData<String?>? {
        urlImage ?: MutableLiveData<String?>()
        randomNumbersUrl()

        return urlImage
    }

    fun randomNumbersUrl() {
        urlImage?.value = "https://picsum.photos/${(3..5).random()}00/${(3..5).random()}00"
    }
}