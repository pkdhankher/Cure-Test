package dhankher.com.kuretest.data

import android.os.Parcelable
import android.util.Log
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.PropertyName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class KureContact(
    val address: String,
    val firstName: String,
    val id: String,
//    val isMember: Int,
    val isVerified: String,
//    val is_delete: Int,
    val lastName: String,
//    val lastUpdate: Int,
    val lat: String,
    val lng: String,
    val mobileNumber: String,
    val parentsId: String,
    val profilePictureUrl: String,
    val status: String
) : Parcelable {

    companion object {
        fun DocumentSnapshot.toUser(): KureContact? {
            try {
                val address = getString("address")!!
                val firstName = getString("firstName")!!
                val id = getString("id")!!
//                val isMember = getLong("address")!!
                val isVerified = getString("isVerified")!!
//                val is_delete = getLong("is_delete")!!
                val lastName = getString("lastName")!!
//                val lastUpdate = getLong("lastUpdate")!!
                val lat = getString("lat")!!
                val lng = getString("lng")!!
                val mobileNumber = getString("mobileNumber")!!
                val parentsId = getString("parentsId")!!
                val profilePictureUrl = getString("profilePictureUrl")!!
                val status = getString("status")!!

                return KureContact(address, firstName, id,
                     isVerified, lastName, lat, lng, mobileNumber, parentsId, profilePictureUrl,status)
            } catch (e: Exception) {
                Log.e(TAG, "Error converting user profile", e)
                return null
            }
        }

        private const val TAG = "User"
    }
}