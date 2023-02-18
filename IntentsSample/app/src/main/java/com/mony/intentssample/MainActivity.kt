package com.mony.intentssample

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mony.intentssample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    /* The object for data binding. */
    private  lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        /* Calling an activity through explicit intent. */
        binding.explicitIntentButton.setOnClickListener {

            val intent = Intent(this, DetailsActivity::class.java)

            intent.putExtra(
                "text from button",
                binding.explicitIntentButton.text.toString()
            )

            startActivity(intent)
        }

        /* Opening web browser by implicit intent. */
        binding.implicitIntentButton.setOnClickListener {

            /*
                SOME COMMON IMPLICIT INTENT TYPES
                -----------------------------------------
                CATEGORY_APP_MAPS – launching the maps app
                CATEGORY_APP_EMAIL – launching the email app
                CATEGORY_APP_GALLERY – launching the gallery (photos) app
                ACTION_SET_ALARM – setting an alarm in the background
                ACTION_DIAL – initiating a phone call
            */

            val queryUri = Uri.parse(DetailsActivity.QUERY_URI)

            val intent = Intent(Intent.ACTION_VIEW, queryUri)
            startActivity(intent)
        }
    }
}