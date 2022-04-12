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
                Constants.API_KEY_HEADER_NAME,
                "68d504fffcmsh04aeb62160a2fc7p1210cajsnc525ca1a10ec"
            )
            .build()
        request.toString().print()
        return chain.proceed(request)
    }
}