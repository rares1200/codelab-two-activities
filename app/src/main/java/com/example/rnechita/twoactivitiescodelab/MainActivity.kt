package com.example.rnechita.twoactivitiescodelab

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.simpleName

    companion object {
        const val EXTRA_MESSAGE = "com.example.rnechita.twoactivitiescodelab.extra.MESSAGE"
        const val TEXT_REQUEST = 1
        const val REPLY_VISIBLE_KEY = "reply_visible"
        const val REPLY_TEXT_KEY = "reply_text"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "-------")
        Log.d(TAG, "onCreate")

        savedInstanceState?.let {
            val isVisible = it.getBoolean(REPLY_VISIBLE_KEY)
            val reply = it.getString(REPLY_TEXT_KEY)
            if (isVisible) {
                text_header_reply.visibility = View.VISIBLE
                text_message_reply.text = reply
                text_message_reply.visibility = View.VISIBLE
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
        if (text_header_reply.visibility == View.VISIBLE) {
            outState?.putBoolean(REPLY_VISIBLE_KEY, true)
            outState?.putString(REPLY_TEXT_KEY, text_message_reply.text.toString())
        }
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
