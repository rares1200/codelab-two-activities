package com.example.rnechita.twoactivitiescodelab

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.simpleName

    companion object {
        const val EXTRA_MESSAGE = "com.example.rnechita.twoactivitiescodelab.extra.MESSAGE"
        const val TEXT_REQUEST = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun launchSecondActivity(view: View) {
        val message = editText_main.text.toString()
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(EXTRA_MESSAGE, message)
        startActivityForResult(intent, TEXT_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                data?.let {
                    val reply = data.getStringExtra(SecondActivity.EXTRA_REPLY)
                    text_header_reply.visibility = View.VISIBLE
                    text_message_reply.text = reply
                    text_message_reply.visibility = View.VISIBLE
                }
            }
        }
    }
}
