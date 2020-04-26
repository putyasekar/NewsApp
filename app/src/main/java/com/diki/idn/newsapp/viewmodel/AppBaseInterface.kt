package com.diki.idn.newsapp.viewmodel

interface AppBaseInterface<T> {
    fun hideProgressBar()
    fun showData()
    fun showError(message: String?)
}