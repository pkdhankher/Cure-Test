package dhankher.com.kuretest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import dhankher.com.kuretest.databinding.ActivityMainBinding
import dhankher.com.kuretest.ui.UsersViewModel

class MainActivity : AppCompatActivity() {

    private val TAG: String = MainActivity::class.java.canonicalName
    private val viewModel: UsersViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel.kureContacts.observe(this) {

        }
    }

    fun addContacts(view: View) {
        Log.d(TAG, "UserList: addingData..")
        viewModel.addContact()
    }

    fun getContacts(view:View) {
        Log.d(TAG, "UserList: requestingData..")
        viewModel.getContactsData()
    }
}