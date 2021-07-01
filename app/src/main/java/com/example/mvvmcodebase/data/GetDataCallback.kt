package com.example.mvvmcodebase.data

interface GetDataCallback<T> {

    fun onSuccess(data: T)
    fun onFailed()
}
