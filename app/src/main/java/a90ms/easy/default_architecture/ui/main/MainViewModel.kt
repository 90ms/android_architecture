package a90ms.easy.default_architecture.ui.main

import a90ms.easy.default_architecture.common.base.BaseViewModel
import a90ms.easy.default_architecture.data.model.MainVo
import a90ms.easy.default_architecture.domain.usecase.MainUseCase
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val mainUseCase : MainUseCase
) : BaseViewModel() {

    private val _error = MutableLiveData<MainError>()
    val error: LiveData<MainError> get() = _error

    private val _mainVo = MutableLiveData<MainVo>()
    val mainVo: LiveData<MainVo> get() = _mainVo

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _error.value = MainError.Error(throwable)
    }

    fun fetchData() {
        viewModelScope.launch(coroutineExceptionHandler){
            mainUseCase.getMainData()
        }
    }

    fun moreAction(){

    }

}
