package com.github.vectorway.vectorway.data

data class NewsData(
    var imageUrl: String? = null,
    var newsTitle: String? = null,
    var newsText: String? = null,
    var isChoose: Boolean = false,
    var textBtnAgree: String? = null,
    var textBtnDisagree: String? = null,
    var cardLinkToNews: String? = null
    )