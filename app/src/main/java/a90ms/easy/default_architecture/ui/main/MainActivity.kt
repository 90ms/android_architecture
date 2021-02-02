package a90ms.easy.default_architecture.ui.main

import a90ms.easy.default_architecture.R
import a90ms.easy.default_architecture.common.base.BaseActivity
import a90ms.easy.default_architecture.common.ext.showToast
import a90ms.easy.default_architecture.data.db.dataStore.MainDataStore
import a90ms.easy.default_architecture.data.db.main.CoreDataBase
import a90ms.easy.default_architecture.databinding.ActivityMainBinding
import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBinding()
        initFetchData()
        initObserver()
    }

    private fun initBinding() {
        binding.viewModel = mainViewModel
    }

    private fun initObserver() {
        val owner = this
        mainViewModel.run {
            error.observe(owner) {
                val message = if (it is MainError.Error) {
                    it.throwable.message?: ""
                } else {
                    ""
                }
                showToast(message)
            }
        }
    }

    fun initFetchData() {
        mainViewModel.fetchData()
    }
}
