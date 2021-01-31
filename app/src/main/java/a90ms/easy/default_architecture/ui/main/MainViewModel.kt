package a90ms.easy.default_architecture.ui.main

import a90ms.easy.default_architecture.common.base.BaseViewModel
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineExceptionHandler

class MainViewModel @ViewModelInject constructor() : BaseViewModel() {

    private val _error = MutableLiveData<MainError>()
    val error: LiveData<MainError> get() = _error

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _error.value = MainError.Error(throwable)
    }


}