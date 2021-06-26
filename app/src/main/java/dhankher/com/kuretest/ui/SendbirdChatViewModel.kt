package dhankher.com.kuretest.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dhankher.com.kuretest.data.*
import dhankher.com.kuretest.data.responses.SendbirdCreatedUsersResponse
import dhankher.com.kuretest.data.responses.SendbirdCreatedUsersResponseItem
import dhankher.com.kuretest.network.Resource
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
 class SendbirdChatViewModel @Inject constructor(
    private val sendbirdChatDataRepository: SendbirdChatDataRepository
) : ViewModel() {

    private val _kureContacts = MutableLiveData<List<KureContact>>()
    val kureContacts: LiveData<List<KureContact>> = _kureContacts
    private val _sendBirdCreatedUsersResponse = MutableLiveData<Resource<List<SendbirdCreatedUsersResponseItem>>>()
    val sendBirdCreatedUsersResponse: LiveData<Resource<List<SendbirdCreatedUsersResponseItem>>> = _sendBirdCreatedUsersResponse

    fun getContactsData() {
        viewModelScope.launch {
            _kureContacts.value = FirebaseContactsService.getContacts()
        }
    }

    fun uploadKureUsersToSendbird(sendbirdContacts: List<SendbirdContact>) {
        viewModelScope.launch {
            _sendBirdCreatedUsersResponse.value =
                sendbirdChatDataRepository.uploadKureUsersToSendbird(sendbirdContacts)
        }
    }

    fun addContact() {
        viewModelScope.launch {
            FirebaseContactsService.addContact(
                KureContact(
                    "3",
                    "Sandeep",
                    "Engineer",
                    "https://dhankher.com/sandeep-photo.jpg"
                )
            )
        }
    }

}