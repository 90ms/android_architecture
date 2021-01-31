package a90ms.easy.default_architecture.ui.main

sealed class MainError {

    data class Error(val throwable: Throwable) : MainError()

}