package com.diki.idn.newsapp.viewmodel

interface OnFinishedListener<T> {
    fun success(data: T)
    fun failure(message: String?)
}
