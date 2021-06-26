package dhankher.com.kuretest.data

import dhankher.com.kuretest.base.BaseRepository
import dhankher.com.kuretest.network.SendbirdPlatformApis
import javax.inject.Inject

class SendbirdChatDataRepository @Inject constructor(
    private val sendbirdPlatformApi: SendbirdPlatformApis
) : BaseRepository() {


    suspend fun uploadKureUsersToSendbird(sendbirdContacts: List<SendbirdContact>) = safeApiCall {
        sendbirdPlatformApi.uploadKureUsersToSendbird(sendbirdContacts)
    }


}