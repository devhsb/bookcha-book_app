package com.hasib.bookcha.Network

import com.hasib.bookcha.model.BookchaModel
import com.hasib.bookcha.ui.bookchaViewModel.BookchaViewModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface BookchaApiService {
    @GET
    suspend fun getBooks(@Url bookQuery: String) : BookchaModel
}