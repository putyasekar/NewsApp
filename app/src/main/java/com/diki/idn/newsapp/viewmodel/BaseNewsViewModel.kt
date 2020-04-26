package com.diki.idn.newsapp.viewmodel

import com.diki.idn.newsapp.model.ApiResponse
import com.diki.idn.newsapp.model.ArticlesItem
import com.diki.idn.newsapp.sources.RetrofitConfig
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class BaseNewsViewModel(private val listener: OnFinishedListener<List<ArticlesItem>>) {
    private val compositeDisposable = CompositeDisposable()
    fun fetchNewsData(news: String) {
        compositeDisposable.add(
            RetrofitConfig.apiServiceClient.getHeadlineNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleNext, this::handleError)
        )
    }

    private fun handleNext(newsItem: ApiResponse) {
        val newsItem = newsItem.articles
        listener.success(newsItem as List<ArticlesItem>)
    }

    private fun handleError(throwable: Throwable) {
        listener.failure(throwable.message)
    }
}