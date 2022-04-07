package android.socar.moviesearch.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private const val baseUrl = "https://openapi.naver.com/v1"
    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun create(): NaverSearchService = retrofit.create(NaverSearchService::class.java)
}