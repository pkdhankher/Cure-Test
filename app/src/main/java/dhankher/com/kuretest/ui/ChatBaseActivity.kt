package dhankher.com.kuretest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dhankher.com.kuretest.R

class ChatBaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_base)
    }
}