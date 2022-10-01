package com.begines.christian.networkdatasource.remote

import com.begines.christian.data.models.WorkerApiModel
import com.begines.christian.data.models.WorkerListApiModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AppService {
    @GET("oompa-loompas")
    suspend fun getWorkerList(
        @Query("page") page: Int
    ): WorkerListApiModel

    @GET("oompa-loompas/{id}")
    suspend fun getWorker(@Path("id") id: String): WorkerApiModel

    companion object {
        private const val BASE_URL =
            "https://2q2woep105.execute-api.eu-west-1.amazonaws.com/napptilus/"

        fun create(): AppService {
            val logger =
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()
                .create(AppService::class.java)
        }
    }
}
