package com.matheusbrandao.pokemon.di

import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializer
import com.matheusbrandao.pokemon.data_remote.RxCallAdapterFactory
import com.matheusbrandao.pokemon.data_remote.net.AuthorizationInterceptor
import com.matheusbrandao.pokemon.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

val BRAZIL = Locale("pt", "BR")
const val API_BASE_URL = "https://pokeapi.co/api/v2/"

val componentsModule = module {

    factory {
        GsonBuilder()
            .registerTypeAdapter(Date::class.java, JsonDeserializer<Date> { jsonElement, _, _ ->
                try {
                    val df = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", BRAZIL)
                    return@JsonDeserializer df.parse(jsonElement.asJsonPrimitive.asString)
                } catch (e: Exception) {
                    val df = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", BRAZIL)
                    return@JsonDeserializer df.parse(jsonElement.asJsonPrimitive.asString)
                }
            })
            .create()
    }

    single {
        AuthorizationInterceptor()
    }

    factory {
        OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(get() as HttpLoggingInterceptor)
    }

    factory {
        HttpLoggingInterceptor().setLevel(
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        )
    }

    factory {
        Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(get()))
            .addCallAdapterFactory(RxCallAdapterFactory.create())
            .client(get())
            .build()
    }

    factory {
        (get() as OkHttpClient.Builder)
            .addInterceptor(get() as AuthorizationInterceptor)
            .build()
    }

}