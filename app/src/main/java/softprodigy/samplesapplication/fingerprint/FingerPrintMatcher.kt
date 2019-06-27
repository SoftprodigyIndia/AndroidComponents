package softprodigy.samplesapplication.fingerprint

import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricPrompt
import java.util.concurrent.Executors

object FingerPrintMatcher {


    interface FingerPrintValidationCallbacks {
        fun authSuccessful()
        fun authFailed()
        fun authError(error: String)
    }

    fun validateFingerPrint(
        activity: AppCompatActivity, title: String, subtitle: String,
        description: String, negativeButtonText: String, fingerPrintValidationCallbacks: FingerPrintValidationCallbacks
    ) {

        val executor = Executors.newSingleThreadExecutor()

        val promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle(title)
            .setSubtitle(subtitle)
            .setDescription(description)
            .setNegativeButtonText(negativeButtonText)
            .build()

        val biometricPrompt =
            BiometricPrompt(activity, executor, object : BiometricPrompt.AuthenticationCallback() {

                override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                    super.onAuthenticationError(errorCode, errString)
                    fingerPrintValidationCallbacks.authError(errString.toString())
                }

                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)
                    fingerPrintValidationCallbacks.authSuccessful()
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    fingerPrintValidationCallbacks.authFailed()
                }
            })

        biometricPrompt.authenticate(promptInfo)

    }


}