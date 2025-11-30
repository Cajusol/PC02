package com.mcajusol.pc02.presentation.api


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mcajusol.pc02.data.remote.api.ManoCartas
import com.mcajusol.pc02.data.remote.api.RetrofitInstance

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ApiViewModel: ViewModel() {


    private val _manoCartas = MutableStateFlow<List<ManoCartas>>(emptyList())
    val manoCartas: StateFlow<List<ManoCartas>> = _manoCartas


    private val _selecteManoCarta = MutableStateFlow<ManoCartas?>(null)
    val selecteManoCarta: StateFlow<ManoCartas?> =_selecteManoCarta

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading
    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage


    init {
        loadManoCartas()
    }


    fun loadManoCartas() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val _manoCartas = RetrofitInstance.api.getManoCartas()
                _errorMessage.value = null
            } catch (e: Exception){
                _errorMessage.value = "Error al obtener los países: ${e.message}"
            }finally {
                _isLoading.value = false
            }
        }
    }



    fun onManoCartaSelected(manoCarta: ManoCartas){
        _selecteManoCarta.value = manoCarta

    }


}