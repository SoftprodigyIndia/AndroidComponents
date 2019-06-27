package softprodigy.samplesapplication.utils

import android.content.Context
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.squareup.picasso.Picasso
import softprodigy.samplesapplication.R
import java.net.ConnectException
import java.net.UnknownHostException

object Extensions {

    fun ViewGroup.inflate(layoutRes: Int): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, false)
    }

    fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(this.windowToken, 0)
    }

    //load image form url
    fun ImageView.loadImage(url: String, @DrawableRes placeholder: Int) {
        if (placeholder != 0) {
            Picasso.get().load(url).placeholder(placeholder).error(placeholder).into(this)
        } else {
            Picasso.get().load(url).into(this)
        }
    }


    fun View.showView() {
        this.visibility = View.VISIBLE
    }

    fun View.hideView() {
        this.visibility = View.GONE
    }

    //return error message from webservice error code
    fun Throwable.getErrorMessage(context: Context): String {
        return if (this is UnknownHostException
            || this is ConnectException
        ) {
            context.resources.getString(R.string.warning_network_error)
        } else {
            context.resources.getString(R.string.error_occurred)
        }
    }

    //check if email is valid
    fun String.isValidEmail(): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }
}