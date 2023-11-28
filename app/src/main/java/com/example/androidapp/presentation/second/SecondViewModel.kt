package com.example.androidapp.presentation.second

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidapp.domain.weather.UseCase
import kotlinx.coroutines.launch

class SecondViewModel : ViewModel() {


    private val weatherUseCase = UseCase

    val animalListLd = MutableLiveData<List<Cryprto>>()
    val weatherLd = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>()



    fun getWeather(lat: String, lon: String) {
        viewModelScope.launch {
            isLoading.postValue(true)

//            val animalList = animalUseCase.getAnimal()
//            animalListLd.postValue(animalList)

            val data = weatherUseCase.getWeather(lat, lon)
            weatherLd.postValue(data)

            isLoading.postValue(false)
        }
    }
}