package dhankher.com.kuretest.network

import dhankher.com.kuretest.data.responses.SendbirdCreatedUsersResponse
import dhankher.com.kuretest.data.KureContacts
import dhankher.com.kuretest.data.SendbirdContact
import dhankher.com.kuretest.data.SendbirdContacts
import dhankher.com.kuretest.data.responses.SendbirdCreatedUsersResponseItem
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface SendbirdPlatformApis {

    @Headers("Api-Token: 0f2fd3d860718394037cf0a01f6739dc2d47c9cc")
    @POST("v3/users")
    suspend fun uploadKureUsersToSendbird(@Body sendbirdContacts: List<SendbirdContact>): List<SendbirdCreatedUsersResponseItem>


}