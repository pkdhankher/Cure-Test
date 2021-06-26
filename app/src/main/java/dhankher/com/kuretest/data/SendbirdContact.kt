package dhankher.com.kuretest.data

import android.os.Parcelable
import android.util.Log
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.PropertyName
import kotlinx.android.parcel.Parcelize


data class SendbirdContact(
    val user_id: String,
    val nickname: String,
    val profile_url: String
)