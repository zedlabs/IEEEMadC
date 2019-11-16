package tk.zedlabs.ieeemadc.repository

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

public object RetrofitService {

    var logging   = run {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
        }
    }
    var client : OkHttpClient = OkHttpClient.Builder().addInterceptor(logging).build()

    private var retrofit : Retrofit = Retrofit.Builder()
        .baseUrl("https://api.waqi.info/feed/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    public fun <S> createService(serviceClass: Class<S>): S {
        return retrofit.create(serviceClass)
    }
}