package com.diki.idn.newsapp.viewmodel

import com.diki.idn.newsapp.model.ArticlesItem

class NewsViewModel(private var view: AppBaseInterface<List<ArticlesItem>>?) :
    OnFinishedListener<List<ArticlesItem>> {
    override fun success(data: List<ArticlesItem>) {
        view?.hideProgressBar()
        view?.showData()
    }

    override fun failure(message: String?) {
        view?.hideProgressBar()
        view?.showError(message)
    }
}