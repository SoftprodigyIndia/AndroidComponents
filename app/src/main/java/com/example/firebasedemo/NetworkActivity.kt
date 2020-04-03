package com.example.firebasedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_network.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class NetworkActivity : AppCompatActivity() {
    private val JOB_TIMEOUT = 2100L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)
        btnNetworkCoroutine.setOnClickListener {
            setNewText("Click!")

            CoroutineScope(IO).launch {
                fakeApiRequest()
            }
        }

    }

    private fun setNewText(input: String){
        val newText = tvNValue.text.toString() + "\n$input"
        tvNValue.text = newText
    }
    private suspend fun setTextOnMainThread(input: String) {
        withContext (Main) {
            setNewText(input)
        }
    }

    private suspend fun fakeApiRequest() {
        withContext(IO) {

            val job = withTimeoutOrNull(JOB_TIMEOUT) {

                val result1 = getResult1FromApi() // wait until job is done
                setTextOnMainThread("Got $result1")

                val result2 = getResult2FromApi() // wait until job is done
                setTextOnMainThread("Got $result2")

            } // waiting for job to complete...

            if(job == null){
                val cancelMessage = "Cancelling job...Job took longer than $JOB_TIMEOUT ms"
                println("debug: ${cancelMessage}")
                setTextOnMainThread(cancelMessage)
            }

        }
    }

    private suspend fun getResult1FromApi(): String {
        delay(1000) // Does not block thread. Just suspends the coroutine inside the thread
        return "Result #1"
    }

    private suspend fun getResult2FromApi(): String {
        delay(1000)
        return "Result #2"
    }

}