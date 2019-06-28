package softprodigy.samplesapplication

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import softprodigy.samplesapplication.utils.ImageUtils
import java.io.File
import kotlin.coroutines.CoroutineContext



class MainActivity : AppCompatActivity() , CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default + job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // setSupportActionBar(toolbar as Toolbar?)

        takeImage.setOnClickListener { view ->
            myStartActivityForResult<CamerActivity>(1)
        }
    }

    inline fun <reified T : Activity> Activity.myStartActivityForResult(requestCode: Int) {
        val intent = Intent(this, T::class.java)
        startActivityForResult(intent, requestCode)
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            // Make sure the request was successful
            if (resultCode == Activity.RESULT_OK) {
                var imageFile = data?.extras?.get("image")
                setGalleryThumbnail(imageFile as File)
            }


        }
    }

    private fun setGalleryThumbnail(file: File) {
        // Reference of the view that holds the gallery thumbnail

        // Use a coroutine to perform thumbnail operations in background
        launch(coroutineContext) {

            // Create thumbnail for this photo
            val bitmap = ImageUtils.decodeBitmap(file)

            // Crop the bitmap into a circle for the thumbnail
            val thumbnailBitmap = ImageUtils.cropCircularThumbnail(bitmap)

            // Set the foreground drawable if we can, fallback using Glide
            // This must be done in the main thread, so use main thread's context
            withContext(Dispatchers.Main) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    imageView.foreground = BitmapDrawable(resources, bitmap)
                } else {
                    Glide.with(this@MainActivity).load(bitmap).into(imageView)
                }
            }
        }
    }
}
