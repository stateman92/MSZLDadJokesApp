package hu.bme.aut.dadjokes.network

import hu.bme.aut.dadjokes.common.Constants
import hu.bme.aut.dadjokes.extensions.print
import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val request = originalRequest
            .newBuilder()
            .addHeader(
                name = Constants.API_KEY_HEADER_NAME,
                value = ""
            )
            .build()
        request.toString().print()
        return chain.proceed(request)
    }
}