package dhankher.com.kuretest.base


import androidx.multidex.MultiDexApplication



class BaseApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

//        SendBirdUIKit.init(object : SendBirdUIKitAdapter {
//            override fun getAppId(): String {
//                return "DF9149BE-AD57-4ED8-9FB8-06B0AE1591AB" // Specify your Sendbird application ID.
//            }
//
//            override fun getAccessToken(): String {
//                return "920b280d46396bb0c4daa8860da59c13e6d35921"
//            }
//
//            override fun getUserInfo(): UserInfo {
//                return object : UserInfo {
//                    override fun getUserId(): String {
//                        return "12345" // Specify your user ID.
//                    }
//
//                    override fun getNickname(): String {
//                        return "Pawan" // Specify your user nickname.
//                    }
//
//                    override fun getProfileUrl(): String {
//                        return "https://media-exp1.licdn.com/dms/image/C5103AQGSfssJI7pkPA/profile-displayphoto-shrink_200_200/0/1516820890093?e=1629331200&v=beta&t=p02-I6xHHdjNCAeki9Koqtb3GdN5mhT_SpNhE3kIwds"
//                    }
//                }
//            }
//        }, this)

    }
}