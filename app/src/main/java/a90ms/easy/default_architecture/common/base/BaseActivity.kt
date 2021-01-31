package a90ms.easy.default_architecture.common.base

import a90ms.easy.default_architecture.R
import a90ms.easy.default_architecture.common.ext.showToast
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<VDB : ViewDataBinding>(
    @LayoutRes private val layoutResourceId: Int,
) : AppCompatActivity() {

    protected lateinit var binding: VDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.navigationBarColor = ContextCompat.getColor(this@BaseActivity, R.color.navigation_bar_color)

        binding = DataBindingUtil.setContentView<VDB>(this, layoutResourceId).apply {
            lifecycleOwner = this@BaseActivity
        }
    }

    fun <T> getValueElseToastWithFinish(value: T?): T {
        if (value == null) {
            showToast(R.string.toast_error_default)
            finish()
        }
        return requireNotNull(value)
    }

    companion object {
        const val DEFAULT_ERROR_MESSAGE = "Error"
        const val CHAT_STEAM_ERROR_MESSAGE = "UNAVAILABLE: End of stream or IOException"
    }
}
