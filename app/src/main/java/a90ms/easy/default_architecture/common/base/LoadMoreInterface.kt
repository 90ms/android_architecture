package a90ms.easy.default_architecture.common.base

interface LoadMoreInterface {
    fun moreAction()

    companion object {
        const val LOAD_REQUEST_DEFAULT_SIZE = 10
        const val LOAD_REQUEST_QUIZ_SIZE = 20
        const val LOAD_REQUEST_COMMENT_SIZE = 20

        const val PRE_LOAD_SIZE = 5
    }
}

