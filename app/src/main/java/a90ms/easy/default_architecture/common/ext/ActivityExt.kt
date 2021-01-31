package a90ms.easy.default_architecture.common.ext

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast

inline fun <reified T : Activity> Activity.startActivity(bundle: Bundle? = null, transitionBundle: Bundle? = null) {
    val intent = Intent(this, T::class.java)
    if (bundle != null) {
        intent.putExtras(bundle)
    }
    startActivity(intent, transitionBundle)
}

inline fun <reified T : Activity> Activity.startActivityWithFinish(bundle: Bundle? = null) {
    startActivity<T>(bundle)
    finish()
}

fun Activity.showToast(resId: Int, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, resId, length).show()
}

fun Activity.showToast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}
