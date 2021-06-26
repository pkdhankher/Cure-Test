package dhankher.com.kuretest.base

import com.bumptech.glide.load.HttpException
import dhankher.com.kuretest.network.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


abstract class BaseRepository {
    suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ): Resource<T> {

        return withContext(Dispatchers.IO) {

            try {
                Resource.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is HttpException -> {
                        Resource.Failure(false, throwable.statusCode)
                    }
                    else -> {
                        Resource.Failure(true, null)
                    }
                }

            }
        }
    }
}