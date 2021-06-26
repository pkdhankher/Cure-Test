package dhankher.com.kuretest.data

import android.util.Log
import com.google.firebase.firestore.DocumentSnapshot
import com.sendbird.android.SendBird

data class KureContacts(
    val kureContacts: List<KureContact>
) {
    private val TAG = KureContacts::class.java.canonicalName

    companion object {
        fun KureContacts.toSendbirdContacts(): List<SendbirdContact>? {
            try {
                var sendBirdContacts = ArrayList<SendbirdContact>()
                for (kureContact in kureContacts) {
                    var sendBirdContact =
                        SendbirdContact(kureContact.userId, kureContact.name, kureContact.imageUrl)
                    sendBirdContacts.add(sendBirdContact)
                }
                return sendBirdContacts
            } catch (e: Exception) {
                Log.e(TAG, "Error converting user profile", e)
                return null
            }
        }
    }


}


