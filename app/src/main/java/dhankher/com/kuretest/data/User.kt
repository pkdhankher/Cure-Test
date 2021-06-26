package dhankher.com.kuretest.data

import android.os.Parcelable
import android.util.Log
import com.google.firebase.firestore.DocumentSnapshot
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val userId: String, //Document ID is actually the user id
    val name: String,
    val bio: String,
    val imageUrl: String
) : Parcelable {

    companion object {
        fun DocumentSnapshot.toUser(): User? {
            try {
                val userId = getString("userId")!!
                val name = getString("name")!!
                val bio = getString("bio")!!
                val imageUrl = getString("imageUrl")!!
                return User(userId, name, bio, imageUrl)
            } catch (e: Exception) {
                Log.e(TAG, "Error converting user profile", e)
                return null
            }
        }

        private const val TAG = "User"
    }
}