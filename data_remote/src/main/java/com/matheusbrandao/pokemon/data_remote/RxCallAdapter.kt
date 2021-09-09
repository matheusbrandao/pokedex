package com.matheusbrandao.pokemon.data_remote

import io.reactivex.Completable
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.Type

class RxCallAdapter<T>(
    private val retrofit: Retrofit,
    private val wrapped: CallAdapter<*, *>?,
    private val ramType: Class<*>
) : CallAdapter<T, Any> {

    override fun responseType(): Type? {
        return wrapped?.responseType()
    }

    @Suppress("UNCHECKED_CAST")
    override fun adapt(call: Call<T>): Any {
        if (ramType == Completable::class.java) {
            return (wrapped as CallAdapter<T, Completable>).adapt(call)
                .onErrorResumeNext { throwable ->
                    Completable.error(asException(throwable))
                }
        }
        return (wrapped as CallAdapter<T, Observable<Any>>)
            .adapt(call)
            .onErrorResumeNext { t: Throwable -> Observable.error(asException(t)) }
    }

    private fun asException(throwable: Throwable): Exception {
        //Tratar aqui exceptions
        return java.lang.Exception(throwable)
    }
}