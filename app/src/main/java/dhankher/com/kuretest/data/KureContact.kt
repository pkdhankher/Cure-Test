package dhankher.com.kuretest.data

import android.os.Parcelable
import android.util.Log
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.PropertyName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class KureContact(
    val userId: String,
    val name: String,
    val bio: String,
    val imageUrl: String
) : Parcelable {

    companion object {
        fun DocumentSnapshot.toUser(): KureContact? {
            try {
                val userId = getString("userId")!!
                val name = getString("name")!!
                val bio = getString("bio")!!
                val imageUrl = getString("imageUrl")!!
                return KureContact(userId, name, bio, imageUrl)
            } catch (e: Exception) {
                Log.e(TAG, "Error converting user profile", e)
                return null
            }
        }

        private const val TAG = "User"
    }
}