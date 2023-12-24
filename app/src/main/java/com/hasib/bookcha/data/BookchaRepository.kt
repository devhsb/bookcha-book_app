package com.hasib.bookcha.data

import com.hasib.bookcha.Network.BookchaApiService
import com.hasib.bookcha.model.BookchaModel
import com.hasib.bookcha.ui.bookchaViewModel.BookchaViewModel
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface BookchaRepository {
    suspend fun getBooks() : BookchaModel
}

private class NetworkBookchaRepository(var bookQuery: String) : BookchaRepository {
    private val json = Json{ignoreUnknownKeys = true}
    private val api_url = "https://www.googleapis.com/"
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(api_url)
        .build()

    private val getRetrofitApi  by lazy {
        retrofit.create(BookchaApiService::class.java)
    }

    override suspend fun getBooks(): BookchaModel =
            getRetrofitApi.getBooks("https://www.googleapis.com/books/v1/volumes?q=${bookQuery}")
}

object ListOfBooks{
    suspend fun getListOFBooks(): MutableList<BookchaModel> {
        return mutableListOf(
            NetworkBookchaRepository("Business&orderBy=newest").getBooks(),
            NetworkBookchaRepository("Science&orderBy=newest").getBooks(),
            NetworkBookchaRepository("Romance&orderBy=newest").getBooks(),
            NetworkBookchaRepository("Fashion&orderBy=newest").getBooks(),
            NetworkBookchaRepository("Technology&orderBy=newest").getBooks(),
            NetworkBookchaRepository("filter=free-ebooks&maxResults=40").getBooks(),
            NetworkBookchaRepository("filter=paid-ebooks&maxResults=40").getBooks()
        )
    }
}