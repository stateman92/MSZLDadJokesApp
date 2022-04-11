package hu.bme.aut.dadjokes.network

import hu.bme.aut.dadjokes.common.Constants
import hu.bme.aut.dadjokes.common.print
import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val request = originalRequest.newBuilder()
            .url(originalRequest.url)
            .addHeader(Constants.API_KEY_HEADER_NAME, "secret")
            .build()
        request.toString().print()
        return chain.proceed(request)
    }
}