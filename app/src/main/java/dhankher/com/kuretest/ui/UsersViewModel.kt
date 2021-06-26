package dhankher.com.kuretest.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import dhankher.com.kuretest.data.FirebaseContactsService
import dhankher.com.kuretest.data.User
import kotlinx.coroutines.launch


public class UsersViewModel : ViewModel() {

    private val TAG: String = UsersViewModel::class.java.canonicalName
    private val _kureContacts = MutableLiveData<List<User>>()
    val kureContacts: LiveData<List<User>> = _kureContacts

    init {

    }

    fun getContactsData() {
        viewModelScope.launch {
            _kureContacts.value = FirebaseContactsService.getContacts()
        }
    }

    fun addContact() {
        viewModelScope.launch {
            FirebaseContactsService.addContact(
                User(
                    "3",
                    "Sandeep",
                    "Engineer",
                    "https://dhankher.com/sandeep-photo.jpg"
                )
            )
        }
    }

}