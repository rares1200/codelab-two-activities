package com.example.rnechita.twoactivitiescodelab

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_REPLY = "com.example.rnechita.twoactivitiescodelab.extra.REPLY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        intent?.let {
            val message = it.getStringExtra(MainActivity.EXTRA_MESSAGE)
            text_message.text = message
        }

    }

    fun returnReply(view: View) {
        val reply = editText_second.text.toString()
        val replyIntent = Intent()
        replyIntent.putExtra(EXTRA_REPLY, reply)
        setResult(Activity.RESULT_OK, replyIntent)
        finish()
    }
}
