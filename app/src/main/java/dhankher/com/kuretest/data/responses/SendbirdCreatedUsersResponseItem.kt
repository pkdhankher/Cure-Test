package dhankher.com.kuretest.data.responses

data class SendbirdCreatedUsersResponseItem(
    val access_token: String,
    val discovery_keys: List<Any>,
    val has_ever_logged_in: Boolean,
    val is_active: Boolean,
    val is_created: Boolean,
    val is_online: Boolean,
    val last_seen_at: Int,
    val metadata: Metadata,
    val nickname: String,
    val phone_number: String,
    val profile_url: String,
    val require_auth_for_profile_image: Boolean,
    val session_tokens: List<Any>,
    val user_id: String
){
    class Metadata(
    )
}
