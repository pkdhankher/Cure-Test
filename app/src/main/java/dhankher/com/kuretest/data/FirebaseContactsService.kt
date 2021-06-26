package dhankher.com.kuretest.data

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import dhankher.com.kuretest.data.KureContact.Companion.toUser
import kotlinx.coroutines.tasks.await

object FirebaseContactsService {
    private const val TAG = "FirebaseContactsService"

    suspend fun getContacts(): List<KureContact> {
        val db = FirebaseFirestore.getInstance()
        return try {
            db.collection("usersContacts/2gyQ7XUMuxZx3OCoqmivOdjLMFK2/2gyQ7XUMuxZx3OCoqmivOdjLMFK2")
                .limit(10)
                .get().await()
                .documents.mapNotNull {
                    it.toUser()
                }
        } catch (e: Exception) {
            Log.e(TAG, "Error getting contacts", e)
            emptyList()
        }
    }

    //testing
    fun addContactToFirebase(kureContact: KureContact) {
        val db = FirebaseFirestore.getInstance()

        db.collection("users")
            .add(kureContact)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "UserList: User Added! ${documentReference.id}")
            }
    }

    fun getContactsData() {
        val db = FirebaseFirestore.getInstance()
        db.collection("users")
            .get()
            .addOnSuccessListener { result ->
                Log.d(TAG, "UserList: ${result.size()}")
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "UserList: ${exception.message}")
            }
    }


}