package com.mony.intentssample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {

    /* A kotlin feature for declaring static properties. */
    companion object {
        const val MESSAGE = "text from button"
        const val QUERY_URI = "https://www.youtube.com/watch?v=dQw4w9WgXcQ"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        /* Accessing passed data from intent using key. */
        val messageFromHome = intent?.extras?.getString(MESSAGE).toString()

        var messageTextView = findViewById<TextView>(R.id.messageTextView);
        messageTextView.text = (
                getString(R.string.explicit_intent_message)
                )

        /* Setting title of activity from received text from intent. */
        this.title = messageFromHome
    }
}