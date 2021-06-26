package dhankher.com.kuretest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import dhankher.com.kuretest.data.KureContact
import dhankher.com.kuretest.data.KureContacts
import dhankher.com.kuretest.data.SendbirdContact
import dhankher.com.kuretest.data.SendbirdContacts
import dhankher.com.kuretest.network.Resource
import dhankher.com.kuretest.ui.ChatBaseActivity
import dhankher.com.kuretest.ui.SendbirdChatViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val TAG: String = MainActivity::class.java.canonicalName
    private val viewModel: SendbirdChatViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( R.layout.activity_main)

        viewModel.kureContacts.observe(this) {
            Log.d(TAG, "UserList: ReceivedContactsFromFireStore- ${it.size}")
            Log.d(TAG, "UserList: Uploading Contacts to Sendbird..")
            uploadContactsToSendbird()
        }

        viewModel.sendBirdCreatedUsersResponse.observe(this){
                when (it) {
                    is Resource.Success -> {
                        Log.d(TAG, "UserList: Uploaded Contacts To Sendbird - ")
                    }
                    is Resource.Loading -> {
//
                    }
                    is Resource.Failure -> {
                        Log.d(TAG, "UserList: Uploading failed - ${it.errorCode}")
                    }
            }

        }
    }

    fun addContacts(view: View) {
        Log.d(TAG, "UserList: addingData..")
        viewModel.addContact()

    }

    fun getContacts(view: View) {
        Log.d(TAG, "UserList: requestingData..")
        viewModel.getContactsData()
    }

    fun uploadContactsToSendbird(){
        viewModel.uploadKureUsersToSendbird(listOf(SendbirdContact("sdsf","Kanit","http:://poonam.png")))
    }

    fun startChat(view: View){
        Intent(this, ChatBaseActivity::class.java).apply { startActivity(this) }
    }

}