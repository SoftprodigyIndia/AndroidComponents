package softprodigy.samplesapplication

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import softprodigy.samplesapplication.fingerprint.FingerPrintMatcher

class FingerPrintActivity : AppCompatActivity(), FingerPrintMatcher.FingerPrintValidationCallbacks {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fingerprint)
    }


    fun validate(view: View) {
        FingerPrintMatcher.validateFingerPrint(
            this, "Unlock", "Unlock device with your finger print",
            "", "Cancel", this
        )
    }

    override fun authFailed() {
        /**
         * auth failed. do any action if required
         */
    }

    override fun authSuccessful() {
        runOnUiThread {
            Toast.makeText(this, "Authentication Successful", Toast.LENGTH_SHORT).show()
        }
    }

    override fun authError(error: String) {
        runOnUiThread {
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
        }
    }
}
